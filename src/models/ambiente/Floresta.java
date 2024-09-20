package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.estaticos.Grama;

public class Floresta {
  private int dimensao;
  private Elemento[][] elementos;

  public Floresta(int dimensao) {
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia(); // Adivinha oq ele gera?
  }

  // Gera a floresta sem elementos
  public void gerarFlorestaVazia() {
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        elementos[i][j] = new Grama(i, j); // Cada posição está vazia (sem elementos)
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
