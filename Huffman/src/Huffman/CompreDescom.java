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
import Excepciones.*;
import java.io.OutputStreamWriter;

/**
 *
 * @author Carlos Naranjo Sánchez
 */
public class CompreDescom {

    private static float Longitud = 0;

    /**
     * Función para crear un archivo que contendrá el árbol usado como
     * diccionario
     *
     * @param arbol el árbol a guardar
     * @param nombreDicc el nombre que tendrá el archivo
     * @throws IOException
     */
    public static void escribeDicci(ArbolHuffman arbol, String nombreDicc) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreDicc+".dhf"))) {
            oos.writeObject(arbol);
            oos.close();
        }
    }

    /**
     * Dada una ruta absoluta a un diccionario Huffman, lo lee y lo prepara para
     * el programa
     *
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
     *
     * @param ruta la ruta al archivo comprimido
     * @param dic el diccionario con el se comprimió el texto
     * @throws IOException
     * @throws Excepciones.ExcepcionDiccionarioIncompleto
     */
    public static void decodificar(String ruta, ArbolHuffman dic) throws IOException, ExcepcionDiccionarioIncompleto {
        try (BitInputStream textoCod = new BitInputStream(ruta); 
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta + "_deco.txt"),"8859_1"))) {

            ArbolHuffman actual = dic;
            int bit = textoCod.readBits(1);
            boolean finalEncontrado = false;
            int letraLeida;
            boolean errorNodo = false;
            //el caracter 3 es final de texto
            while (!finalEncontrado && !errorNodo && bit!=-1) {
                try {
                    actual = decodifica((ArbolHuffman.NodoHuffman) actual, bit);
                } catch (ExcepcionNodoInexistente ex) {
                    errorNodo = true;
                    throw new ExcepcionDiccionarioIncompleto("Diccionario incorrecto");
                }
                if (actual instanceof HojaHuffman) {
                    letraLeida = ((HojaHuffman) actual).letras.n;
                    if (letraLeida == 3) {
                        finalEncontrado = true;
                    } else {
                        bw.write((char) letraLeida);
                    }
                    actual = dic;
                }
                bit = textoCod.readBits(1);
            }
            textoCod.close();
        }
    }

    /**
     * Utilidad para moverse por el árbol
     *
     * @param nodo nodo actual
     * @param bit bit que indica izquierda o derecha
     * @return nodo siguiente
     */
    private static ArbolHuffman decodifica(ArbolHuffman.NodoHuffman nodo, int bit) throws ExcepcionNodoInexistente {
        if (bit == 0) {
            if (nodo.izquierda != null) {
                return nodo.izquierda;
            } else {
                throw new ExcepcionNodoInexistente("nodo inexistente");
            }
        } else if (nodo.derecha != null) {
            return nodo.derecha;
        } else {
            throw new ExcepcionNodoInexistente("nodo inexistente");
        }

    }

    /**
     * Funciona para decoficar una cadena de 0,1s que terminará en -1
     *
     * @param dicc el diccionario huffman
     * @param rutaTexto la ruta al txt seleccionado
     * @param nuevo el nombre del nuevo archivo
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     * @throws Excepciones.ExcepcionNoExisteEnDicc
     */
    public static void codificar(ArbolHuffman dicc, String rutaTexto, String nuevo) throws FileNotFoundException, UnsupportedEncodingException, IOException, ExcepcionNoExisteEnDicc {
        HashMap<Integer, String> d = creaDicc(dicc);
        char[] codigoBinario;

        FileInputStream fis = new FileInputStream(rutaTexto);
        InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
        try (BufferedReader bf = new BufferedReader(is); BitOutputStream bos = new BitOutputStream(nuevo+".chf")) {

            int caracter;
            caracter = bf.read();
            while (caracter != -1) {
                if (!d.containsKey(caracter)) {
                    throw new ExcepcionNoExisteEnDicc("El caracter '" + (char) caracter + "' no se encuentra en el diccionario");
                }
                codigoBinario = d.get(caracter).toCharArray();

                for (int i = 0; i < codigoBinario.length; i++) {
                    bos.writeBits(1, Integer.valueOf(codigoBinario[i]));
                }
                caracter = bf.read();
            }

            //Fin de texto es char 3
            codigoBinario = d.get(3).toCharArray();

            for (int i = 0; i < codigoBinario.length; i++) {
                bos.writeBits(1, Integer.valueOf(codigoBinario[i]));
            }

            bf.close();
            bos.close();
        }
    }

    /**
     * A partir de un árbol Huffman, crea un diccionario clave valor
     *
     * @param dicc el árbol Huffman
     * @return el diccionario clave valor
     */
    private static HashMap<Integer, String> creaDicc(ArbolHuffman dicc) {
        HashMap<Integer, String> d = new HashMap<>();
        construyeMap(dicc, new StringBuffer(), d);
        return d;
    }

    /**
     * Método para calcular la longitud con la fórmula L(C)=S[Pk*Lk]
     *
     * @param dicc el diccionario o árbol al que calcularle la longitud
     * @return la longitud media
     */
    public static float DameLongitud(ArbolHuffman dicc) {
        Longitud = 0;
        dameLongitud(dicc, new StringBuffer());
        return Longitud;
    }

    /**
     * Método recuersivo auxiliar para calcular la longitud media
     *
     * @param arbol
     * @param prefix la cadena donde se guardaran las palabras-código
     */
    private static void dameLongitud(ArbolHuffman arbol, StringBuffer prefix) {
        assert arbol != null;
        if (arbol instanceof HojaHuffman) {
            HojaHuffman leaf = (HojaHuffman) arbol;
            Longitud += leaf.frecuencia * prefix.length();

        } else if (arbol instanceof ArbolHuffman.NodoHuffman) {
            ArbolHuffman.NodoHuffman nodo = (ArbolHuffman.NodoHuffman) arbol;

            // rama izquierda
            prefix.append('0');
            dameLongitud(nodo.izquierda, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // rama derecha
            prefix.append('1');
            dameLongitud(nodo.derecha, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private static void construyeMap(ArbolHuffman arbol, StringBuffer prefix, HashMap<Integer, String> d) {
        assert arbol != null;
        if (arbol instanceof HojaHuffman) {
            HojaHuffman leaf = (HojaHuffman) arbol;
            d.put(leaf.letras.n, prefix.toString());

        } else if (arbol instanceof ArbolHuffman.NodoHuffman) {
            ArbolHuffman.NodoHuffman nodo = (ArbolHuffman.NodoHuffman) arbol;

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
