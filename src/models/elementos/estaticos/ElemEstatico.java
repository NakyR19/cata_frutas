package models.elementos.estaticos;
import java.awt.Graphics;
import models.elementos.Elemento;

public abstract class ElemEstatico extends Elemento{
    public ElemEstatico(int x, int y){
      super(x, y);
    }
  public abstract void interagir();
}
