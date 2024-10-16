package models.elementos.estaticos;

import controllers.TurnoController;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Maracuja;
import models.elementos.dinamicos.Player;

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
    public TurnoController turnoController;

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
    public void interagir(Player player){

        //se ainda nao tiverem passado 5 turnos des de a ultima vez que deu fruta, nao faz nada
        if(LimitadorTurno != 0)
            return;

        //25% de chance de dar um maracuja, so vai dar maracuja se nao tiver atingido o maximo de maracujas no jogo
        if((int)(Math.random() * 100 + 1) > 25 && turnoController.getLimiteMaracujas() > 0){
            Maracuja maracuja = new Maracuja(x, y);
            if(!player.pegarFruta(maracuja))//se a mochila estiver cheia nao vai reiniciar a recarga
                return;
            LimitadorTurno = 5;
            player.setPontosVitoria(player.getPontosVitoria() + 1);
            turnoController.setLimiteMaracujas(turnoController.getLimiteMaracujas() - 1);
            System.out.println(player.getId() + " pegou um maracuja da arvore.");
            return;
        }
        
        //da uma fruta a depender do tipo de árvore e reinicia a contagem de turnos
        switch (TipoArvore) {
            case "laranjeira":
            Laranja laranja = new Laranja(x, y);
            if(!player.pegarFruta(laranja))
                return;
            LimitadorTurno = 5;
            System.out.println(player.getId() + " pegou uma fruta laranja.");
                break;
        
            default:
                System.out.println("tipoArvore nao alocado");
                break;
        }
    }

    // diminui em 1 a contagem de turnos
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
