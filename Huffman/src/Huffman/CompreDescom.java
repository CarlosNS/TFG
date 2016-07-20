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
import java.util.Collection;
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
    
    private float longitud;

    public float getLongitud() {
        return longitud;
    }
    
    

    public static void escribeDicci(ArbolHuffman arbol, String nombreDicc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreDicc))) {
            oos.writeObject(arbol);
            oos.close();
        }

    }

    /**
     * Dada una ruta absoluta a un diccionario Huffman, lo lee y lo prepara para
     * el programa
     * @param ruta La ruta al diccionario Huffman
     * @return Devuelve una estructura de árbol Huffman
     */
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

    /**
     * Función para descomprimir un archivo codificado con un diccionario
     * Huffman
     * @param ruta la ruta al archivo comprimido
     * @param dic el diccionario con el se comprimió el texto
     * @throws IOException 
     */
    public static void decodificar(String ruta, ArbolHuffman dic) throws IOException {
        try (BitInputStream textoCod = new BitInputStream(ruta); BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + "_deco.txt"))) {

            ArbolHuffman actual = dic;
            int bit = textoCod.readBits(1);
            while (bit != -1) {
                actual = decodifica((NodoHuffman) actual, bit);
                if (actual instanceof HojaHuffman) {
                    bw.write((char)((HojaHuffman) actual).letras.n);
                    actual = dic;
                }
                bit = textoCod.readBits(1);
            }
            textoCod.close();
        }
    }

    /**
     * Utilidad para moverse por el árbol
     * @param nodo nodo actual
     * @param bit bit que indica izquierda o derecha
     * @return nodo siguiente
     */
    private static ArbolHuffman decodifica(NodoHuffman nodo, int bit) {
        if (bit == 0) {
            return nodo.izquierda;
        } else {
            return nodo.derecha;
        }
    }

    /**
     * Funciona para decoficar una cadena de 0,1s que terminará en -1
     *
     * @param dicc el diccionario huffman
     * @param texto
     * @param nuevo
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void codificar(ArbolHuffman dicc, String texto, String nuevo) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        HashMap<Integer, String> d = creaDicc(dicc);
        char[] codigoBinario;

        FileInputStream fis = new FileInputStream(texto);
        InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
        try (BufferedReader bf = new BufferedReader(is); BitOutputStream bos = new BitOutputStream(nuevo)) {
            
            int caracter;
            caracter = bf.read();
            while (caracter != -1) {
                codigoBinario = d.get(caracter).toCharArray();
                
                for (int i = 0; i < codigoBinario.length; i++) {
                    bos.writeBits(1, Integer.valueOf(codigoBinario[i]));
                }
                caracter = bf.read();
            }
            bf.close();
            bos.close();
        }
    }

    /**
     * A partir de un árbol Huffman, crea un diccionario clave valor
     * @param dicc el árbol Huffman
     * @return el diccionario clave valor
     */
    private static HashMap<Integer, String> creaDicc(ArbolHuffman dicc) {
        HashMap<Integer, String> d = new HashMap<>();
        
        construyeMap(dicc, new StringBuffer(), d);
        //TODO
        Collection<String> add = d.values();
        double n=0;
        for (String s : add) {
            n+=s.length();
        }
        n/=add.size();
        System.out.println("Tama = " + n);
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
