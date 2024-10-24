package models.elementos.estaticos;

import models.ambiente.Floresta;
//import controllers.PlayerController;
import models.elementos.dinamicos.Player;



/**
 * Pedra
 * Esta classe herda da classe ElemEstatico.
 * 
 * @author NakyR19 - Rafael
 */
public class Pedra extends ElemEstatico{

    public Floresta floresta;
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
    public Floresta getFloresta(){
        return floresta;
    }
    public void setFloresta( Floresta floresta){
        this.floresta = floresta;
    }
    /*public boolean extremoMapa(Floresta floresta, int x, int y){
        if(x + 1 > floresta.getDimensao() || y + 1 > floresta.getDimensao()){
            return true;

        }else{
            return false; 
        }

    }*/
  @Override
  public void interagir(Player player) {
    int newX = player.getX();
    int newY = player.getY();
    if (player.getPlayerController().contPedras > 0){
        int contPedras = player.getPlayerController().contPedras;
        if (player.getPontosMovimento() >= 3*contPedras){
        switch (player.getDirecaoAtual()) {
            case "direita": 
                newX = newX + contPedras + 1;
                player.mover(newX, newY);
                player.setPontosMovimento(player.getPontosMovimento() - 2*contPedras - 1);
                System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
                player.getPlayerController().florestaComponent.repaint();
                    
                break;
            case "esquerda":
                newX = newX - contPedras - 1 ;
                player.mover(newX, newY);
                player.setPontosMovimento(player.getPontosMovimento() - 2*contPedras - 1);
                System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
                player.getPlayerController().florestaComponent.repaint();
                    
                break;
            case "cima":
                newY = newY - contPedras - 1 ;
                player.mover(newX, newY);
                player.setPontosMovimento(player.getPontosMovimento() - 2*contPedras - 1);
                System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
                player.getPlayerController().florestaComponent.repaint();
                    
                break;
            case "baixo":
                newY = newY + contPedras + 1 ;
                player.mover(newX, newY);
                player.setPontosMovimento(player.getPontosMovimento() - 2*contPedras - 1);
                System.out.println("Jogador " + player.getId() + " moveu para (" + newX + ", " + newY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
                player.getPlayerController().florestaComponent.repaint();
                    
                break;
            default:
                System.out.print("Erro");
        }

        } else {
            System.out.println("Você não tem pontos suficientes para pular a pedra.");
        }
        
    }
}

}