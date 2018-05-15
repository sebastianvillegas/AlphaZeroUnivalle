package AlphaZero;

public class Nodo {
    private String tipo;
    private int utilidad;
    private int profundidad;
    private String[][] estadoJuego = new String[6][6];
    private int manzanas;
    private Caballo caballo1;
    private Nodo padre;
    
    
    public Nodo(String tip, int util, int prof, String[][] estado, int man, Caballo horse1, Nodo padre){
        tipo = tip;
        utilidad = util;
        profundidad = prof;
        estadoJuego = estado;
        manzanas = man;
        caballo1 = horse1;
        this.padre = padre;
             
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the utilidad
     */
    public int getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }

    /**
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    /**
     * @return the estadoJuego
     */
    public String[][] getEstadoJuego() {
        return estadoJuego;
    }

    /**
     * @param estadoJuego the estadoJuego to set
     */
    public void setEstadoJuego(String[][] estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    /**
     * @return the caballo1
     */
    public Caballo getCaballo1() {
        return caballo1;
    }

    /**
     * @param caballo1 the caballo1 to set
     */
    public void setCaballo1(Caballo caballo1) {
        this.caballo1 = caballo1;
    }

    /**
     * @return the manzanas
     */
    public int getManzanas() {
        return manzanas;
    }

    /**
     * @param manzanas the manzanas to set
     */
    public void setManzanas(int manzanas) {
        this.manzanas = manzanas;
    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
}
