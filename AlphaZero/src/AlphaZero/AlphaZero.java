package AlphaZero;

import Vista.Ventana;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphaZero {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("Ingrese el número de filas y columnas");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Ingrese el número de manzanas");
        int manzanas = Integer.parseInt(br.readLine());
        Ventana v = new Ventana(n, manzanas);
        v.setVisible(true);
        
    }
    
}
