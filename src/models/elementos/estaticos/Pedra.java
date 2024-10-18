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
  public void interagir(Player player) {

    if (player.getPontosMovimento() >= 3){
      player.setPontosMovimento(player.getPontosMovimento() - 3);
      int newX = player.getX();
      int newY = player.getY();
      switch (player.getDirecaoAtual()) {
        case "direita":
            newX += 2;
            player.mover(newX, newY);
            System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
    
            break;
        case "esquerda":
            newX -= 2;
            player.mover(newX, newY);
            System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");

            break;
        case "cima":
            newY -= 2;
            player.mover(newX, newY);
            System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");

            break;
        case "baixo":
            newY += 2;
            player.mover(newX, newY);
            System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");

            break;
        default:
            System.out.print("Erro");
      }
    } else {
      System.out.println("Você não tem pontos suficientes para pular a pedra.");
    }
    
  }

}
