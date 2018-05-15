
package AlphaZero;

public class Caballo {
    private int posX;
    private int posY;
    private int manzanasComidas;
    
    public Caballo(int x, int y){
        posX = x;
        posY = y;
        
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the manzanasComidas
     */
    public int getManzanasComidas() {
        return manzanasComidas;
    }

    /**
     * @param manzanasComidas the manzanasComidas to set
     */
    public void setManzanasComidas(int manzanasComidas) {
        this.manzanasComidas = manzanasComidas;
    }
    
    
}
