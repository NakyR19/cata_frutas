package controllers;

import models.ambiente.Dado;
import models.elementos.dinamicos.Player;
import view.Jogo;
import models.elementos.estaticos.Arvore;

public class TurnoController {
    private Player p1;
    private Player p2;
    private Player turnoAtual;
    private Jogo jogo;
    private Dado dado;

    public TurnoController(Player p1, Player p2, Player jogadorInicial, Jogo jogo) {
        this.p1 = p1;
        this.p2 = p2;
        this.jogo = jogo;
        this.dado = new Dado();
        this.turnoAtual = jogadorInicial;
        this.turnoAtual.setPontosMovimento(dado.rolarDoisDados()); // Inicializa com 3 pontos de movimento
    }

    public Player getTurnoAtual() {
        return turnoAtual;
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
        //interagir arvore se o player estiver no lugar 
        //percorre o tabuleiro e diminui a limitação de turno da arvore em 1
    }
}