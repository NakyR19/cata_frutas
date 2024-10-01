package models.elementos.estaticos;

import models.elementos.dinamicos.Player;

/**
 * Pedra
 * Esta classe herda da classe ElemEstatico.
 * 
 * @author NakyR19 - Rafael
 */
public class Pedra extends ElemEstatico{
  /**
   * Construtor
   * 
   * @param x coordenada x
   * @param y coordenada y
   */
  public Pedra(int x, int y) {

    super(x, y);
  }

  /**
   * Interage com o elemento Pedra no jogo. O competidor
   * deve gastar pontos de movimento para pular a pedra. Se não houver pontos suficientes,
   * o competidor permanece na célula anterior.
   *
   *
   * @param p o jogador que está interagindo com a pedra.
   * @todo Implementar a lógica de pular a pedra e verificar os pontos de movimento do jogador.
   *
   * @author MariaLuizaCA - Maria Luíza
   */
  @Override
  public void interagir() {
    /*
    if (p.getPontosMov() >= 3) {  // 1 ponto para chegar + 1 ponto para pular + 1 ponto para avançar
        // Implementar a lógica de diminuir os pontos de movimento - p.TirarPontos(3)
        // Implementar a lógica de movimento do jogador - p.MoverDeLugar()
    } else {
        System.out.println("Você não tem pontos suficientes para pular a pedra.");
    }
    */
  }

}
