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
    private JLabel[][] matrizBotones;
    private EventosMouse mouse;
    private static LogicaAlgoritmo logica;
    private static int manzanas;
    private static int n;
    private int medida;
    private int manzanasGoku;
    private int manzanasFreezer;
    private boolean enJuego;

    public Ventana() throws IOException {

        super("Teoria de Juegos");
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        panelMatriz.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        mouse = new EventosMouse();
        enJuego = false;
        manzanasGoku = 0;
        manzanasFreezer = 0;
        medida = 0;
        this.n = 6;
        matrizBotones = new JLabel[n][n];
        cargarInicio();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonEmpezar = new javax.swing.JButton();
        campoManzanas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonCargar = new javax.swing.JButton();
        labelFreezer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelEsferas = new javax.swing.JLabel();
        labelGanador = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelGoku = new javax.swing.JLabel();
        labelTema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(30, 156, 15));
        setPreferredSize(new java.awt.Dimension(1300, 1000));

        panelMatriz.setBackground(new java.awt.Color(254, 254, 254));
        panelMatriz.setPreferredSize(new java.awt.Dimension(900, 900));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botonEmpezar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        botonEmpezar.setText("Empezar");
        botonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarActionPerformed(evt);
            }
        });

        campoManzanas.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Número de Esferas");

        botonCargar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        botonCargar.setText("Cargar");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        labelFreezer.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelFreezer.setText("0");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel4.setText("Freezer(PC):");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel5.setText("Goku(P1): ");

        labelEsferas.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelEsferas.setText("0");

        labelGanador.setMaximumSize(new java.awt.Dimension(329, 128));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel7.setText("Esferas restantes: ");

        labelGoku.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelGoku.setText("0");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEsferas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGoku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFreezer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonEmpezar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addComponent(botonCargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoManzanas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoManzanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(botonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEsferas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGoku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFreezer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(labelGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTema.setMaximumSize(new java.awt.Dimension(329, 128));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelTema, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        // TODO add your handling code here:
        //this.n = Integer.valueOf(campoMatriz.getText());
        this.manzanas = Integer.valueOf(campoManzanas.getText());
        if(this.manzanas%2 == 0){
            if(this.manzanas == 34){
                this.manzanas = 33;
            }
            else{
                this.manzanas = this.manzanas +1;
            }
        }
        enJuego = false;
        manzanasGoku = 0;
        manzanasFreezer = 0;
        labelEsferas.setText(String.valueOf(this.manzanas));
        labelGoku.setText("0");
        labelFreezer.setText("0");
        botonEmpezar.setEnabled(true);
        ImageIcon caballoImagen1 = new ImageIcon("sources/" + "DragonBall" + "/11" + ".png");
        labelGanador.setIcon(caballoImagen1);
        logica = new LogicaAlgoritmo(this.n, this.manzanas);
        matriz = new int[n][n];
        llenarMatriz();
    }//GEN-LAST:event_botonCargarActionPerformed

    public void tomarDecision(){
        int xBlanco = logica.getxInicialBlanco();
        int yBlanco = logica.getyInicialBlanco();
        logica.tomarDecision(matriz);
        matriz[xBlanco][yBlanco] = 0;
        matrizBotones[xBlanco][yBlanco].setIcon(null);
        if (matriz[logica.getxInicialBlanco()][logica.getyInicialBlanco()] == 3) {
            manzanas--;
            manzanasFreezer++;
            labelFreezer.setText(String.valueOf(manzanasFreezer));
            labelEsferas.setText(String.valueOf(this.manzanas));
            
            if(manzanas == 0){
                if (manzanasGoku > manzanasFreezer) {
                    labelGoku.setText(manzanasGoku + " " + "Ganó Goku");
                    ImageIcon ganador = new ImageIcon("sources/" + "DragonBall" + "/goku" + ".gif");
                    ImageIcon ganadorT = new ImageIcon(ganador.getImage().getScaledInstance(318, 300, java.awt.Image.SCALE_DEFAULT));
                     labelGanador.setIcon(ganadorT);
                     enJuego = false;
                } 
                else {
                    labelFreezer.setText(manzanasFreezer + " " + "Ganó Freezer");
                    ImageIcon ganador = new ImageIcon("sources/" + "DragonBall" + "/freezer" + ".gif");
                    ImageIcon ganadorT = new ImageIcon(ganador.getImage().getScaledInstance(318, 300, java.awt.Image.SCALE_DEFAULT));
                     labelGanador.setIcon(ganadorT);
                     enJuego = false;
                }
            }
        }

        matriz[logica.getxInicialBlanco()][logica.getyInicialBlanco()] = 1;
        ImageIcon caballoImagen = new ImageIcon("sources/" + "DragonBall" + "/" + 1 + ".png");
        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
        matrizBotones[logica.getxInicialBlanco()][logica.getyInicialBlanco()].setIcon(caballoT);
        
    }
    private void botonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarActionPerformed
        // TODO add your handling code here:
        
        tomarDecision();
        enJuego = true;
        botonEmpezar.setEnabled(false);

    }//GEN-LAST:event_botonEmpezarActionPerformed
   
    private void crearMatrizBotones(){
        
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                
                JLabel boton = new JLabel();
                boton.addMouseListener(mouse);
                boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                matrizBotones[i][j] = boton;
                panelMatriz.add(boton);
            }
        }
    }

    public void cargarInicio() {
        
        ImageIcon caballoImagen = new ImageIcon("sources/" + "DragonBall" + "/10" + ".png");
        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(329, 128, java.awt.Image.SCALE_DEFAULT));
        labelTema.setIcon(caballoT);
        
        ImageIcon caballoImagen1 = new ImageIcon("sources/" + "DragonBall" + "/11" + ".png");
        //ImageIcon caballoT1 = new ImageIcon(caballoImagen.getImage().getScaledInstance(329, 128, java.awt.Image.SCALE_DEFAULT));
        labelGanador.setIcon(caballoImagen1);
        panelMatriz.setLayout(new GridLayout(n, n));

        crearMatrizBotones();
        boolean rotar = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rotar) {
                    Color azul = new Color(30, 156, 15);
                    matrizBotones[i][j].setBackground(azul);
                    matrizBotones[i][j].setOpaque(true);
                } else {
                    matrizBotones[i][j].setBackground(Color.WHITE);
                    matrizBotones[i][j].setOpaque(true);
                }
                rotar = !rotar;
            }
            if (n % 2 == 0) {
                rotar = !rotar;
            }

        }
        

    }
    
    private void llenarMatriz() {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizBotones[i][j].setIcon(null);
            }
            
        }
        medida = 900/n;
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
        //matriz[1][3] = 3;
        //matriz[2][1] = 3;
        //matriz[2][3] = 3;
        //matriz[3][3] = 3;
        
        for (int i = 0; i < manzanas; i++) {
            int xManzana = (int) (Math.random() * n) ;
            int yManzana = (int) (Math.random() * n) ;
            
            while (matriz[xManzana][yManzana] != 0) {                
                xManzana = (int) (Math.random() * n) ;
                yManzana = (int) (Math.random() * n) ;
            }
            
            matriz[xManzana][yManzana] = 3;

        }
        
        int bola = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != 0) {
                    
                    
                    if(matriz[i][j] == 3){
                        
                        ImageIcon caballoImagen = new ImageIcon("sources/" + "DragonBall" + "/bola" + bola + ".png");
                        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
                        matrizBotones[i][j].setIcon(caballoT);
                        if (bola == 7) {
                            bola = 1;
                        }
                        else{
                            bola++;
                        }
                                
                    } 
                    else {
                        ImageIcon caballoImagen = new ImageIcon("sources/" + "DragonBall" + "/" + matriz[i][j] + ".png");
                        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
                        matrizBotones[i][j].setIcon(caballoT);
                    }

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
            manzanasGoku++;
            labelGoku.setText(String.valueOf(manzanasGoku));
            labelEsferas.setText(String.valueOf(this.manzanas));
        }
        
        matriz[xNueva][yNueva] = 2; 
        logica.setxInicialNegro(xNueva);
        logica.setyInicialNegro(yNueva);
        
        ImageIcon caballoImagen = new ImageIcon("sources/" + "DragonBall" + "/" + 2 + ".png"); 
        ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(medida, medida, java.awt.Image.SCALE_DEFAULT));
        matrizBotones[xNueva][yNueva].setIcon(caballoT);   
        this.paintAll(this.getGraphics());
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(manzanas > 0){
            tomarDecision();
        }
        else{
            if (manzanasGoku > manzanasFreezer) {
                    labelGoku.setText(manzanasGoku + " " + "Ganó Goku");
                    ImageIcon ganador = new ImageIcon("sources/" + "DragonBall" + "/goku" + ".gif");
                    ImageIcon ganadorT = new ImageIcon(ganador.getImage().getScaledInstance(318, 300, java.awt.Image.SCALE_DEFAULT));
                     labelGanador.setIcon(ganadorT);
                     enJuego = false;
                } 
                else {
                    labelFreezer.setText(manzanasFreezer + " " + "Ganó Freezer");
                    ImageIcon ganador = new ImageIcon("sources/" + "DragonBall" + "/freezer" + ".gif");
                    ImageIcon ganadorT = new ImageIcon(ganador.getImage().getScaledInstance(318, 300, java.awt.Image.SCALE_DEFAULT));
                     labelGanador.setIcon(ganadorT);
                     enJuego = false;
                }
        }
        
    }

    
    /*public void recargar(){
        
        try {
            llenarMatriz();
        } catch (IOException ex) {
            
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
                                    int xNegro = logica.getxInicialNegro();
                                    int yNegro = logica.getyInicialNegro();
                                    int xBlanco = logica.getxInicialBlanco();
                                    int yBlanco = logica.getyInicialBlanco();
                                    
                                    if((((i == xNegro-2) && (j==yNegro+1)) ||
                                       ((i == xNegro-2) && (j==yNegro-1)) || 
                                       ((i == xNegro+2) && (j==yNegro-1)) ||
                                       ((i == xNegro+2) && (j==yNegro+1)) ||
                                       ((i == xNegro+1) && (j==yNegro+2)) ||
                                       ((i == xNegro-1) && (j==yNegro+2)) ||
                                       ((i == xNegro-1) && (j==yNegro-2)) ||
                                       ((i == xNegro+1) && (j==yNegro-2))) && 
                                        enJuego == true && 
                                        !((i == xBlanco) && (j == yBlanco))){
                                        hacerJugada(i, j);
                                    }
                                    
                                }			
                            }
                        }
				
				
		}
			
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonEmpezar;
    private javax.swing.JTextField campoManzanas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelEsferas;
    private javax.swing.JLabel labelFreezer;
    private javax.swing.JLabel labelGanador;
    private javax.swing.JLabel labelGoku;
    private javax.swing.JLabel labelTema;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables
}