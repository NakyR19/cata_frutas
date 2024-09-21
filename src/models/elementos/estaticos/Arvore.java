package models.elementos.estaticos;
import java.awt.Color;
import java.awt.Graphics;

public class Arvore extends ElemEstatico {

    public String TipoArvore;

    public Arvore(int x, int y) {
        super(x, y);
    }

    @Override
    public void interagir(){
        //player nao vai poder atravessar, da fruta na prox rodada aos adjacentes, limitador de turno
    }
}
