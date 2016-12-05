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

    public int getCuenta() {
        return cuenta;
    }

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
                dev.insertar((char) lista.get(i).n);
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
            if(i%2==0){
                uno.insertar((char) lista.get(i).n);
            }else{
                dos.insertar((char) lista.get(i).n);
            }
        }
        return dev;
    }

    //10 es salto de linea, 13, retorno de carro
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

    public Letra valor(int i) {
        if (i <= fin) {
            return lista.get(i);
        }
        System.err.println("Error en tablaFrecuencias");
        return null;
    }

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

    /*
    Ordena de mayor a menor
     */
    void ordenar() {
        Collections.sort(lista, (Letra arg0, Letra arg1) -> Double.compare(arg1.fr, arg0.fr));
    }

    public LinkedList<Letra> getLista() {
        return lista;
    }

}
