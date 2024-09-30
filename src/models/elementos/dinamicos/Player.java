package models.elementos.dinamicos;

// Apenas implementando logica de movimento e comando do teclado, implementar mochila e outros posteriormente
/**
 * Player representa um jogador que pode se mover, e que tem uma mochila com frutas.
 * Esta classe herda da classe ElemDinamico.
 * @author NakyR19 - Rafael
 */
public class Player extends ElemDinamico {

    /**
     * Construtor da classe Player.
     * @param x A coordenada x inicial do jogador.
     * @param y A coordenada y inicial do jogador.
     */
    public Player(int x, int y) {
        super(x, y);
    }

    /**
     * Move o jogador para uma nova posição.
     * @param x A nova coordenada x do jogador.
     * @param y A nova coordenada y do jogador.
     */
    @Override
    public void mover(int x, int y) {
        this.x = x;    
        this.y = y;
    }
}