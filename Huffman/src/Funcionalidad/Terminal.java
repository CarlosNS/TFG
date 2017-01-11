/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Excepciones.ExcepcionDiccionarioIncompleto;
import Excepciones.ExcepcionNoExisteEnDicc;
import Graficos.Interfaz;
import Huffman.CompreDescom;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Terminal {
    static Principal p;
    public static void main(String[] args) {
        if(args.length==0){
            Interfaz.main(args);
        }else if(args.length==1){
            if(args[0].equals("ayuda")){
                ayuda();
            }
        }else if(args.length>1){
            switch(args[0]){
                case "-di":
                    crear(args);
                    break;
                case "-co":
                    comprimir(args);
                    break;
                case "-de":
                    descomprimir(args);
                    break;
            }
        }
    }

    private static void crear(String[] args) {
        if(args.length==3){
            try {
                p = new Principal(null);
                p.lectura(args[1], true);
                p.escritura();
                //CompreDescom.escribeDicci(frec.getDic(), ubicacionGuardarDicc.getAbsolutePath());
                CompreDescom.escribeDicci(p.getDic(), args[2]);
                System.out.println("Diccionario creado con el nombre \" "+args[2]+"\"");
            } catch (IOException ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("El formato de argumentos para creación de dilcionarios es \"-di\" + archivo a analizar");
        }
    }

    private static void comprimir(String[] args) {
        if(args.length==4){
            try {
                CompreDescom.codificar(CompreDescom.leeDicc(args[1]), args[2], args[3]);
            } catch (IOException | ExcepcionNoExisteEnDicc ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("El formato de argumentos para compresión es \"-co\" + dhf + archivos a comprimir");
        }
    }

    private static void descomprimir(String[] args) {
        if(args.length==3){
            try {
                CompreDescom.decodificar(args[2], CompreDescom.leeDicc(args[1]));
            } catch (IOException | ExcepcionDiccionarioIncompleto ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("El formato de argumentos para descompresión es \"-de\" + dhf + archivo a descomprimir");
        }
    }

    /**
     * Muestra información del programa
     */
    private static void ayuda() {
        System.out.println("NOMBRE");
        System.out.println("\tHuffman - Lanza el porgrama el modo gráfico");
        salto(1);
        
        System.out.println("SINOPSIS");
        System.out.println("\tHuffman [OPCIÓN]... [DICCIONARIO]... [ARCHIVO]..."
                + " [NUEVO ARCHIVO]");
        salto(1);
        
        System.out.println("DESCRIPCION");
        System.out.println("\tPrograma usado para compresión y descompresión de"
                + " textos que usen el estándar ISO-LATÍN-1. Los diccionarios "
                + "deben ser archivos dhf, y los comprimidos chf.");
        System.out.println("\tLas opciones disponibles son:");
        
        salto(1);
        System.out.println("\t-di ARCHIVO RESULTADO");
        System.out.println("\t\tAnaliza el archivo de texto ARCHIVO y crea un "
                + "diccionario Huffman con comienzo estándar llamado"
                + " RESULTADO+\".dhf\"");
        
        salto(1);
        System.out.println("\t-co DICCIONARIO ARCHIVO RESULTADO");
        System.out.println("\t\tComprime el archivo de texto ARCHIVO usando el"
                + "diccionario DICCIONARIO en un archivo resultante RESULTADO"
                + "+\".chf\"");
        
        salto(1);
        System.out.println("\t-de DICCIONARIO ARCHIVO");
        System.out.println("\t\tUsando el diccionario DICCIONARIO descomprime"
                + "el archivo comprimirdo ARCHIVO en la ubicación del mismo");
        salto(1);
        
        System.out.println("AUTOR");
        System.out.println("\tCarlos Naranjo Sánchez. 2016");
    }
    
    /**
     * Función auxiliar para saltos de linea
     * @param i 
     */
    private static void salto(int i){
        for (int j = 0; j < i; j++) {
            System.out.println("");
        }
    }
}
