/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Huffman.ArbolHuffman;
import Huffman.CodigoHuffman;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.log;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Enrique
 */
public class Principal {

    static JTextArea consola;
    private ArbolHuffman dic;
    private double frecmax;

    public ArbolHuffman getDic() {
        return dic;
    }
    
    /**
     * 
     * @return La frecuencia max de repeticion de un caracter
     */
    public double getfrecmax(){
        return frecmax;
    }
    
    
    public Principal(JTextArea jt){
        consola=jt;
    }
    public float lectura(String texto) {
        try {
                    
            tablaFrecuencias tf = new tablaFrecuencias();
        
            FileInputStream fis = new FileInputStream(texto);
            InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
            BufferedReader bf = new BufferedReader(is);
                       
            
            int car;
            car = bf.read();
            while(car != -1 ){
                tf.insertar((char) car);
                car = bf.read();
            }
            tf.ordenar();
            
            tf.procesar();
            frecmax = tf.getLista().get(0).fr;
            
            dic= Huffman.CodigoHuffman.Huffman(tf.getLista());
            consola.setText(tf.toString());
            return entropia(tf);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private static float entropia(tablaFrecuencias tf) {
        float cuenta=0;
        for (int i = 0; i < tf.getFin(); i++) {
            cuenta+=tf.valor(i).fr*(log(tf.valor(i).fr)/log(2));
        }
        return -cuenta;
    }
    
    
    
}
