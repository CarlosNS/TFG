package Huffman;

import Funcionalidad.Letra;
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

    public static ArbolHuffman Huffman(LinkedList<Letra> args) {

        return construyeArbol(args);
    }


}
