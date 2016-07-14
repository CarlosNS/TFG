package Huffman;

import Funcionalidad.Letra;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



public class CodigoHuffman {

    // input is an array of frequencies, indexed by character code
    public static ArbolHuffman construyeArbol(LinkedList<Letra> frecChar) {
        PriorityQueue<ArbolHuffman> arboles = new PriorityQueue<>();
        // Inicialmente tenemos un bosque de hojas
        // una para cada caracter no vacio
        frecChar.stream().forEach((i) -> {
            arboles.offer(new HojaHuffman(i.fr, i));
        });

        assert arboles.size() > 0;
        // loop until there is only one tree izquierda
        while (arboles.size() > 1) {
            // two trees with least frequency
            //poll quita la cabeza
            ArbolHuffman a = arboles.poll();
            ArbolHuffman b = arboles.poll();

            // put into new node and re-insert into queue
            arboles.offer(new NodoHuffman(a, b));
        }
        return arboles.poll();
    }


    /**
     *
     * @param arbol
     * @param prefix
     * @param dicci String vacio
     */
    private static void crearDicc(ArbolHuffman arbol, StringBuffer prefix, FileWriter fic) throws IOException {
        assert arbol != null;
        if (arbol instanceof HojaHuffman) {
            HojaHuffman leaf = (HojaHuffman) arbol;

            fic.write(leaf.letras.n + "\t" + prefix + "\n");

        } else if (arbol instanceof NodoHuffman) {
            NodoHuffman nodo = (NodoHuffman) arbol;

            // rama izquierda
            prefix.append('0');
            crearDicc(nodo.izquierda, prefix, fic);
            prefix.deleteCharAt(prefix.length() - 1);

            // rama derecha
            prefix.append('1');
            crearDicc(nodo.derecha, prefix, fic);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    
    public static ArbolHuffman Huffman(LinkedList<Letra> args) {

        return construyeArbol(args);
    }


}
