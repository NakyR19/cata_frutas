package models.elementos.estaticos;
import models.elementos.Elemento;

public abstract class ElemEstatico extends Elemento{
    public ElemEstatico(int x, int y){
      super(x, y);
    }
  public abstract void interagir();
}
