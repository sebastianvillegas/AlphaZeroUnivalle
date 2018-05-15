package AlphaZero;

import Vista.Ventana;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphaZero {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Ya tenemos el "lector"

        System.out.println("Número de filas y columnas");//Se pide un dato al usuario

        int n = Integer.parseInt(br.readLine()); //Se lee el nombre con readLine() que retorna un String con el dato
        Ventana v = new Ventana(n);
        v.setVisible(true);
        
    }
    
}
