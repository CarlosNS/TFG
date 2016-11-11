/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Excepciones.ExcepcionDiccionarioIncompleto;
import Excepciones.ExcepcionNoExisteEnDicc;
import Huffman.CompreDescom;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author unake
 */
public class Interfaz extends javax.swing.JFrame {

    Funcionalidad.Principal frec;
    String ultimoDic;
    File ubicacionGuardarDicc;
    File ubicacionNuevoComprimido;

    /**
     * Creates new form Completo
     */
    public Interfaz() {
        initComponents();
        this.setTitle("CNS Huffman");
        frec = new Funcionalidad.Principal(textoConsola);
        labelTiempoCompre.setVisible(false);
        labelTiempoDescomp.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonAnalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoLongitudMedia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAnalizar = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoConsola = new javax.swing.JTextArea();
        botonDiccionario = new javax.swing.JButton();
        textoCotaSuperior = new javax.swing.JTextField();
        textoCotaInferior = new javax.swing.JTextField();
        etiquetaEstadoDicc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        checkEstandar = new javax.swing.JCheckBox();
        botonGuardarDicc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textoDicAcom = new javax.swing.JTextField();
        textoTextAcomp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoCompReal = new javax.swing.JTextField();
        botonArchivoCom = new javax.swing.JButton();
        botonDiccComp = new javax.swing.JButton();
        labelTiempoCompre = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonRutaNuevoComprimido = new javax.swing.JButton();
        labelErroresComprimir = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textoTextoDescom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonDescompresion = new javax.swing.JButton();
        textoDiccionDescomp = new javax.swing.JTextField();
        botonTextoADescom = new javax.swing.JButton();
        BotonDiccAdescom = new javax.swing.JButton();
        labelTiempoDescomp = new javax.swing.JLabel();
        labelErroresDescomprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Cotas");

        botonAnalizar.setText("Abrir");
        botonAnalizar.setEnabled(false);
        botonAnalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnalizarMouseClicked(evt);
            }
        });
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Texto a analizar");

        textoLongitudMedia.setEditable(false);
        textoLongitudMedia.setText("0");

        textoAnalizar.setEditable(false);
        textoAnalizar.setAutoscrolls(false);
        textoAnalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoAnalizarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(textoAnalizar);

        jLabel4.setText("Longitud Media");

        jCheckBox1.setText("Usar compresión en dos grupos");

        textoConsola.setColumns(20);
        textoConsola.setRows(5);
        textoConsola.setText("Vista de frecuencias");
        jScrollPane2.setViewportView(textoConsola);

        botonDiccionario.setText("Crear diccionario");
        botonDiccionario.setEnabled(false);
        botonDiccionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiccionarioActionPerformed(evt);
            }
        });

        textoCotaSuperior.setEditable(false);
        textoCotaSuperior.setText("0");
        textoCotaSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCotaSuperiorActionPerformed(evt);
            }
        });

        textoCotaInferior.setEditable(false);
        textoCotaInferior.setText("0");

        jLabel3.setText("Nombre del diccionario");

        jButton2.setText("Seleccionar archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        checkEstandar.setSelected(true);
        checkEstandar.setText("Incluir comienzo de diccionario estándar (Recomendado)");
        checkEstandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEstandarActionPerformed(evt);
            }
        });

        botonGuardarDicc.setText("Elegir ruta y nombre");
        botonGuardarDicc.setEnabled(false);
        botonGuardarDicc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarDiccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAnalizar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoLongitudMedia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonGuardarDicc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDiccionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaEstadoDicc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkEstandar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(textoCotaInferior)
                        .addGap(18, 18, 18)
                        .addComponent(textoCotaSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(botonAnalizar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2)
                        .addComponent(textoCotaInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textoCotaSuperior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkEstandar)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(botonDiccionario)
                    .addComponent(etiquetaEstadoDicc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarDicc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoLongitudMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Crear Diccionario", jPanel1);

        textoDicAcom.setEditable(false);

        textoTextAcomp.setEditable(false);

        jButton1.setText("Comprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Compresión realizada");

        jLabel6.setText("Diccionario a utilizar");

        jLabel7.setText("Texto a comprimir");

        textoCompReal.setEditable(false);
        textoCompReal.setText("Proximamente");

        botonArchivoCom.setText("Seleccionar archivo");
        botonArchivoCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArchivoComActionPerformed(evt);
            }
        });

        botonDiccComp.setText("Seleccionar archivo");
        botonDiccComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiccCompActionPerformed(evt);
            }
        });

        labelTiempoCompre.setText("jLabel11");

        jLabel11.setText("Ruta y nombre del nuevo archivo");

        botonRutaNuevoComprimido.setText("Seleccionar");
        botonRutaNuevoComprimido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRutaNuevoComprimidoActionPerformed(evt);
            }
        });

        labelErroresComprimir.setText("CajaErrores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelErroresComprimir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(textoCompReal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTiempoCompre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonRutaNuevoComprimido))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(53, 53, 53))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(62, 62, 62)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoDicAcom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoTextAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonArchivoCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonDiccComp))))
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoTextAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonArchivoCom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoDicAcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDiccComp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(botonRutaNuevoComprimido))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoCompReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTiempoCompre))
                .addGap(18, 18, 18)
                .addComponent(labelErroresComprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(70, 70, 70))
        );

        jTabbedPane1.addTab("Compresion", jPanel2);

        jLabel8.setText("Texto");

        textoTextoDescom.setEditable(false);

        jLabel9.setText("Preview");

        jLabel10.setText("Diccionario");

        botonDescompresion.setText("Descomprimir");
        botonDescompresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescompresionActionPerformed(evt);
            }
        });

        textoDiccionDescomp.setEditable(false);

        botonTextoADescom.setText("Seleccionar archivo");
        botonTextoADescom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTextoADescomActionPerformed(evt);
            }
        });

        BotonDiccAdescom.setText("Seleccionar archivo");
        BotonDiccAdescom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDiccAdescomActionPerformed(evt);
            }
        });

        labelTiempoDescomp.setText("jLabel11");

        labelErroresDescomprimir.setText("CajaErrores");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(219, 219, 219))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoTextoDescom)
                            .addComponent(textoDiccionDescomp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonTextoADescom)
                            .addComponent(BotonDiccAdescom))
                        .addContainerGap(169, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonDescompresion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTiempoDescomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(195, 195, 195))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelErroresDescomprimir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoTextoDescom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonTextoADescom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoDiccionDescomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonDiccAdescom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelErroresDescomprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonDescompresion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTiempoDescomp)
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("Descompresión", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Crear Diccionario");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnalizarMouseClicked

    }//GEN-LAST:event_botonAnalizarMouseClicked

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
        float entro = frec.lectura(textoAnalizar.getText(), checkEstandar.isSelected());
        textoCotaInferior.setText(Float.toString(entro));
        textoCotaSuperior.setText(Float.toString(entro + (float) frec.getfrecmax() + 0.082f));
        textoLongitudMedia.setText(Integer.toString((int) (100 - (((entro + 0.5f) * 100) / 7))));
        textoLongitudMedia.setText(CompreDescom.DameLongitud(frec.getDic()) + "");
        botonGuardarDicc.setEnabled(true);
    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void textoAnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoAnalizarMouseClicked

    }//GEN-LAST:event_textoAnalizarMouseClicked

    private void botonDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiccionarioActionPerformed
        try {
            CompreDescom.escribeDicci(frec.getDic(), ubicacionGuardarDicc.getAbsolutePath());
            etiquetaEstadoDicc.setText("Diccionario creado");

        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            etiquetaEstadoDicc.setText("Error al crear el diccionario");
        }

    }//GEN-LAST:event_botonDiccionarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Long Tiempo;
        Tiempo = System.currentTimeMillis();
        try {
            CompreDescom.codificar(CompreDescom.leeDicc(textoDicAcom.getText()), textoTextAcomp.getText(), ubicacionNuevoComprimido.getAbsolutePath() + ".huf");
            Tiempo = System.currentTimeMillis() - Tiempo;
            labelTiempoCompre.setText(Tiempo.toString() + " milisegundos");
            labelTiempoCompre.setVisible(true);
            File viejo = new File(textoTextAcomp.getText());
            File nuevo = ubicacionNuevoComprimido;
            System.out.println(textoTextAcomp.getText());
            double lviejo = new Double(viejo.length());
            double lnuevo = new Double(nuevo.length());
            System.out.println((lnuevo / lviejo));
            Double porcentaje = 100 - (lnuevo / lviejo) * 100;
            textoCompReal.setText(porcentaje.toString());
        } catch (IOException | ExcepcionNoExisteEnDicc ex) {
            labelErroresComprimir.setText(ex.getMessage());
            ubicacionNuevoComprimido.delete();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonDescompresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescompresionActionPerformed
        try {
            Long Tiempo;
            Tiempo = System.currentTimeMillis();
            try {
                CompreDescom.decodificar(textoTextoDescom.getText(), CompreDescom.leeDicc(textoDiccionDescomp.getText()));
                Tiempo = System.currentTimeMillis() - Tiempo;
                labelTiempoDescomp.setText(Tiempo.toString() + " milisegundos");
                labelTiempoDescomp.setVisible(true);
            } catch (ExcepcionDiccionarioIncompleto ex) {
                labelErroresDescomprimir.setText("El archivo no ha sido codificado con el diccionario elegido");
            }
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonDescompresionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser elegir = new JFileChooser();
        elegir.showOpenDialog(null);
        if (elegir.getSelectedFile() != null) {
            String archivo = elegir.getSelectedFile().getAbsolutePath();
            textoAnalizar.setText(archivo);
            botonAnalizar.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonArchivoComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArchivoComActionPerformed
        JFileChooser elegir = new JFileChooser();
        elegir.showOpenDialog(null);
        if (elegir.getSelectedFile() != null) {
            String archivo = elegir.getSelectedFile().getAbsolutePath();
            textoTextAcomp.setText(archivo);
        }

    }//GEN-LAST:event_botonArchivoComActionPerformed

    private void botonDiccCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiccCompActionPerformed
        JFileChooser elegir = new JFileChooser();
        elegir.showOpenDialog(null);
        if (elegir.getSelectedFile() != null) {
            String archivo = elegir.getSelectedFile().getAbsolutePath();
            textoDicAcom.setText(archivo);
        }
    }//GEN-LAST:event_botonDiccCompActionPerformed

    private void botonTextoADescomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTextoADescomActionPerformed
        JFileChooser elegir = new JFileChooser();
        elegir.showOpenDialog(null);
        if (elegir.getSelectedFile() != null) {
            String archivo = elegir.getSelectedFile().getAbsolutePath();
            textoTextoDescom.setText(archivo);
        }

    }//GEN-LAST:event_botonTextoADescomActionPerformed

    private void BotonDiccAdescomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDiccAdescomActionPerformed
        JFileChooser elegir = new JFileChooser();
        elegir.showOpenDialog(null);
        if (elegir.getSelectedFile() != null) {
            String archivo = elegir.getSelectedFile().getAbsolutePath();
            textoDiccionDescomp.setText(archivo);
        }
    }//GEN-LAST:event_BotonDiccAdescomActionPerformed

    private void textoCotaSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCotaSuperiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCotaSuperiorActionPerformed

    private void checkEstandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEstandarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEstandarActionPerformed

    private void botonGuardarDiccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarDiccActionPerformed
        JFileChooser ruta = new JFileChooser();
        ruta.showOpenDialog(null);
        if (ruta.getSelectedFile() != null) {
            this.ubicacionGuardarDicc = ruta.getSelectedFile();
            botonDiccionario.setEnabled(true);
        }
    }//GEN-LAST:event_botonGuardarDiccActionPerformed

    private void botonRutaNuevoComprimidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRutaNuevoComprimidoActionPerformed
        JFileChooser ruta = new JFileChooser();
        ruta.showOpenDialog(null);
        if (ruta.getSelectedFile() != null) {
            this.ubicacionNuevoComprimido = ruta.getSelectedFile();
        }
    }//GEN-LAST:event_botonRutaNuevoComprimidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()) || "GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } 
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonDiccAdescom;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonArchivoCom;
    private javax.swing.JButton botonDescompresion;
    private javax.swing.JButton botonDiccComp;
    private javax.swing.JButton botonDiccionario;
    private javax.swing.JButton botonGuardarDicc;
    private javax.swing.JButton botonRutaNuevoComprimido;
    private javax.swing.JButton botonTextoADescom;
    private javax.swing.JCheckBox checkEstandar;
    private javax.swing.JLabel etiquetaEstadoDicc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelErroresComprimir;
    private javax.swing.JLabel labelErroresDescomprimir;
    private javax.swing.JLabel labelTiempoCompre;
    private javax.swing.JLabel labelTiempoDescomp;
    private javax.swing.JTextPane textoAnalizar;
    private javax.swing.JTextField textoCompReal;
    private javax.swing.JTextArea textoConsola;
    private javax.swing.JTextField textoCotaInferior;
    private javax.swing.JTextField textoCotaSuperior;
    private javax.swing.JTextField textoDicAcom;
    private javax.swing.JTextField textoDiccionDescomp;
    private javax.swing.JTextField textoLongitudMedia;
    private javax.swing.JTextField textoTextAcomp;
    private javax.swing.JTextField textoTextoDescom;
    // End of variables declaration//GEN-END:variables
}
