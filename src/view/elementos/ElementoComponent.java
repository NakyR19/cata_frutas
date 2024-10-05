package view.elementos;

import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * A classe abstrata ElementoComponent representa um componente gráfico genérico para elementos do jogo.
 * Herda de JComponent e define um método abstrato para desenhar o elemento.
 * @author NakyR19 - Rafael   
 */
public abstract class ElementoComponent extends JComponent {
  /**
   * Construtor da classe ElementoComponent.
   */
  public ElementoComponent() {
  }

  /**
   * Método abstrato para desenhar o elemento.
   *
   * @param g        O objeto Graphics usado para desenhar o componente.
   * @param x        A coordenada x onde o elemento será desenhado.
   * @param y        A coordenada y onde o elemento será desenhado.
   * @param cellSize O tamanho da célula em pixels.
   */
  public abstract void desenhar(Graphics g, int x, int y, int cellSize);

}