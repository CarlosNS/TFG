/*
 * Clase para el manejo de la clase TablaFrecuencias, consistente en un una
 * lista de objetos clase Letras
 */
package Funcionalidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Carlos Naranjo Sánchez
 */
public class TablaFrecuencias {

    private final LinkedList<Letra> lista;

    private boolean procesada;
    private int fin;
    private int cuenta;

    /**
     * Devuelve el número de inserciones en el objeto
     *
     * @return entero con el numero de inserciones
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * Devuelve el número de carácteres distintos introducidos
     *
     * @return el número de carácteres distintos introducidos
     */
    public int getFin() {
        return fin;
    }

    public TablaFrecuencias() {
        lista = new LinkedList<>();
        procesada = false;
        cuenta = fin = 0;
    }

    public TablaFrecuencias subTabla(int inicio, int fin) throws IndexOutOfBoundsException {
        if (procesada && inicio >= 0 && fin <= this.fin) {
            TablaFrecuencias dev = new TablaFrecuencias();
            for (int i = inicio; i < fin; i++) {
                dev.insertar(lista.get(i));
            }
            return dev;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ArrayList<TablaFrecuencias> Repartida() {
        TablaFrecuencias uno, dos;
        uno = new TablaFrecuencias();
        dos = new TablaFrecuencias();
        ArrayList<TablaFrecuencias> dev = new ArrayList<>();
        dev.add(uno);
        dev.add(dos);

        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                uno.insertar(lista.get(i));
            } else {
                dos.insertar(lista.get(i));
            }
        }
        return dev;
    }

    //10 es salto de linea, 13, retorno de carro
    /**
     *
     * @param letra el char a insertar
     * @return true si el char ha sido introducido correctamente, false de lo
     * contrario.
     */
    public boolean insertar(char letra) {

        if (!procesada) {
            int sitio = lista.indexOf(new Letra(letra, 0));
            if (sitio != -1) {
                lista.get(sitio).fr++;
            } else {
                lista.add(fin, new Letra(letra, 1));
                fin++;
            }
            cuenta++;
            return true;
        } else {
            return false;
        }
    }

    public boolean insertar(Letra letra) {

        boolean entra = !lista.contains(letra);

        if (!procesada && entra) {
            lista.add(fin, letra);
            cuenta++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Función para calcular la probabilidad de cada letra
     */
    public void procesar() {
        if (!procesada) {
            lista.stream().forEach((lista1) -> {
                lista1.fr /= cuenta;
            });
            procesada = true;
        }
    }

    /**
     * Devuelve el objeto Letra de la posición i
     *
     * @param i posición en la lista
     * @return el objeto Letra en esa posición
     */
    public Letra valor(int i) {
        if (i <= fin) {
            return lista.get(i);
        }
        System.err.println("Error en tablaFrecuencias");
        return null;
    }

    /**
     * Función auxiliar para vaciar eñ pbjeto
     */
    public void vaciar() {
        fin = cuenta = 0;
        procesada = false;
        lista.clear();
    }

    @Override
    public String toString() {
        String dev = "";
        dev = lista.stream().map((lista1) -> lista1.toString() + "\n").reduce(dev, String::concat);
        return dev;
    }

    /**
     * Ordena el el objeto según la frecuencia de los objetos Letras
     */
    void ordenar() {
        Collections.sort(lista, (Letra arg0, Letra arg1) -> Double.compare(arg1.fr, arg0.fr));
    }

    /**
     * Devuelve el array interno de Letras
     *
     * @return
     */
    public LinkedList<Letra> getLista() {
        return lista;
    }

}
