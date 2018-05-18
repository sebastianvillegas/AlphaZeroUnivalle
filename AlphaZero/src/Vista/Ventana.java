package Vista;

import AlphaZero.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.logging.*;
import javax.swing.*;

public class Ventana extends javax.swing.JFrame {

    private static String[][] matriz;
    private String[][] coloresMatriz;
    private JLabel[][] matrizBotones;
    private ImageIcon caballo;
    private EventosMouse mouse;
    private int mundo;
    private int xInicialBlanco;
    private int yInicialBlanco;
    private int xInicialNegro;
    private int yInicialNegro;
    private static String turno;
    private static LogicaAlgoritmo logica;
    private Stack<Nodo> pila;
    private int manzanas;
    private static int n;

    public Ventana(int n) throws IOException {

        
        super("Teoria de Juegos");        
        this.n = n;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        matriz = new String[n][n];
        coloresMatriz = new String[n][n];
        matrizBotones = new JLabel[n][n];
        mundo = 1;
        pila = new Stack<Nodo>();
        logica = new LogicaAlgoritmo(this.n);
        turno = "blanco";
        mouse = new EventosMouse();
        manzanas = 1;
        textAreaReporte.setEditable(false);
        textAreaReporte.setLineWrap(true);
        textAreaReporte.setWrapStyleWord(true);
        

        panelMatriz.setLayout(new GridLayout(n, n));
        crearMatriz();
        llenarMatriz();
        xInicialBlanco = 0;
        yInicialBlanco = 0;
        xInicialNegro = 1;
        yInicialNegro = 0;
        Caballo caballo1 = new Caballo(xInicialBlanco,yInicialBlanco, 0);
        Caballo caballo2 = new Caballo(xInicialNegro, yInicialNegro, 0);
        Nodo raiz = new Nodo("MAX", -90, 0, matriz, manzanas, caballo1, caballo2, null);
        pila.push(raiz);
        
        buttonRecargar.setEnabled(false);
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
   
    private void crearMatriz(){
        
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
                
                if(matriz[i][j].equals("2") || matriz[i][j].equals("3")){
                    xInicialBlanco = i;
                    yInicialBlanco = j;   
                }
                
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
                
                //aqui agrego la otras imagenes

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
    
    
    
    public ArrayList<Nodo> generarArregloFinal(){
        ArrayList<Nodo> arregloFinal = new ArrayList<>();
        
        
        while(!pila.isEmpty()){
            ArrayList<Nodo> arreglo= new ArrayList<>();
            
            if (pila.peek().getTipo().equals("MAX")) {
                System.out.println("Turno del 1");
                
            }
            else{
                System.out.println("Turno del 2");
            }
            
            
            for (int l = 0; l < n; l++) {
                for (int m = 0; m < n; m++) {
                    System.out.print(pila.peek().getEstadoJuego()[l][m] + " ");
                }
                System.out.println("");
            }                            
            System.out.println("Profundidad: " + pila.peek().getProfundidad());
            //System.out.println("x1: " + pila.peek().getCaballo1().getPosX());
            //System.out.println("y1: " + pila.peek().getCaballo1().getPosY());
            //System.out.println("x2: " + pila.peek().getCaballo2().getPosX());
            //System.out.println("y2: " + pila.peek().getCaballo2().getPosY());
            System.out.println("manzanas: " + pila.peek().getManzanas() + 
                                                "Manzanas caballo 1: " + pila.peek().getCaballo1().getManzanasComidas() +
                                                "Manzanas caballo 2: " + pila.peek().getCaballo2().getManzanasComidas());
            
            
            System.out.println("");

            
            if(pila.peek().getManzanas() > 0){
                arreglo = logica.expandirNodo(pila.peek());
                
            }
            else{
                logica.cambiarUtilidadHojas(pila.peek());
            }
            
            
            System.out.println("expandidos ");
            for (int i = 0; i < arreglo.size(); i++) {
                
                
                for (int l = 0; l < n; l++) {
                for (int m = 0; m < n; m++) {
                    System.out.print(arreglo.get(i).getEstadoJuego()[l][m] + " ");
                }
                System.out.println("");
            } 
                System.out.println("");
                
               
                
            }
            
            System.out.println("fin");
            
            arregloFinal.add(pila.pop());
            
            for (int k = 0; k < arreglo.size(); k++) {
                pila.push(arreglo.get(k));
            }
        }
        return arregloFinal;
        
    }

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

                    new Ventana(n).setVisible(true);
                    
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
                                    //System.out.println(i + " " + j);
                                    
                                    ArrayList<Nodo> fin = new ArrayList<>();
                                    fin = generarArregloFinal();
                                    
                                    Collections.sort(fin, (Nodo z1, Nodo z2) -> {
                                        if(z1.getProfundidad() < z2.getProfundidad()){
                                            return 1;
                                        }
                                        if(z1.getProfundidad() > z2.getProfundidad()){
                                            return -1;
                                        }  
                                        return 0;
                                    });
                                    
                                    logica.calcularUtilidades(fin);
                                    
                                    System.out.println(fin.size());
                                    for (int k = 0; k < fin.size(); k++) {
                                        System.out.println("Tipo: " + fin.get(k).getTipo() +" Profundidad: "  +
                                                fin.get(k).getProfundidad() +
                                                " Utilidad: " + fin.get(k).getUtilidad() + 
                                                "Manzanas caballo 1: " + fin.get(k).getCaballo1().getManzanasComidas() +
                                                "Manzanas caballo 2: " + fin.get(k).getCaballo2().getManzanasComidas());
                                        
                                    }
                                    
                                    System.out.println("X: " + logica.getxDecisionTomar() + "Y: " + logica.getyDecisionTomar());
                                   
                                    
                                    
                                    
                                    
                                    //hacerJugada(i, j);
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