package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;

/**
 * Floresta representa uma matriz composta por elementos.
 */
public class Floresta {
  /**
   * ############ ATRIBUTOS ############
   * dimensao - A dimensão da floresta (número de linhas e colunas).
   * elementos - A matriz de elementos que compõem a floresta.
   * numPedras - O número de pedras existentes na floresta.
   */
  private int dimensao;
  private Elemento[][] elementos;
  private int numPedras;

  /**
   * ############ CONSTRUTOR ############
   * @param dimensao  a dimensão da floresta
   * @param numPedras o número de pedras na floresta
   */
  public Floresta(int dimensao, int numPedras) {
    this.numPedras = numPedras;
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia();
    gerarPedras();
    gerarPlayers();
  }

  /**
     * @author NakyR19 - Rafael
     * Gera a floresta sem outros elementos além de grama.
     */
  public void gerarFlorestaVazia() {
    for (int i = 0; i < getDimensao(); i++) {
      for (int j = 0; j < getDimensao(); j++) {
        elementos[i][j] = new Grama(i, j); // Cada posição está vazia (sem elementos)
      }
    }
  }

  /**
     * @author NakyR19 - Rafael
     * Gera pedras aleatoriamente na floresta.
     */
  public void gerarPedras() {
    Random gerador = new Random();
    int pedrasColocadas = 0;
    while (pedrasColocadas < numPedras) {
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if (elementos[x][y] instanceof Grama) {
        elementos[x][y] = new Pedra(x, y);
        pedrasColocadas++;
      }
    }

  }
  /**
     * @author NakyR19 - Rafael
     * Gera os jogadores na floresta.
     */
    public void gerarPlayers() {
      Random gerador = new Random();
      int playerColocados = 0;
      String[] ids = {"p1", "p2"};
      
      while (playerColocados < 2) {
          int x = gerador.nextInt(6);
          int y = gerador.nextInt(6);
          if (elementos[x][y] instanceof Grama) {
              elementos[x][y] = new Player(x, y, ids[playerColocados]);
              System.out.println("Gerando jogador " + ids[playerColocados] + " na posição (" + x + ", " + y + ")");
              playerColocados++;
          }
      }


  }

  /**
 * Percorre a matriz afim de coletar o jogador presente na floresta.
 * @author NakyR19 - Rafael
 * @param id Id do jogador
 * @return o jogador presente na floresta, ou null se não houver jogador.
 */
public Player getPlayer(String id) {
  for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
          if (elementos[i][j] instanceof Player) {
              Player player = (Player) elementos[i][j];
              if (player.getId().equals(id)) {
                  return player;
              }
          }
      }
  }
  return null; 
}
  
  /**
   * Verifica se há uma colisão na posição especificada.
   * @author NakyR19 - Rafael
   * @param x a coordenada x da posição a ser verificada.
   * @param y a coordenada y da posição a ser verificada.
   * @return true se houver uma colisão, false caso contrário.
   */
  public boolean isCollision(int x, int y) {
    // Verifica se a posição está dentro dos limites
    if (x < 0 || x >= dimensao || y < 0 || y >= dimensao) {
      return true; // Fora dos limites é considerado uma colisão
    }
    // Verifica se a posição está ocupada por um elemento diferente de Grama
    return !(elementos[x][y] instanceof Grama);
  }

  /**
   * Seta um piso de coordenadas (x,y) como grama
   * @author NakyR19 - Rafael
   * @param x coordenada
   * @param y coordenada
   */
  public void setTileAsGrama(int x, int y) {
    elementos[x][y] = new Grama(x, y);
  }

  public int getDimensao() {
    return dimensao;
  }

  public void setDimensao(int d) {
    this.dimensao = d;
  }

  public Elemento[][] getElementos() {
    return elementos;
  }

  public void setElementos(Elemento[][] e) {
    this.elementos = e;
  }
}
