package controllers;

import models.ambiente.Dado;
import models.ambiente.Floresta;
import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import view.Jogo;
import models.elementos.estaticos.Arvore;

public class TurnoController {
    private Player p1;
    private Player p2;
    private Player turnoAtual;
    private Jogo jogo;
    private Dado dado;
    private Floresta floresta;
    private Elemento[][] elementos;

    public TurnoController(Player p1, Player p2, Player jogadorInicial, Jogo jogo, Floresta floresta) {
        this.p1 = p1;
        this.p2 = p2;
        this.jogo = jogo;
        this.floresta = floresta;
        this.elementos = floresta.getElementos();
        this.dado = new Dado();
        this.turnoAtual = jogadorInicial;
        this.turnoAtual.setPontosMovimento(dado.rolarDoisDados()); // Inicializa com 3 pontos de movimento
    }

    public Player getTurnoAtual() {
        return turnoAtual;
    }

    public Player VerificarVitoria(){//verifica se algum dos players tem pontos necessarios para vencer.
        int pontos = (floresta.getNumMaracujasTotais()/2) + 1;
        if(p1.getPontosVitoria() >= pontos)
            return p1;
        if(p2.getPontosVitoria() >= pontos)
            return p2;
        return null;
    }

    public void alternarTurno() {
        if (turnoAtual == p1) {
            turnoAtual = p2;
        } else {
            turnoAtual = p1;
        }
        turnoAtual.setPontosMovimento(dado.rolarDoisDados()); // Reseta os pontos de movimento para 3 no início do turno
        System.out.println("Turno alternado para: " + turnoAtual.getId());
        jogo.atualizarControlador(turnoAtual);
        jogo.atualizarTurnoLabel(); // Atualiza o JLabel
    
        for(int i = 0; i < floresta.getDimensao(); i++){//percorre a floresta, diminui a recarga das arvores e interage se tiver um player em baixo sem recarga
            for(int j = 0; j < floresta.getDimensao(); j++){
                    
                if(elementos[i][j] instanceof Arvore){
                    Arvore arvore = (Arvore) elementos[i][j];
                    
                    if(p1.getX() == i && p1.getY() == j)
                        arvore.interagir(p1);
                    if(p2.getX() == i && p2.getY() == j)
                        arvore.interagir(p2);
                  
                    arvore.cooldownReduction();
                }
            }
        }

        if(VerificarVitoria() != null){//alterar para futuramente encerrar o jogo.
            System.out.println(VerificarVitoria().getId() + " ganhou");
        }
    }
}