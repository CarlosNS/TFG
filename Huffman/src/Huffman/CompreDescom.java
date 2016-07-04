/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabajarBits.BitInputStream;
import trabajarBits.BitOutputStream;

/**
 *
 * @author carlos
 */
public class CompreDescom {

    public static void escribeDicci(ArbolHuffman arbol, String nombreDicc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreDicc))) {
            oos.writeObject(arbol);
            oos.close();
        }

    }

    public static ArbolHuffman leeDicc(String ruta) {
        try {
            Object arbol;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
                arbol = ois.readObject();
            }
            return (ArbolHuffman) arbol;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CompreDescom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void decodificar(String ruta, ArbolHuffman dic) throws IOException {
        try (BitInputStream textoCod = new BitInputStream(ruta)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + "_deco.txt"));

            ArbolHuffman actual = dic;
            int bit = textoCod.readBits(1);
            while (bit != -1) {
                actual = decodifica((NodoHuffman) actual, bit);
                if (actual instanceof HojaHuffman) {
                    //System.out.println((char)((HojaHuffman) actual).letras.n);
                    bw.write((char)((HojaHuffman) actual).letras.n);
                    actual = dic;
                }
                bit = textoCod.readBits(1);
            }
            textoCod.close();
            bw.close();
        }
    }

    private static ArbolHuffman decodifica(NodoHuffman nodo, int bit) {
        if (bit == 0) {
            return nodo.izquierda;
        } else {
            return nodo.derecha;
        }
    }

    private static void decodificarInte(ArbolHuffman raiz, ArbolHuffman actual, BitInputStream ent, StringBuffer leo) throws IOException {
        int bit = ent.readBits(1);

        if (actual instanceof HojaHuffman) {
            HojaHuffman n = (HojaHuffman) actual;
            leo.append((char) n.letras.n);
            actual = raiz;
        }

        if (bit != -1) {
            if (actual instanceof NodoHuffman) {
                NodoHuffman nh = (NodoHuffman) actual;
                //ind++;
                switch (bit) {
                    case 0:
                        decodificarInte(raiz, nh.izquierda, ent, leo);
                        break;
                    case 1:
                        decodificarInte(raiz, nh.derecha, ent, leo);
                        break;
                }
            }
        }

    }

    /**
     * Funciona para decoficar una cadena de 0,1s que terminará en -1
     *
     * @param dicc el diccionario huffman
     * @param numeros
     * @param ind
     * @return un string que contiene el texto descodificado
     */
    public static void codificar(ArbolHuffman dicc, String texto, String nuevo) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        HashMap<Integer, String> d = creaDicc(dicc);
        String codigoBinario;

        FileInputStream fis = new FileInputStream(texto);
        InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
        try (BufferedReader bf = new BufferedReader(is); BitOutputStream bos = new BitOutputStream(nuevo)) {
            
            int caracter;
            caracter = bf.read();
            while (caracter != -1) {
                codigoBinario = d.get(caracter);
                for (int i = 0; i < codigoBinario.length(); i++) {
                    bos.writeBits(1, Integer.valueOf(codigoBinario.substring(i, i + 1)));
                }
                caracter = bf.read();
            }
            bf.close();
            bos.close();
        }
    }

    private static HashMap<Integer, String> creaDicc(ArbolHuffman dicc) {
        HashMap<Integer, String> d = new HashMap<>();
        construyeMap(dicc, new StringBuffer(), d);
        return d;
    }

    private static void construyeMap(ArbolHuffman arbol, StringBuffer prefix, HashMap<Integer, String> d) {
        assert arbol != null;
        if (arbol instanceof HojaHuffman) {
            HojaHuffman leaf = (HojaHuffman) arbol;

            d.put(leaf.letras.n, prefix.toString());

        } else if (arbol instanceof NodoHuffman) {
            NodoHuffman nodo = (NodoHuffman) arbol;

            // rama izquierda
            prefix.append('0');
            construyeMap(nodo.izquierda, prefix, d);
            prefix.deleteCharAt(prefix.length() - 1);

            // rama derecha
            prefix.append('1');
            construyeMap(nodo.derecha, prefix, d);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}
