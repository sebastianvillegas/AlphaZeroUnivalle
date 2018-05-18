package AlphaZero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LogicaAlgoritmo {

    public static int n;
    public static int manzanas;
    private int xDecisionTomar;
    private int yDecisionTomar;
    private int xInicialBlanco;
    private int yInicialBlanco;
    private int xInicialNegro;
    private int yInicialNegro;
    private Stack<Nodo> pila;
    

    public LogicaAlgoritmo(int n, int manzanas) {
        this.manzanas = manzanas;
        this.n = n;
        pila = new Stack<>();
        xInicialBlanco = 0;
        yInicialBlanco = 0;
        xInicialNegro = 1;
        yInicialNegro = 0;

    }

    public ArrayList<Nodo> expandirNodo(Nodo nodo) {

        String[][] matriz = nodo.getEstadoJuego();
        String tipo = nodo.getTipo();
        int x = 0;
        int y = 0;
        int profundidad = nodo.getProfundidad() + 1;
        int manzanas = nodo.getManzanas();
        int manzanasComidas1 = nodo.getCaballo1().getManzanasComidas();
        int manzanasComidas2 = nodo.getCaballo2().getManzanasComidas();
        ArrayList<Nodo> nuevosNodos = new ArrayList<>();
        int utilidad = 0;

        if (tipo.equals("MAX")) {
            x = nodo.getCaballo1().getPosX();
            y = nodo.getCaballo1().getPosY();
        } else {
            x = nodo.getCaballo2().getPosX();
            y = nodo.getCaballo2().getPosY();
        }

        if (cambiarTipo(tipo).equals("MAX")) {
            utilidad = -90;
        } else {
            utilidad = 90;
        }

        if ((x - 2) >= 0 && (y + 1) <= n - 1 && evitarCiclos(x - 2, y + 1, nodo, manzanas, tipo) && evitarCruces(nodo, x - 2, y + 1)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                }
            }

            int valor = 0;
            valor = habiaManzana(matriz[x - 2][y + 1]);

            matrizNueva[x][y] = "0";
            if (tipo.equals("MAX")) {
                matrizNueva[x - 2][y + 1] = "1";
            } else {
                matrizNueva[x - 2][y + 1] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x - 2, y + 1, nodo, valor);

            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }

            nuevosNodos.add(nodoHijo);

        }

        if ((x - 2) >= 0 && (y - 1) >= 0 && evitarCiclos(x - 2, y - 1, nodo, manzanas, tipo) && evitarCruces(nodo, x - 2, y - 1)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];
                }
            }

            int valor = 0;
            valor = habiaManzana(matriz[x - 2][y - 1]);
            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x - 2][y - 1] = "1";
            } else {
                matrizNueva[x - 2][y - 1] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x - 2, y - 1, nodo, valor);

            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }

            nuevosNodos.add(nodoHijo);

        }

        if ((x + 2) <= n - 1 && (y - 1) >= 0 && evitarCiclos(x + 2, y - 1, nodo, manzanas, tipo) && evitarCruces(nodo, x + 2, y - 1)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }

            }

            int valor = 0;
            valor = habiaManzana(matriz[x + 2][y - 1]);
            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x + 2][y - 1] = "1";
            } else {
                matrizNueva[x + 2][y - 1] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x + 2, y - 1, nodo, valor);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);

        }

        if ((x + 2) <= n - 1 && (y + 1) <= n - 1 && evitarCiclos(x + 2, y + 1, nodo, manzanas, tipo) && evitarCruces(nodo, x + 2, y + 1)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }

            }
            int valor = 0;
            valor = habiaManzana(matriz[x + 2][y + 1]);

            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x + 2][y + 1] = "1";
            } else {
                matrizNueva[x + 2][y + 1] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x + 2, y + 1, nodo, valor);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);

        }

        if ((x + 1) <= n - 1 && (y + 2) <= n - 1 && evitarCiclos(x + 1, y + 2, nodo, manzanas, tipo) && evitarCruces(nodo, x + 1, y + 2)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }

            }
            int valor = 0;
            valor = habiaManzana(matriz[x + 1][y + 2]);

            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x + 1][y + 2] = "1";
            } else {
                matrizNueva[x + 1][y + 2] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x + 1, y + 2, nodo, valor);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);

        }

        if ((x - 1) >= 0 && (y + 2) <= n - 1 && evitarCiclos(x - 1, y + 2, nodo, manzanas, tipo) && evitarCruces(nodo, x - 1, y + 2)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }

            }
            int valor = 0;
            valor = habiaManzana(matriz[x - 1][y + 2]);
            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x - 1][y + 2] = "1";
            } else {
                matrizNueva[x - 1][y + 2] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x - 1, y + 2, nodo, valor);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);

        }

        if ((x - 1) >= 0 && (y - 2) >= 0 && evitarCiclos(x - 1, y - 2, nodo, manzanas, tipo) && evitarCruces(nodo, x - 1, y - 2)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }

            }
            int valor = 0;
            valor = habiaManzana(matriz[x - 1][y - 2]);
            matrizNueva[x][y] = "0";
            if (tipo.equals("MAX")) {
                matrizNueva[x - 1][y - 2] = "1";
            } else {
                matrizNueva[x - 1][y - 2] = "2";
            }

            Caballo nuevoCaballo = crearCaballo(x - 1, y - 2, nodo, valor);
            Nodo nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            if (tipo.equals("MAX")) {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nuevoCaballo, nodo.getCaballo2(), nodo);
            } else {
                nodoHijo = new Nodo(cambiarTipo(tipo), utilidad, profundidad, matrizNueva, manzanas - valor, nodo.getCaballo1(), nuevoCaballo, nodo);
            }
            nuevosNodos.add(nodoHijo);

        }

        if ((x + 1) <= n - 1 && (y - 2) >= 0 && evitarCiclos(x + 1, y - 2, nodo, manzanas, tipo) && evitarCruces(nodo, x + 1, y - 2)) {

            String[][] matrizNueva = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizNueva[i][j] = matriz[i][j];

                }
            }
            int valor = 0;
            valor = habiaManzana(matriz[x + 1][y - 2]);

            matrizNueva[x][y] = "0";

            if (tipo.equals("MAX")) {
                matrizNueva[x + 1][y - 2] = "1";
            } else {
                matrizNueva[x + 1][y - 2] = "2";
            }

            matrizNueva[x + 1][y - 2] = "1";
            Caballo nuevoCaballo = crearCaballo(x + 1, y - 2, nodo, valor);
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
        } else {
            return 0;
        }

    }

    public boolean evitarCruces(Nodo nodo, int x, int y) {

        if (nodo.getTipo().equals("MAX")) {
            if (x == nodo.getCaballo2().getPosX() && y == nodo.getCaballo2().getPosY()) {
                return false;
            } else {
                return true;
            }

        } else {
            if (x == nodo.getCaballo1().getPosX() && y == nodo.getCaballo1().getPosY()) {
                return false;
            } else {
                return true;
            }

        }

    }

    public boolean evitarCiclos(int x, int y, Nodo nodo, int manzanas, String tipo) {

        if (nodo.getPadre() == null) {
            return true;
        } else {
            if (tipo.equals("MAX")) {
                if (nodo.getPadre().getCaballo1().getPosX() == x
                        && nodo.getPadre().getCaballo1().getPosY() == y
                        && nodo.getPadre().getManzanas() == manzanas) {

                    return false;
                } else {
                    return evitarCiclos(x, y, nodo.getPadre(), manzanas, tipo);
                }

            } else {
                if (nodo.getPadre().getCaballo2().getPosX() == x
                        && nodo.getPadre().getCaballo2().getPosY() == y
                        && nodo.getPadre().getManzanas() == manzanas) {
                    return false;
                } else {
                    return evitarCiclos(x, y, nodo.getPadre(), manzanas, tipo);
                }

            }

        }
    }

    public String cambiarTipo(String tipo) {
        if (tipo.equals("MAX")) {
            return "MIN";

        } else {
            return "MAX";
        }
    }

    public void calcularUtilidades(ArrayList<Nodo> fin) {
        for (int i = 0; i < fin.size(); i++) {
            subirUtilidad(fin.get(i));

        }

    }

    private void subirUtilidad(Nodo nodo) {

        if (nodo.getProfundidad() == 1) {
            if (nodo.getUtilidad() > nodo.getPadre().getUtilidad()) {

                this.setxDecisionTomar(nodo.getCaballo1().getPosX());
                this.setyDecisionTomar(nodo.getCaballo1().getPosY());

            }

        }

        if (nodo.getPadre() != null) {
            if (nodo.getPadre().getTipo().equals("MAX")) {

                if (nodo.getPadre().getUtilidad() < nodo.getUtilidad()) {
                    nodo.getPadre().setUtilidad(nodo.getUtilidad());
                }

            } else {

                if (nodo.getPadre().getUtilidad() > nodo.getUtilidad()) {
                    nodo.getPadre().setUtilidad(nodo.getUtilidad());
                }

            }

        }

    }

    private Caballo crearCaballo(int x, int y, Nodo nodo, int valor) {
        Caballo nuevoCaballo = new Caballo(x, y, nodo.getCaballo1().getManzanasComidas());

        if (nodo.getTipo().equals("MAX")) {
            if (valor == 1) {
                nuevoCaballo = new Caballo(x, y, nodo.getCaballo1().getManzanasComidas() + 1);
            } else {
                nuevoCaballo = new Caballo(x, y, nodo.getCaballo1().getManzanasComidas());
            }
        } else {
            if (valor == 1) {
                nuevoCaballo = new Caballo(x, y, nodo.getCaballo2().getManzanasComidas() + 1);
            } else {
                nuevoCaballo = new Caballo(x, y, nodo.getCaballo2().getManzanasComidas());
            }
        }
        return nuevoCaballo;
    }

    public void cambiarUtilidadHojas(Nodo hoja) {
        if (hoja.getCaballo1().getManzanasComidas() > hoja.getCaballo2().getManzanasComidas()) {
            hoja.setUtilidad(1);
        } else {
            hoja.setUtilidad(-1);
        }
    }

    public ArrayList<Nodo> generarArregloFinal() {
        ArrayList<Nodo> arregloFinal = new ArrayList<>(); //Arreglo donde se guardaran todos los nodos

        //El algoritmo se ejecutara mientras haya nodos en la pila
        while (!pila.isEmpty()) {
            ArrayList<Nodo> arreglo = new ArrayList<>();//Arreglo para guardar los nodos expandidos

            //Prints para probar
            if (pila.peek().getTipo().equals("MAX")) {
                System.out.println("Turno del 1");

            } else {
                System.out.println("Turno del 2");
            }

            for (int l = 0; l < n; l++) {
                for (int m = 0; m < n; m++) {
                    System.out.print(pila.peek().getEstadoJuego()[l][m] + " ");
                }
                System.out.println("");
            }

            System.out.println("Profundidad: " + pila.peek().getProfundidad());
            System.out.println("manzanas: " + pila.peek().getManzanas()
                    + "Manzanas caballo 1: " + pila.peek().getCaballo1().getManzanasComidas()
                    + " Manzanas caballo 2: " + pila.peek().getCaballo2().getManzanasComidas());

            //Si todavía quedan manzanas en el juego, se sigue expandiendo esa rama.
            if (pila.peek().getManzanas() > 0) {
                arreglo = expandirNodo(pila.peek());
            } //En caso de que no hayan manzanas, se llega a una hoja así que se debe calcular su utilidad
            else {
                cambiarUtilidadHojas(pila.peek());
            }

            //Imprimir los nodos expandidos
            System.out.println("Nodos generados ");
            for (int i = 0; i < arreglo.size(); i++) {
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        System.out.print(arreglo.get(i).getEstadoJuego()[l][m] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("");
            }

            System.out.println("Fin de mostrar los nodos generados.");

            //El nodo que fue expandido se agrega al arreglo final y es borrado de la pila.
            arregloFinal.add(pila.pop());

            //Se agregan a la pila los nodos generados
            for (int k = 0; k < arreglo.size(); k++) {
                pila.push(arreglo.get(k));
            }
        }
        return arregloFinal;

    }

    public void tomarDecision(String[][] matriz) {
        Caballo caballo1 = new Caballo(xInicialBlanco, yInicialBlanco, 0);
        Caballo caballo2 = new Caballo(xInicialNegro, yInicialNegro, 0);
        Nodo raiz = new Nodo("MAX", -90, 0, matriz, manzanas, caballo1, caballo2, null);
        pila.push(raiz);
        ArrayList<Nodo> fin = new ArrayList<>();
        fin = generarArregloFinal();

        Collections.sort(fin, (Nodo z1, Nodo z2) -> {
            if (z1.getProfundidad() < z2.getProfundidad()) {
                return 1;
            }
            if (z1.getProfundidad() > z2.getProfundidad()) {
                return -1;
            }
            return 0;
        });

        calcularUtilidades(fin);

        System.out.println(fin.size());
        for (int k = 0; k < fin.size(); k++) {
            System.out.println("Tipo: " + fin.get(k).getTipo() + " Profundidad: "
                    + fin.get(k).getProfundidad()
                    + " Utilidad: " + fin.get(k).getUtilidad()
                    + "Manzanas caballo 1: " + fin.get(k).getCaballo1().getManzanasComidas()
                    + "Manzanas caballo 2: " + fin.get(k).getCaballo2().getManzanasComidas());

        }

        System.out.println("X: " + getxDecisionTomar() + "Y: " + getyDecisionTomar());
    }

    /**
     * @return the xInicialBlanco
     */
    public int getxInicialBlanco() {
        return xInicialBlanco;
    }

    /**
     * @param xInicialBlanco the xInicialBlanco to set
     */
    public void setxInicialBlanco(int xInicialBlanco) {
        this.xInicialBlanco = xInicialBlanco;
    }

    /**
     * @return the yInicialBlanco
     */
    public int getyInicialBlanco() {
        return yInicialBlanco;
    }

    /**
     * @param yInicialBlanco the yInicialBlanco to set
     */
    public void setyInicialBlanco(int yInicialBlanco) {
        this.yInicialBlanco = yInicialBlanco;
    }

    /**
     * @return the xInicialNegro
     */
    public int getxInicialNegro() {
        return xInicialNegro;
    }

    /**
     * @param xInicialNegro the xInicialNegro to set
     */
    public void setxInicialNegro(int xInicialNegro) {
        this.xInicialNegro = xInicialNegro;
    }

    /**
     * @return the yInicialNegro
     */
    public int getyInicialNegro() {
        return yInicialNegro;
    }

    /**
     * @param yInicialNegro the yInicialNegro to set
     */
    public void setyInicialNegro(int yInicialNegro) {
        this.yInicialNegro = yInicialNegro;
    }

    /**
     * @return the xDecisionTomar
     */
    public int getxDecisionTomar() {
        return xDecisionTomar;
    }

    /**
     * @param xDecisionTomar the xDecisionTomar to set
     */
    public void setxDecisionTomar(int xDecisionTomar) {
        this.xDecisionTomar = xDecisionTomar;
    }

    /**
     * @return the yDecisionTomar
     */
    public int getyDecisionTomar() {
        return yDecisionTomar;
    }

    /**
     * @param yDecisionTomar the yDecisionTomar to set
     */
    public void setyDecisionTomar(int yDecisionTomar) {
        this.yDecisionTomar = yDecisionTomar;
    }

}
