/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrique
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
        //System.out.println("Leo " + letra +" :"+ (int)letra+"\n");
        //System.out.println("_______________");
        /*
        String dentro;
        switch ((int) letra) {
            case 10:
                dentro = "Salto de linea";
                break;
            case 13:
                dentro = "Retorno de carro";
                break;
            case 32:
                dentro = "Espacio";
                break;
            default:
                dentro = String.valueOf(letra);

        }*/
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
        if (!procesada) {
            for (Letra lista1 : lista) {
                lista1.fr /= cuenta;
            }
            procesada = true;
        }
    }

    public Letra valor(int i) {
        if (i <= fin) {
            return lista.get(i);
        }
        System.err.println("");
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
        for (Letra lista1 : lista) {
            dev += lista1.toString() + "\n";
        }
        return dev;
    }

    /*
    Ordena de mayor a menor
    */
    void ordenar() {
        Collections.sort(lista, new Comparator<Letra>() {
            @Override
            public int compare(Letra arg0, Letra arg1) {
                return Double.compare(arg1.fr, arg0.fr);
            }
        }
        );
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
