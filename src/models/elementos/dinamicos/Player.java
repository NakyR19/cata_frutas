package models.elementos.dinamicos;

// Apenas implementando logica de movimento e comando do teclado, implementar mochila e outros posteriormente
public class Player extends ElemDinamico {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void mover(int x, int y) {
        this.x += x;    
        this.y += y;
    }
}