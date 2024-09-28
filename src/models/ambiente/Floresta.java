package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;

public class Floresta {
  private int dimensao;
  private Elemento[][] elementos;
  private int numPedras;
  public Floresta(int dimensao, int numPedras) {
    this.numPedras = numPedras;
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia(); // Adivinha oq ele gera?
    gerarPedras();
    gerarPlayer();
  }

  // Gera a floresta sem elementos além de grama
  public void gerarFlorestaVazia() {
    for (int i = 0; i < getDimensao(); i++) {
      for (int j = 0; j < getDimensao(); j++) {
        elementos[i][j] = new Grama(i, j); // Cada posição está vazia (sem elementos)
      }
    }
  }

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

  public void gerarPlayer() {
    Random gerador = new Random();
    int playerColocados = 0;
    while (playerColocados < 2) {
      int x = gerador.nextInt(6);
      int y = gerador.nextInt(6);
      if (elementos[x][y] instanceof Grama) {
        elementos[x][y] = new Player(x, y);
        playerColocados++;
      }
    }

  }

  public Player getPlayer() {
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        if (elementos[i][j] instanceof Player) {
          return (Player) elementos[i][j];
        }
      }
    }
    return null; // Se não encontrar o Player, retorne null
  }

  public boolean isCollision(int x, int y) {
    // Verifica se a posição está dentro dos limites
    if (x < 0 || x >= dimensao || y < 0 || y >= dimensao) {
      return true; // Fora dos limites é considerado uma colisão
    }
    // Verifica se a posição está ocupada por um elemento diferente de Grama
    return !(elementos[x][y] instanceof Grama);
  }

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
