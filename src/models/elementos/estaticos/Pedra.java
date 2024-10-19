package models.elementos.estaticos;

//import controllers.PlayerControllr;
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
      int newX = player.getX();
      int newY = player.getY();
      boolean podePular = false;
      switch (player.getDirecaoAtual()) {
        case "direita":
          if(newX + 2 < player.getPlayerController().getFlorestaComponent().getFloresta().getDimensao()){
            podePular = false;
          } else {
              newX += 2;
          }
          break;
      case "esquerda":
          if (newX - 2 < 0) {
              podePular = false;
          } else {
              newX -= 2;
          }
          break;
      case "cima":
          if (newY - 2 < 0 ) {
              podePular = false;
          } else {
              newY -= 2;
          }
          break;
      case "baixo":
          if (newY + 2 >= player.getPlayerController().getFlorestaComponent().getFloresta().getDimensao()) {
              podePular = false;
          } else {
              newY += 2;
          }
        default:
            System.out.print("Erro");
      }

      if (podePular) {
          player.getPlayerController().verificarPedra();
          player.mover(newX, newY);
          player.setPontosMovimento(player.getPontosMovimento() - 3);
          System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
      } else {
          System.out.println("Você não pode pular a pedra");
      }
      
    } else {
      System.out.println("Você não tem pontos suficientes para pular a pedra.");
    }
    
  }

}
