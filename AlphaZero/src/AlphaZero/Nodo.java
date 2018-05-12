package AlphaZero;

public class Nodo {
    private String tipo;
    private int utilidad;
    private int profundidad;
    private String[][] estadoJuego = new String[6][6];
    
    
    public Nodo(String tip, int util, int prof, String[][] estado){
        tipo = tip;
        utilidad = util;
        profundidad = prof;
        estadoJuego = estado;
             
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
    
}
