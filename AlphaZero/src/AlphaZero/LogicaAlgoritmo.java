package AlphaZero;

import java.util.ArrayList;


public class LogicaAlgoritmo {
    
    public static int n;
    
    public LogicaAlgoritmo(int n){
        this.n = n;
        
    }
    
    /*public Nodo calcularUtilidad(Nodo nodo){
        if(nodo.getPadre() == null){
            return nodo;
        }
        else{
            
        }
        
    }*/

    public ArrayList<Nodo> expandirNodo(Nodo nodo){
        
        String[][] matriz = nodo.getEstadoJuego();
        String tipo = nodo.getTipo(); 
        int x = 0;
        int y = 0;
        int profundidad = nodo.getProfundidad()+1; 
        int manzanas = nodo.getManzanas();
        ArrayList<Nodo> nuevosNodos= new ArrayList<>();
        int utilidad = 0;
        
        if (tipo.equals("MAX")) {
            x = nodo.getCaballo1().getPosX();
            y = nodo.getCaballo1().getPosY();
        }
        else{
            x = nodo.getCaballo2().getPosX();
            y = nodo.getCaballo2().getPosY();
        }
        
        if(cambiarTipo(tipo).equals("MAX")){
                utilidad = -90;
            }
            else{
                utilidad = 90;
            }
        
        if((x - 2) >= 0 && (y + 1) <= n-1 && evitarCiclos(x-2, y+1, nodo, manzanas, tipo) && evitarCruces(nodo, x-2, y+1)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j]; 
                }
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x-2][y+1]);
             
            matrizNueva[x][y] = "0";
            if (tipo.equals("MAX")) {
                matrizNueva[x-2][y+1]="1";
            } else {
                matrizNueva[x-2][y+1]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x-2, y+1);
            
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            
            
            nuevosNodos.add(nodoHijo);
                       
        }
               
        if((x - 2) >= 0 && (y - 1) >= 0 && evitarCiclos(x-2, y-1, nodo, manzanas, tipo) && evitarCruces(nodo, x-2, y-1)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                }
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x-2][y-1]);
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x-2][y-1]="1";
            } else {
                matrizNueva[x-2][y-1]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x-2, y-1);
            
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 2) <= n-1 && (y - 1) >= 0 && evitarCiclos(x+2, y-1, nodo, manzanas, tipo) && evitarCruces(nodo, x+2, y-1)){
          
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            
            int valor = 0;
            valor = habiaManzana(matriz[x+2][y-1]);
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x+2][y-1]="1";
            } else {
                matrizNueva[x+2][y-1]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x+2, y-1);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 2) <= n-1 && (y + 1) <= n-1 && evitarCiclos(x+2, y+1, nodo, manzanas, tipo) && evitarCruces(nodo, x+2, y+1)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+2][y+1]);
            
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x+2][y+1]="1";
            } else {
                matrizNueva[x+2][y+1]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x+2, y+1);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x + 1) <= n-1 && (y + 2) <= n-1 && evitarCiclos(x+1, y+2, nodo, manzanas, tipo) && evitarCruces(nodo, x+1, y+2)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+1][y+2]);
            
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x+1][y+2]="1";
            } else {
                matrizNueva[x+1][y+2]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x+1, y+2);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x - 1) >= 0 && (y + 2) <= n-1 && evitarCiclos(x-1, y+2, nodo, manzanas, tipo) && evitarCruces(nodo, x-1, y+2)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x-1][y+2]);
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x-1][y+2]="1";
            } else {
                matrizNueva[x-1][y+2]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x-1, y+2);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
        
        if((x - 1) >= 0 && (y - 2) >= 0 && evitarCiclos(x-1, y-2, nodo, manzanas, tipo) && evitarCruces(nodo, x-1, y-2)){
            
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
                
            }
            int valor = 0;
            valor = habiaManzana(matriz[x-1][y-2]);
            matrizNueva[x][y] = "0";
            if (tipo.equals("MAX")) {
                matrizNueva[x-1][y-2]="1";
            } else {
                matrizNueva[x-1][y-2]="2";
            }
            
            Caballo nuevoCaballo = new Caballo(x-1, y-2);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
        
         if((x + 1) <= n-1 && (y - 2) >= 0 && evitarCiclos(x+1, y-2, nodo, manzanas, tipo) && evitarCruces(nodo, x+1, y-2)){
 
            String[][] matrizNueva = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                    
                }
            }
            int valor = 0;
            valor = habiaManzana(matriz[x+1][y-2]);
             
            matrizNueva[x][y] = "0";
            
            if (tipo.equals("MAX")) {
                matrizNueva[x+1][y-2]="1";
            } else {
                matrizNueva[x+1][y-2]="2";
            }
            
            matrizNueva[x+1][y-2]="1";
            Caballo nuevoCaballo = new Caballo(x+1, y-2);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);
                       
        }
       
       return nuevosNodos;
        
        
    }

    private int habiaManzana(String string) {
        if (string.equals("3")) {
            return 1;
        }
        else {
            return 0;
        }     
      
    }
    
    public boolean evitarCruces(Nodo nodo, int x, int y){
        
        
        if (nodo.getTipo().equals("MAX")) {
            if (x == nodo.getCaballo2().getPosX() && y == nodo.getCaballo2().getPosY()) {
                return false;
            }
            else{
                return true;
            }
            
        }
        else{
            if (x == nodo.getCaballo1().getPosX() && y == nodo.getCaballo1().getPosY()) {
                return false;
            }
            else{
                return true;
            }
            
        }
        
        
    }
    
    public boolean evitarCiclos(int x, int y, Nodo nodo, int manzanas, String tipo){
         
        if (nodo.getPadre() == null){
            return true;
        }
        else{
            if (tipo.equals("MAX")) {
                if (nodo.getPadre().getCaballo1().getPosX() == x &&
                nodo.getPadre().getCaballo1().getPosY() == y && 
                nodo.getPadre().getManzanas() == manzanas) {
                    
                    return false;
                } 
                else {
                    return evitarCiclos(x, y, nodo.getPadre(), manzanas, tipo);
                }
                
            }
            else{
                if (nodo.getPadre().getCaballo2().getPosX() == x &&
                nodo.getPadre().getCaballo2().getPosY() == y && 
                nodo.getPadre().getManzanas() == manzanas) {
                    return false;
                } 
                else {
                    return evitarCiclos(x, y, nodo.getPadre(), manzanas, tipo);
                }
                
            }
            
        }
    }
    
    public String cambiarTipo(String tipo){
        if (tipo.equals("MAX")) {
            return "MIN";
            
        } else {
            return "MAX";
        }
    }
    
    

    
}
