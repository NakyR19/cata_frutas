package models.elementos.dinamicos;

import models.elementos.Elemento;

public abstract class ElemDinamico extends Elemento{

  public ElemDinamico(int x, int y){
    super(x, y);
  }
  public abstract void mover(int x, int y);

}
