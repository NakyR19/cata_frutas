package models.elementos.estaticos;

import controllers.TurnoController;
import models.elementos.dinamicos.Abacate;
import models.elementos.dinamicos.Acerola;
import models.elementos.dinamicos.Amora;
import models.elementos.dinamicos.Coco;
import models.elementos.dinamicos.Goiaba;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Player;

/**
 * Arvore representa uma arvore que ao interagir com ela derrubará frutas.
 * Esta classe herda da classe ElemEstatico.
 * 
 * @author NakyR19 - Rafael
 */
public class Arvore extends ElemEstatico {

    /**
     * Especifica o tipo de Arvore
     */
    public String TipoArvore;
    public int LimitadorTurno = 0;
    public TurnoController turnoController;
    public int chanceBichada;

    /**
     * Construtor
     * @param x coordenada x
     * @param y coordenada y
     * @param chanceBichada a chance das frutas que a arvore da estarem bichadas
     * 
     * @author NakyR19 - Rafael
     */
    public Arvore(int x, int y, String tipo, int chanceBichada) {
        super(x, y);
        this.TipoArvore = tipo;

        this.chanceBichada = chanceBichada;
    }

    /**
     * função de interagir da árvore.
     * Da uma fruta do tipo de árvore e entra em recarga
     * 
     * @param player o jogador que interage
     * 
     * @author Gustavo Assunção
     */
    @Override
    public void interagir(Player player){

        //se ainda nao tiverem passado 5 turnos des de a ultima vez que deu fruta, nao faz nada
        if(LimitadorTurno != 0)
            return;
        
        //da uma fruta a depender do tipo de árvore e reinicia a contagem de turnos
        switch (TipoArvore) {
            case "laranjeira":
            Laranja laranja = new Laranja(x, y, chanceBichada);
            if(!player.pegarFruta(laranja))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta laranja.");
                break;

            case "coqueiro":
            Coco coco = new Coco(x, y, chanceBichada);
            if(!player.pegarFruta(coco))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta coco.");
                break;
    
            case "goiabeira":
            Goiaba goiaba = new Goiaba(x, y, chanceBichada);
            if(!player.pegarFruta(goiaba))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta goiaba.");
                break;

            case "amoreira":
            Amora amora = new Amora(x, y, chanceBichada);
            if(!player.pegarFruta(amora))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta amora.");
                break;

            case "abacateiro":
            Abacate abacate = new Abacate(x, y, chanceBichada);
            if(!player.pegarFruta(abacate))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta abacate.");
                break;

            case "aceroleira":
            Acerola acerola = new Acerola(x, y, chanceBichada);
            if(!player.pegarFruta(acerola))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta acerola.");
                break;

            default:
                System.out.println("tipoArvore nao alocado");
                break;
        }
    }

    /**
     * diminui a recarga da arvore em 1
     * 
     * @author Gustavo Assunção
     */
    public void cooldownReduction(){
        if(this.LimitadorTurno > 0)
            LimitadorTurno--;
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

    public void setControl(TurnoController control){
        this.turnoController = control;
    }

    public TurnoController getControl(){
        return turnoController;
    }
}
