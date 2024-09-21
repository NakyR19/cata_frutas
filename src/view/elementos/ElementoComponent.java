package view.elementos;
import java.awt.Graphics;

import javax.swing.JComponent;

//ElementComponent precisa extender Jcomponent para usar o repaint
public abstract class ElementoComponent extends JComponent{
  public ElementoComponent(){}

  // Método abstrato para desenhar o elemento
  public abstract void desenhar(Graphics g, int x, int y, int cellSize);
  
}