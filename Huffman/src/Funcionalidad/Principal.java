/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Huffman.ArbolHuffman;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Carlos Naranjo Sánchez
 */
public class Principal {

    static JTextArea consola;
    private ArbolHuffman dic;
    private double frecmax;
    private String tipo = "normal";
    private TablaFrecuencias tf;

    public ArbolHuffman getDic() {
        return dic;
    }

    public void setPartido() {
        tipo = "partido";
    }
    public void setRepartido() {
        tipo = "repartido";
    }
    public void setNormal(){
        tipo="normal";
    }

    /**
     *
     * @return La frecuencia max de repeticion de un caracter
     */
    public double getfrecmax() {
        return frecmax;
    }

    public Principal(JTextArea jt) {
        consola = jt;
    }

    /**
     * Método para inicializar el árbol Huffman para que después si encuentra
     * algún carácter desconocido no ocurra ningún error
     *
     * @param tf El objeto contenedor de las letras
     */
    private void constructor(TablaFrecuencias tf) {
        char relleno[] = new char[190];

        //Ascii normales
        for (int i = 32; i < 127; i++) {
            relleno[i - 32] = (char) i;
        }

        //ISO 8859-1
        for (int i = 161; i < 256; i++) {
            relleno[i - 161 + 95] = (char) i;
        }

        for (int i = 0; i < relleno.length; i++) {
            tf.insertar(relleno[i]);
        }
    }

    public float lectura(String ruta, boolean principio) {
        try {

            tf = new TablaFrecuencias();

            if (principio) {
                constructor(tf);
            }

            FileInputStream fis = new FileInputStream(ruta);
            InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
            BufferedReader bf = new BufferedReader(is);

            int car;
            car = bf.read();
            while (car != -1) {
                tf.insertar((char) car);
                car = bf.read();
            }
            //insertar char final
            car = 3;
            tf.insertar((char) car);

            tf.ordenar();
            tf.procesar();
            
            frecmax = tf.getLista().get(0).fr;   
            consola.setText(tf.toString());
            return entropia(tf);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void escritura(){
        switch (tipo) {
                case "normal":
                    dic = Huffman.CodigoHuffman.Huffman(tf.getLista());

                    break;
                case "partido":
                    TablaFrecuencias primera = tf.subTabla(0, tf.getFin() / 2);
                    TablaFrecuencias segunda = tf.subTabla(tf.getFin() / 2, tf.getFin());

                    dic = Huffman.CodigoHuffman.Doble(primera.getLista(), segunda.getLista());

                    break;
                case "repartido":
                    ArrayList<TablaFrecuencias> dev = tf.Repartida();
                     dic = Huffman.CodigoHuffman.Doble(dev.get(0).getLista(), dev.get(1).getLista());
                    break;
            }
    }
    
    private static float entropia(TablaFrecuencias tf) {
        float cuenta = 0;
        for (int i = 0; i < tf.getFin(); i++) {
            cuenta += tf.valor(i).fr * (log(tf.valor(i).fr) / log(2));
        }
        return -cuenta;
    }

}
