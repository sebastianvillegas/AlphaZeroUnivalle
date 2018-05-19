package Vista;

import AlphaZero.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.*;
import javax.swing.*;

public class Ventana extends javax.swing.JFrame {

    private static int[][] matriz;
    private int[][] coloresMatriz;
    private JLabel[][] matrizBotones;
    private EventosMouse mouse;
    private static LogicaAlgoritmo logica;
    private static int manzanas;
    private static int n;
    private int medida;

    public Ventana(/*int n, int manzanas*/) throws IOException {

        super("Teoria de Juegos");
        /*this.n = n;
        this.manzanas = manzanas;*/
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        mouse = new EventosMouse();
        textAreaReporte.setEditable(false);
        textAreaReporte.setLineWrap(true);
        textAreaReporte.setWrapStyleWord(true);
        botonRecargar.setEnabled(false);
        medida = 0;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        botonEmpezar = new javax.swing.JButton();
        botonRecargar = new javax.swing.JButton();
        labelReporte = new javax.swing.JLabel();
        labelTema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReporte = new javax.swing.JTextArea();
        campoMatriz = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoManzanas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonCargar = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMatriz.setBackground(new java.awt.Color(254, 254, 254));
        panelMatriz.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        panelBotones.setBackground(new java.awt.Color(254, 254, 254));

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTitulo.setText("AlphaZero");

        botonEmpezar.setText("Empezar");
        botonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarActionPerformed(evt);
            }
        });

        botonRecargar.setText("Recargar");

        labelReporte.setText("Reporte");

        textAreaReporte.setColumns(20);
        textAreaReporte.setRows(3);
        jScrollPane1.setViewportView(textAreaReporte);

        jLabel1.setText("Tamaño de la matriz:");

        jLabel2.setText("Número de manzanas:");

        botonCargar.setText("Cargar");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTema, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(labelReporte)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoManzanas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(botonEmpezar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addComponent(botonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoManzanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(54, 54, 54)
                .addComponent(botonCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEmpezar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRecargar)
                .addGap(18, 18, 18)
                .addComponent(labelTema, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelReporte)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(label)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        // TODO add your handling code here:
        this.n = Integer.valueOf(campoMatriz.getText());
        this.manzanas = Integer.valueOf(campoManzanas.getText());
        logica = new LogicaAlgoritmo(this.n, this.manzanas);
        panelMatriz.setLayout(new GridLayout(n, n));
        matrizBotones = new JLabel[n][n];
        crearMatrizBotones();
        matriz = new int[n][n];
        coloresMatriz = new int[n][n];
        llenarMatriz();
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarActionPerformed
        // TODO add your handling code here:
        int xBlanco = logica.getxInicialBlanco();
        int yBlanco = logica.getyInicialBlanco();
        
        logica.tomarDecision(matriz);
        
        matriz[xBlanco][yBlanco] = 0;
        matrizBotones[xBlanco][yBlanco].setIcon(null);
        if (matriz[logica.getxInicialBlanco()][logica.getyInicialBlanco()] == 3) {
            manzanas--;
        }
        matriz[logica.getxInicialBlanco()][logica.getyInicialBlanco()] = 1;
        
        ImageIcon caballoImagen = new ImageIcon("sources/" + "A" + "/" + 1 + ".png"); 
        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
        matrizBotones[logica.getxInicialBlanco()][logica.getyInicialBlanco()].setIcon(caballoT);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+ " ");
                
            }
            System.out.println("");
            
        }
        
        
        
    }//GEN-LAST:event_botonEmpezarActionPerformed
   
    private void crearMatrizBotones(){
        
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                
                JLabel boton = new JLabel();
                boton.addMouseListener(mouse);
                matrizBotones[i][j] = boton;
                panelMatriz.add(boton);
            }
        }
    }
    
    private void llenarMatriz() {
        boolean rotar = false;
        medida = 300/n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rotar) {
                    coloresMatriz[i][j] = 0;
                }
                else{
                    coloresMatriz[i][j] = 1;
                }
                rotar = !rotar;
            }
            if (n%2 == 0) {
                rotar = !rotar;
            }

        }
        
        int xBlanco = (int) (Math.random() * n) ;
        int yBlanco = (int) (Math.random() * n) ;
        
        int xNegro = (int) (Math.random() * n) ;
        int yNegro = (int) (Math.random() * n) ;
        
        while (xBlanco == xNegro && yBlanco == yNegro) {            
            xNegro = (int) (Math.random() * n) ;
            yNegro = (int) (Math.random() * n) ;
        }
        
        matriz[xBlanco][yBlanco] = 1;
        matriz[xNegro][yNegro] = 2;
        logica.setxInicialBlanco(xBlanco);
        logica.setyInicialBlanco(yBlanco);
        logica.setxInicialNegro(xNegro);
        logica.setyInicialNegro(yNegro);
        //matriz[0][1] = 3;
        //matriz[2][1] = 3;
        //matriz[2][0] = 3;
        
        
        for (int i = 0; i < manzanas; i++) {
            int xManzana = (int) (Math.random() * n) ;
            int yManzana = (int) (Math.random() * n) ;
            
            while (matriz[xManzana][yManzana] != 0) {                
                xManzana = (int) (Math.random() * n) ;
                yManzana = (int) (Math.random() * n) ;
            }
            
            matriz[xManzana][yManzana] = 3;

        }
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+ " ");
                
            }
            System.out.println("");
            
        }*/
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (coloresMatriz[i][j]==0) {
                    matrizBotones[i][j].setBackground(Color.white);
                    matrizBotones[i][j].setOpaque(true);
                }
                else if (coloresMatriz[i][j]==1) {
                    matrizBotones[i][j].setBackground(Color.black);
                    matrizBotones[i][j].setOpaque(true);
                }
                
                if (matriz[i][j] != 0) {
                    ImageIcon caballoImagen = new ImageIcon("sources/" + "A" + "/" + matriz[i][j] + ".png"); 
                    ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
                    matrizBotones[i][j].setIcon(caballoT);
                }
            }
            
        }
}
    
    public void hacerJugada(int xNueva, int yNueva){
        
        int xNegro = logica.getxInicialNegro();
        int yNegro = logica.getyInicialNegro();
        matriz[xNegro][yNegro] = 0;
           
        matrizBotones[xNegro][yNegro].setIcon(null);

        if (matriz[xNueva][yNueva] == 3) {
            manzanas--;
            logica.setManzanas(manzanas);
        }
        
        matriz[xNueva][yNueva] = 2; 
        logica.setxInicialNegro(xNueva);
        logica.setyInicialNegro(yNueva);
        
        ImageIcon caballoImagen = new ImageIcon("sources/" + "A" + "/" + 2 + ".png"); 
        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
        matrizBotones[xNueva][yNueva].setIcon(caballoT);
        
        System.out.println(manzanas);
        System.out.println(logica.getManzanas());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+ " ");
                
            }
            System.out.println("");
            
        }
        
    }

    
    /*public void recargar(){
        
        try {
            llenarMatriz();
        } catch (IOException ex) {
            
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.paintAll(this.getGraphics());
        
        botonRecargar.setEnabled(false);
        botonEmpezar.setEnabled(true);
        textAreaReporte.setText("");
    }  */   

    public static void main(String args[]) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Ventana().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private class EventosMouse extends MouseAdapter
	//Clase interna para manejar los eventos del mouse
	{
                @Override
		public void mouseClicked(MouseEvent click) {
			
			for(int i=0; i<n; i++) {
                            for (int j = 0; j < n; j++) {
                                if( click.getSource() == matrizBotones[i][j]) {
                                    
                                    hacerJugada(i, j);
                                    
                                    
                                   
                                }			
                            }
                        }
				
				
		}
			
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonEmpezar;
    private javax.swing.JButton botonRecargar;
    private javax.swing.JTextField campoManzanas;
    private javax.swing.JTextField campoMatriz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelReporte;
    private javax.swing.JLabel labelTema;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JTextArea textAreaReporte;
    // End of variables declaration//GEN-END:variables
}