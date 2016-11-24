package Huffman;

import Funcionalidad.Letra;
import java.util.*;

public class CodigoHuffman {

    public static ArbolHuffman construyeArbol(LinkedList<Letra> frecChar) {

        PriorityQueue<ArbolHuffman> arboles = new PriorityQueue<>();

        // Inicialmente tenemos un bosque de hojas
        // una para cada caracter no vacio
        frecChar.stream().forEach((i) -> {
            arboles.offer(new HojaHuffman(i.fr, i));
        });

        assert arboles.size() > 0;
        // repetir hasta que sólo quede un árbol a la izquierda
        while (arboles.size() > 1) {
            //poll quita la cabeza
            ArbolHuffman a = arboles.poll();
            ArbolHuffman b = arboles.poll();

            // put into new node and re-insert into queue
            arboles.offer(new ArbolHuffman.NodoHuffman(a, b));
        }
        return arboles.poll();
    }

    public static ArbolHuffman Huffman(LinkedList<Letra> listaLetras) {
        return construyeArbol(listaLetras);
    }
    
    public static ArbolHuffman Doble(LinkedList<Letra> uno, LinkedList<Letra> dos){
        return new ArbolHuffman.NodoHuffman(construyeArbol(uno), construyeArbol(dos));
    }

}
