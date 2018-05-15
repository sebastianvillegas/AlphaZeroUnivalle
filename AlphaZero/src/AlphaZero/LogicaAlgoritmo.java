package AlphaZero;

import java.util.ArrayList;


public class LogicaAlgoritmo {
    
    public static int n;
    
    public LogicaAlgoritmo(int n){
        this.n = n;
        
    }
    
    public ArrayList<Nodo> expandirNodo(Nodo nodo){
        
        String[][] matriz = nodo.getEstadoJuego();
        int x = nodo.getCaballo1().getPosX();
        int y = nodo.getCaballo1().getPosY();
        String tipo = nodo.getTipo(); 
        int profundidad = nodo.getProfundidad(); 
        int manzanas = nodo.getManzanas();
        ArrayList<Nodo> nuevosNodos= new ArrayList<>();
        int utilidad = 0;
        
        if((x - 2) >= 0 && (y + 1) <= n-1 && !seDevuelve(x-2, y+1, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j]; 
                }
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x-2][y+1]);
             
            matrizNueva[x][y] = "0";
            matrizNueva[x-2][y+1]="1";
            Caballo nuevoCaballo = new Caballo(x-2, y+1);
            
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x - 2) >= 0 && (y - 1) >= 0 && !seDevuelve(x-2, y-1, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                }
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x-2][y-1]);
            matrizNueva[x][y] = "0";
            matrizNueva[x-2][y-1]="1";
            Caballo nuevoCaballo = new Caballo(x-2, y+1);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 2) <= n-1 && (y - 1) >= 0 && !seDevuelve(x+2, y-1, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x+2][y-1]);
            matrizNueva[x][y] = "0";
            matrizNueva[x+2][y-1]="1";
            Caballo nuevoCaballo = new Caballo(x+2, y-1);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 2) <= n-1 && (y + 1) <= n-1 && !seDevuelve(x+2, y+1, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+2][y+1]);
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+2][y+1]="1";
            Caballo nuevoCaballo = new Caballo(x+2, y+1);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 1) <= n-1 && (y + 2) <= n-1 && !seDevuelve(x+1, y+2, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+1][y+2]);
            
            matrizNueva[x][y] = "0";
            matrizNueva[x+1][y+2]="1";
            Caballo nuevoCaballo = new Caballo(x+1, y+2);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x - 1) >= 0 && (y + 2) <= n-1 && !seDevuelve(x-1, y+2, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x-1][y+2]);
            matrizNueva[x][y] = "0";
            matrizNueva[x-1][y+2]="1";
            Caballo nuevoCaballo = new Caballo(x-1, y+2);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x - 1) >= 0 && (y - 2) >= 0 && !seDevuelve(x-1, y-2, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x-1][y-2]);
            matrizNueva[x][y] = "0";
            matrizNueva[x-1][y-2]="1";
            Caballo nuevoCaballo = new Caballo(x-1, y-2);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
        
         if((x + 1) <= n-1 && (y - 2) >= 0 && !seDevuelve(x+1, y-2, nodo)){
            if(tipo.equals("MAX")){
                utilidad = 90;
            }
            else{
                utilidad = -90;
            }
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+1][y-2]);
            matrizNueva[x][y] = "0";
            matrizNueva[x+1][y-2]="1";
            Caballo nuevoCaballo = new Caballo(x+1, y-2);
            Nodo nodoHijo = new Nodo(tipo, utilidad, profundidad, matrizNueva, manzanas-valor, nuevoCaballo, nodo);
            nuevosNodos.add(nodoHijo);
                       
        }
       
       return nuevosNodos;
        
        
    }
    
    private boolean seDevuelve(int xNuevo, int yNuevo, Nodo nodo){
        if (nodo.getProfundidad() == 0) {
            return false;
        } 
        else {
            if (xNuevo == nodo.getPadre().getCaballo1().getPosX() &&
                yNuevo == nodo.getPadre().getCaballo1().getPosY()) {
                return true;
                
            }
            else{
                return false;
            }
            
        }
        
    }

    private int habiaManzana(String string) {
        if (string.equals("3")) {
            return 1;
        }
        else {
            return 0;
        }     
      
    }

    
}
