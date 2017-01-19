/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Clase que contiene el numero de la letra, la letra, y su frecuencia
 *
 * @author Carlos Naranjo Sánchez
 */
public class Letra implements Serializable {

    public final String caracter;
    public double fr;
    public final int n;

    public Letra(char letra, double f) {
        this.fr = f;
        n = letra;
        String dentro;

        switch (letra) {
            case 3:
                dentro = "Final de texto";
                break;
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
        }
        this.caracter = dentro;
    }

    /**
     * Sobreescritura del método para comparar que dos "letras" son iguales
     *
     * @param o la suspuesta letra a comprobar
     * @return true si la letra es igual, false si no
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Character) {
            return o == caracter;
        } else if (o instanceof Letra) {
            Letra nuevo = (Letra) o;
            return n == (nuevo.n);
        }
        return false;
    }

    /**
     * Para transformar una letra y su informacion
     *
     * @return "Codigo: 3 Caracter: "e" Frecuencia: 2.354E-4"
     */
    @Override
    public String toString() {
        //return ("Codigo: " + this.n + "\tCaracter: \"" + caracter + "\"\tFrecuencia: " + fr);
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return ("Codigo: " + this.n + "\tCaracter: \"" + caracter + "\"\tFrecuencia: " + df.format(fr));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.caracter);
        return hash;
    }

}
