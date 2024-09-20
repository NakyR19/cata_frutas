package view.elementos;
import java.awt.Graphics;

public abstract class ElementoComponent{
  public ElementoComponent(){}

  // Método abstrato para desenhar o elemento
  public abstract void desenhar(Graphics g, int x, int y, int cellSize);
}