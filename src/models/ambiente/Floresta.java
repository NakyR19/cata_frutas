package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;

public class Floresta {
  private int dimensao;
  private Elemento[][] elementos;

  public Floresta(int dimensao) {
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia(); // Adivinha oq ele gera?
    gerarPedras();
    gerarPlayer();
  }

  // Gera a floresta sem elementos além de grama
  public void gerarFlorestaVazia() {
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        elementos[i][j] = new Grama(i, j); // Cada posição está vazia (sem elementos)
      }
    }
  }

  public void gerarPedras() {
    Random gerador = new Random();
    int pedrasColocadas = 0;
    while (pedrasColocadas < 7) {
      int x = gerador.nextInt(6);
      int y = gerador.nextInt(6);
      if (elementos[x][y] instanceof Grama) {
        elementos[x][y] = new Pedra(x, y);
        pedrasColocadas++;
      }
    }

  }
  public void gerarPlayer() {
    Random gerador = new Random();
    int playerColocados = 0;
    while (playerColocados < 1) {
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
