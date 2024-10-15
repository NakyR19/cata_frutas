package models.elementos.estaticos;

/**
 * Arvore representa uma arvore que ao interagir com ela derrubará frutas.
 * Esta classe herda da classe ElemEstatico.
 * @author NakyR19 - Rafael
 */
public class Arvore extends ElemEstatico {

    /**
     * Especifica o tipo de Arvore
     */
    public String TipoArvore;
    public int LimitadorTurno = 0;

    /**
     * Construtor
     * @param x coordenada x
     * @param y coordenada y
     */
    public Arvore(int x, int y, String tipo) {
        super(x, y);
        this.TipoArvore = tipo;
    }

    // em breve
    @Override
    public void interagir(){
        if(this.LimitadorTurno > 0){//mudar
            LimitadorTurno--;
        }
    }

    public void setTipoArvore(String tipo){
        this.TipoArvore = tipo;
    }

    public String getTipoArvore(){
        return this.TipoArvore;
    }

    public void setLimitadorTurno(int n){
        this.LimitadorTurno = n;
    }

    public int getLimitadorTurno(){
        return this.LimitadorTurno;
    }
}
