package controllers;

import models.elementos.dinamicos.Player;
import view.Jogo;

public class TurnoController {
    private Player p1;
    private Player p2;
    private Player turnoAtual;
    private Jogo jogo;

    public TurnoController(Player p1, Player p2, Jogo jogo) {
        this.p1 = p1;
        this.p2 = p2;
        this.jogo = jogo;
        this.turnoAtual = p1;
        this.turnoAtual.setPontosMovimento(3); // Inicializa com 3 pontos de movimento
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
        turnoAtual.setPontosMovimento(3); // Reseta os pontos de movimento para 3 no início do turno
        System.out.println("Turno alternado para: " + turnoAtual.getId());
        jogo.atualizarControlador(turnoAtual);
    }
}