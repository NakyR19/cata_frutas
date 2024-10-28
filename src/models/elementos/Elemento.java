package models.elementos;

/**
 * Abstract Class Elemento representa um elemento da floresta
 * 
 * @author NakyR19 - Rafael
 */
public abstract class Elemento {
    /**
     * Coordenadas
     */
    protected int x, y;
    
    /**
   * Construtor
   * 
   * @param x coordenada x
   * @param y coordenada y
   * 
   * @author NakyR19 - Rafael
   */
    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
