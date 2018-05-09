package Vista;

import AlphaZero.*;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class Ventana extends javax.swing.JFrame {

    private String[][] matriz = new String[6][6];
    private JLabel[][] matrizBotones = new JLabel[6][6];
    private ImageIcon caballo;
    private int x;
    private int y;
    private int mundo;

    public Ventana() throws IOException {

        super("Teoria de Juegos");        
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //comboBoxBusqueda.addItem("Amplitud");
        
        
        
        mundo = 0;
        textAreaReporte.setEditable(false);
        textAreaReporte.setLineWrap(true);
        textAreaReporte.setWrapStyleWord(true);

        panelMatriz.setLayout(new GridLayout(6, 6));
        crearMatriz();
        llenarMatriz();
        
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
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void crearMatriz(){
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                JLabel boton = new JLabel();
                matrizBotones[i][j] = boton;
                panelMatriz.add(boton);
            }
        }
    }
    
    private void llenarMatriz() throws FileNotFoundException, IOException {

        File archivo = new File("sources/A/Input" + mundo +".txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        int j = 0;

        while (linea != null) {
            System.out.println(linea);
            String[] values = linea.split(" ");
            

            for (int i = 0; i < 6; i++) { 
                                
                matriz[j][i] = values[i];                
                ImageIcon imagen = new ImageIcon("sources/" + "M" + "/" + values[i]/*.charAt(0)*/ + ".png"); 
                matrizBotones[j][i].setIcon(imagen);      
                
                /*
                0 = blanco
                1 = negro
                2 = caballo blanco en casilla blanca
                3 = caballo blanco en casilla negra
                4 = caballo negro en casilla blanca
                5 = caballo negro en casilla negra
                6 = manzana en casilla blanca
                7 = manzana en casilla negra
                8 = caballos en la misma posición
                */
                
/*
                if (matriz[j][i] == 2) {

                    x = j;
                    y = i;
                }
                
                if (matriz[j][i] == 5) {

                    xf = j;
                    yf = i;
                }
*/
            }

            linea = br.readLine();
            j++;
        
        
    }
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

    public static void main(String args[]) {


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
			
			for(int i=0; i<6; i++)
			{
                            for (int j = 0; j < 6; j++) {
                                if( click.getSource() == matrizBotones[i][j])
				{
                                    System.out.println(i + " " + j);
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