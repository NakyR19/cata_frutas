package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;


public class Floresta {
  private int dimensao;
  private Elemento[][] elementos;

  public Floresta(int dimensao) {
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia(); // Adivinha oq ele gera?
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
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
         int x = gerador.nextInt(6);
         int y = gerador.nextInt(6);
        elementos[x][y] = new Pedra(i, j); // Cada posição está vazia (sem elementos)
      }
    }
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
