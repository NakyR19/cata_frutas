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

    /**
     * Construtor
     * @param x coordenada x
     * @param y coordenada y
     */
    public Arvore(int x, int y) {
        super(x, y);
    }

    // em breve
    @Override
    public void interagir(){
        //player nao vai poder atravessar, da fruta na prox rodada aos adjacentes, limitador de turno
        
        //conceito de turno ainda nao existe, mochila ainda nao existe;
        //if(player adjacente && contp1 == 0){
        // p = fruta
        // contp1 = 5}
        //if(passou turno){contp1-- }
    }

    public void setTipoArvore(String tipo){
        this.TipoArvore = tipo;
    }

    public String getTipoArvore(){
        return this.TipoArvore;
    }
}
