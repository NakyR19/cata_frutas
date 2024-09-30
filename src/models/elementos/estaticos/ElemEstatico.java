package models.elementos.estaticos;

import models.elementos.Elemento;

/**
 * Abstract Class ElemEstatico representa um elemento dinâmico que não pode se
 * mover.
 * Esta classe herda da classe Elemento.
 * 
 * @author NakyR19 - Rafael
 */
public abstract class ElemEstatico extends Elemento {
  /**
   * Construtor
   * 
   * @param x coordenada x do elemento.
   * @param y coordenada y do elemento.
   */
  public ElemEstatico(int x, int y) {
    super(x, y);
  }

  /**
   * Método abstrato para determinar a ação do elemento após interação.
   */
  public abstract void interagir();
}
