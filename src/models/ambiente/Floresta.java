package models.ambiente;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;

public class Floresta extends JPanel {
  private int dimensao;
  private Elemento[][] elementos;
  private Image background;

  public Floresta(int dimensao) {
    this.dimensao = dimensao;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFloresta(); // Adivinha oq ele gera?
    ImageIcon referencia = new ImageIcon("src/main/res/background.png"); // ALTERAR PATH
    background = referencia.getImage();
  }

  // Gera a floresta preenchendo a matriz com as porras dos elementos
  public void gerarFloresta() {
    Random random = new Random();
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        // Tentando gerar aleatoriamente alguns elemento
        if (random.nextBoolean()) {
          elementos[i][j] = new Arvore(1, 5); // Exemplo de árvore
          elementos[i][j] = new Arvore(5, 4); // Exemplo de árvore
          elementos[i][j] = new Arvore(2, 2); // Exemplo de árvore
          elementos[i][j] = new Arvore(5, 3); // Exemplo de árvore
        } else {
          elementos[i][j] = new Arvore(5, 1);
        }
      }
    }
  }

  // Sobrescreve o método paint para desenhar o background e os elementos
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D graficos = (Graphics2D) g;
    graficos.drawImage(background, 0, 0, getWidth(), getHeight(), null); // rever

    // Iterando sobre os elementos e desenhando-os na floresta (talvez tenha
    // assasinado o portugues aqui)
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        if (elementos[i][j] != null) {
          elementos[i][j].desenhar(g); // Método que desenha o elemento
        }
      }
    }
    g.dispose();
  }
}
