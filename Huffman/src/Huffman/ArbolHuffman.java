package Huffman;

import Funcionalidad.Letra;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Carlos Naranjo Sánchez
 */
public abstract class ArbolHuffman implements Comparable<ArbolHuffman>, Serializable {

    public final int id;
    public final double frecuencia; // la frecuencia del arbol

    public ArbolHuffman(double freq) {
        frecuencia = freq;
        id = new Random(System.currentTimeMillis()).nextInt();
    }

    public int getId() {
        return id;
    }

    // compares on the frecuencia
    @Override
    public int compareTo(ArbolHuffman tree) {
        return Double.compare(frecuencia, tree.frecuencia);
    }

    /**
     * Método que permite previsualizar los códigos que tendrán los nodos del
     * árbol huffman
     * @return un string donde están contenidos todos los carácteres con sus
     * códigos
     */
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

    /**
     *
     * @author Carlos
     */
    static class NodoHuffman extends ArbolHuffman implements Serializable {

        public final ArbolHuffman izquierda;
        public final ArbolHuffman derecha; // subarboles

        public NodoHuffman(ArbolHuffman l, ArbolHuffman r) {
            super(l.frecuencia + r.frecuencia);
            izquierda = l;
            derecha = r;
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

