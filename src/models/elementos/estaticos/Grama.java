package models.elementos.estaticos;

import models.elementos.dinamicos.Player;

/**
 * Grama é um tile de movimentação livre
 * Esta classe herda da classe ElemEstatico.
 * 
 * @author NakyR19 - Rafael
 */
public class Grama extends ElemEstatico {
  /**
   * Construtor
   * 
   * @param x coordenada x
   * @param y coordenada y
   * 
   * @author NakyR19 - Rafael
   */
  public Grama(int x, int y) {
    super(x, y);
  }

  
  @Override
  public void interagir(Player player) {

  }
}
