package models.elementos;
import java.awt.Graphics;

public abstract class Elemento {
    protected int x, y; // Posição no tabuleiro

    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método abstrato para desenhar o elemento
    public abstract void desenhar(Graphics g);
}
