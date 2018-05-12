package AlphaZero;

import java.util.ArrayList;


public class LogicaAlgoritmo {
    
    public ArrayList<Nodo> expandirNodo(String[][] matriz, int x, int y, String tipo, int profundidad, int manzanas){
        
        ArrayList<Nodo> nuevosNodos= new ArrayList<>();
        int utilidad = 0;
        
        
        if((x - 2) >= 0 && (y + 1) <= 5 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            //int m=0;
           /* if (matriz[x-2][y+1].equals("4")) {
                m = manzanas -1;                
            }*/
            
            matrizNueva[x][y] = "0";
            matrizNueva[x-2][y+1]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x - 2) >= 0 && (y - 1) >= 0 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x-2][y-1]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x + 2) <= 5 && (y - 1) >= 0 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+2][y-1]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x + 2) <= 5 && (y + 1) <= 5 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+2][y+1]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x + 1) <= 5 && (y + 2) <= 5 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+1][y+2]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x - 1) >= 0 && (y + 2) <= 5 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x-1][y+2]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
        if((x - 1) >= 0 && (y - 2) >= 0 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x-1][y-2]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
        
         if((x + 1) <= 5 && (y - 2) >= 0 /*&& !matriz[x-2][y+1].equals("0")*/){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[6][6];
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+1][y-2]="1";
            Nodo nodo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas);
            nuevosNodos.add(nodo);
                       
        }
       
       return nuevosNodos;
        
        
    }

    
}
