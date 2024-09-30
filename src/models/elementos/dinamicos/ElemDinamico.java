package models.elementos.dinamicos;
import models.elementos.Elemento;

/**
 * Abstract Class ElemDinamico representa um elemento dinâmico que pode se mover.
 * Esta classe herda da classe Elemento.
 * @author NakyR19 - Rafael
 */
public abstract class ElemDinamico extends Elemento {

    /**
     * Construtor
     * @param x coordenada x do elemento.
     * @param y coordenada y do elemento.
     */
    public ElemDinamico(int x, int y) {
        super(x, y);
    }

    /**
     * Método abstrato para mover o elemento para uma nova posição.
     * @param x A nova coordenada x do elemento.
     * @param y A nova coordenada y do elemento.
     */
    public abstract void mover(int x, int y);

}