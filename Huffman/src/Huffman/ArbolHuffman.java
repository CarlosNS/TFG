/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import Funcionalidad.Letra;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author unake
 */
public abstract class ArbolHuffman implements Comparable<ArbolHuffman>, Serializable {

    public final int id;
    public final double frequency; // la frecuencia del arbol

    public ArbolHuffman(double freq) {
        frequency = freq;
        id = new Random(System.currentTimeMillis()).nextInt();
    }

    public int getId() {
        return id;
    }

    // compares on the frequency
    @Override
    public int compareTo(ArbolHuffman tree) {
        return Double.compare(frequency, tree.frequency);
    }

    public String imprimirCodigos() {
        StringBuffer dev = new StringBuffer();
        imprimirCodigos(this, new StringBuffer(), dev);
        return dev.toString();
    }

    private void imprimirCodigos(ArbolHuffman arbol, StringBuffer prefix, StringBuffer res) {
        assert arbol != null;
        if (arbol instanceof HojaHuffman) {
            HojaHuffman leaf = (HojaHuffman) arbol;

            res.append(leaf.letras + "\t" + prefix.toString() + "\n");

        } else if (arbol instanceof NodoHuffman) {
            NodoHuffman node = (NodoHuffman) arbol;

            // traverse izquierda
            prefix.append('0');
            imprimirCodigos(node.izquierda, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse derecha
            prefix.append('1');
            imprimirCodigos(node.derecha, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}

class HojaHuffman extends ArbolHuffman implements Serializable {

    public final Letra letras; // the character this leaf represents

    public Letra getLetras() {
        return letras;
    }

    public HojaHuffman(double freq, Letra val) {
        super(freq);
        letras = val;
    }
}

class NodoHuffman extends ArbolHuffman implements Serializable {

    public final ArbolHuffman izquierda, derecha; // subarboles

    public NodoHuffman(ArbolHuffman l, ArbolHuffman r) {
        super(l.frequency + r.frequency);
        izquierda = l;
        derecha = r;
    }
}
