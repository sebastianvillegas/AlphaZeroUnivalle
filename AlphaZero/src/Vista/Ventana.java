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

    private static String[][] matriz;
    private String[][] coloresMatriz;
    private JLabel[][] matrizBotones;
    private EventosMouse mouse;
    private static LogicaAlgoritmo logica;
    private static int manzanas;
    private static int n;

    public Ventana(int n, int manzanas) throws IOException {

        super("Teoria de Juegos");
        this.n = n;
        this.manzanas = manzanas;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        logica = new LogicaAlgoritmo(this.n, this.manzanas);
        panelMatriz.setLayout(new GridLayout(n, n));
        matrizBotones = new JLabel[n][n];
        mouse = new EventosMouse();
        crearMatrizBotones();
        textAreaReporte.setEditable(false);
        textAreaReporte.setLineWrap(true);
        textAreaReporte.setWrapStyleWord(true);
        buttonRecargar.setEnabled(false);

        matriz = new String[n][n];
        coloresMatriz = new String[n][n];
        llenarMatriz();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        buttonEmpezar = new javax.swing.JButton();
        buttonRecargar = new javax.swing.JButton();
        labelReporte = new javax.swing.JLabel();
        labelTema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReporte = new javax.swing.JTextArea();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMatriz.setBackground(new java.awt.Color(254, 254, 254));
        panelMatriz.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        panelBotones.setBackground(new java.awt.Color(254, 254, 254));

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTitulo.setText("Mario smart");

        buttonEmpezar.setText("Empezar");

        buttonRecargar.setText("Recargar");

        labelReporte.setText("Reporte");

        textAreaReporte.setColumns(20);
        textAreaReporte.setRows(3);
        jScrollPane1.setViewportView(textAreaReporte);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelTitulo)
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBotonesLayout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(buttonRecargar)
                                            .addComponent(buttonEmpezar)))
                                    .addComponent(labelTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(labelReporte)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelTitulo)
                .addGap(111, 111, 111)
                .addComponent(buttonEmpezar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRecargar)
                .addGap(60, 60, 60)
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
                        .addGap(15, 15, 15)
                        .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
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
    
    private void llenarMatriz() throws FileNotFoundException, IOException {

        File archivoColores = new File("sources/A/Input1.txt");
        FileReader fr = new FileReader(archivoColores);
        BufferedReader br = new BufferedReader(fr);
        
        File archivoCaballo = new File("sources/A/Input0.txt");
        FileReader fr1 = new FileReader(archivoCaballo);
        BufferedReader br1 = new BufferedReader(fr1);
        
        String lineaCaballo = br1.readLine();
        String lineaColores = br.readLine();
        
        
        int i = 0;
        
        while (lineaColores != null) {
            
            String[] values = lineaColores.split(" ");
            String[] valuesHorse = lineaCaballo.split(" ");
            
            for (int j = 0; j < n; j++) {
                
                matriz[i][j] = valuesHorse[j];
                coloresMatriz[i][j] = values[j];
                
                if (coloresMatriz[i][j].equals("0")) {
                    matrizBotones[i][j].setBackground(Color.white);
                    matrizBotones[i][j].setOpaque(true);
                }
                else if (coloresMatriz[i][j].equals("1")) {
                    matrizBotones[i][j].setBackground(Color.black);
                    matrizBotones[i][j].setOpaque(true);
                }
                
                if (matriz[i][j].equals("1")) {
                    ImageIcon caballoImagen = new ImageIcon("sources/" + "A" + "/" + "h" + ".png"); 
                    ImageIcon caballoT = new ImageIcon(caballoImagen.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
                    matrizBotones[i][j].setIcon(caballoT);
                }
            }
            lineaCaballo = br1.readLine();
            lineaColores = br.readLine();
            i++;
    }
}
    
   /* public void hacerJugada(int xNueva, int yNueva){
        if (turno.equals("blanco")) {
            if (matriz[xActualBlanco][yActualBlanco].equals("2") || 
                matriz[xActualBlanco][yActualBlanco].equals("3")) {
                
                matriz[xActualBlanco][yActualBlanco] = "0";
                ImageIcon imagen = new ImageIcon("sources/" + "M" + "/" + "0" + ".png"); 
                matrizBotones[xActualBlanco][yActualBlanco].setIcon(imagen);
            }
            
            
            if (matriz[xNueva][yNueva].equals("0")) {
                matriz[xNueva][yNueva]="2";
                ImageIcon imagen = new ImageIcon("sources/" + "M" + "/" + "2" + ".png"); 
                matrizBotones[xNueva][yNueva].setIcon(imagen);  
            }
            else if (matriz[xNueva][yNueva].equals("1")) {
                matriz[xNueva][yNueva]="3";
                ImageIcon imagen = new ImageIcon("sources/" + "M" + "/" + "3" + ".png"); 
                matrizBotones[xNueva][yNueva].setIcon(imagen);
            }   
        }
    }
*/
    
    public void recargar(){
        
        try {
            llenarMatriz();
        } catch (IOException ex) {
            
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.paintAll(this.getGraphics());
        
        buttonRecargar.setEnabled(false);
        buttonEmpezar.setEnabled(true);
        textAreaReporte.setText("");
    }     

    public static void main(String args[]) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Ventana(n, manzanas).setVisible(true);
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
                                    System.out.println("1231");
                                    
                                    //hacerJugada(i, j);
                                    
                                    logica.tomarDecision(matriz);
                                   
                                }			
                            }
                        }
				
				
		}
			
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEmpezar;
    private javax.swing.JButton buttonRecargar;
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