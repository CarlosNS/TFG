/*
 * Clase para el manejo de la clase tablaFrecuencias, consistente en un par
 * 
 */
package Funcionalidad;

import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Naranjo Sánchez
 */
public class tablaFrecuencias {

    private final LinkedList<Letra> lista;

    private boolean procesada;
    private int fin;
    private int cuenta;

    public int getFin() {
        return fin;
    }

    public tablaFrecuencias() {
        lista = new LinkedList<>();
        procesada = false;
        cuenta = fin = 0;
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

    public void procesar() {
        if (!procesada) {lista.stream().forEach((lista1) -> {
                lista1.fr /= cuenta;
            });
            procesada = true;
        }
    }

    public Letra valor(int i) {
        if (i <= fin) {return lista.get(i);}
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

        if (procesada) {
            return lista;
        } else {
            try {
                throw new Exception("No se puede devolver una lista no procesada");
            } catch (Exception ex) {
                Logger.getLogger(tablaFrecuencias.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

}
