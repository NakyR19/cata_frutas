package controllers;

import models.ambiente.Dado;
import models.ambiente.Floresta;
import models.elementos.Elemento;
import models.elementos.dinamicos.Maracuja;
import models.elementos.dinamicos.Player;
import view.Jogo;
import view.MenuVitoria;
import models.elementos.estaticos.Arvore;
import models.elementos.estaticos.Grama;
/**
 * Classe que gerencia o turno dos jogadores.
 * Troca os turnos e performar certas ações no fim de cada turno.
 * 
 * @author NakyR19 - Rafael
 */
public class TurnoController {
    private Player p1;
    private Player p2;
    private Player turnoAtual;
    private Jogo jogo;
    private Dado dado;
    private Floresta floresta;
    private Elemento[][] elementos;
    private int limiteMaracujas;

    /**
     * Construtor da classe TurnoController
     * 
     * @param p1                    Jogador 1
     * @param p2                    Jogador 2
     * @param jogadorInicial        Jogador que começa o jogo
     * @param jogo                  O jogo que está sendo jogado
     * @param floresta              O tabuleiro que está sendo utilizado
     * 
     * @author NakyR19 - Rafael
     */
    public TurnoController(Player p1, Player p2, Player jogadorInicial, Jogo jogo, Floresta floresta) {
        this.p1 = p1;
        this.p2 = p2;
        this.jogo = jogo;
        this.floresta = floresta;
        this.elementos = floresta.getElementos();
        this.limiteMaracujas = floresta.getNumMaracujasTotais() - floresta.getNumMaracujas();
        this.dado = new Dado();
        this.turnoAtual = jogadorInicial;

        if (p1.getNome().equals("Malandro") || p2.getNome().equals("Malandro")) {
            p1.malandro(1);
        }
        this.turnoAtual.setPontosMovimento(dado.rolarDoisDados());
    }

    public Player getTurnoAtual() {
        return turnoAtual;
    }

    public int getLimiteMaracujas() {
        return limiteMaracujas;
    }

    public void setLimiteMaracujas(int n) {
        limiteMaracujas = n;
    }

    /**
     * Verifica se algum dos jogadores tem maracujas o bastante para vencer
     * 
     * @return          Retorna o player que venceu caso tenha vencido, caso contrário retorna null.
     * 
     * @author          Gustavo Assunção
     */
    public Player VerificarVitoria() {// verifica se algum dos players tem pontos necessarios para vencer.
        int pontos = (floresta.getNumMaracujasTotais() / 2) + 1;
        if (p1.getPontosVitoria() >= pontos)
            return p1;
        if (p2.getPontosVitoria() >= pontos)
            return p2;
        return null;
    }

    /**
     * Altera o turno do jogador.
     * enquanto altera arvoré da frutas para players que estiverem embaixo, diminui a recarga das árvores e dropa maracujás.
     * 
     * @author NakyR19 - Rafael
     */
    public void alternarTurno() {
        if (turnoAtual == p1) {
            turnoAtual = p2;
        } else {
            turnoAtual = p1;
        }

        distribuirPontosMovimento();

        if (turnoAtual.getNome().equals("Fadinha")) {
            if((int)(Math.random() * 100 + 1) > 50){
                turnoAtual.setPontosMovimento(dado.rolarDoisDados() + 5);
                System.out.println("ganhou pontos de movimento");
            } else {
                turnoAtual.setMultiplicadorForca(turnoAtual.getMultiplicadorForca() + 5);
                System.out.println("ganhou força");
            }
        }
        if(this.turnoAtual.getNome() == "Maria Chiquinha"){
            this.turnoAtual.mariaChiquinha();
        }
        System.out.println("Turno alternado para: " + turnoAtual.getId());

        if (turnoAtual.getPoison()) {// verifica se o player no turno estava envenenado, se estiver ele perde o
                                     // status envenenado e o turno.
            System.out.println(turnoAtual.getId() + " perdeu o turno pois estava envenenado.");
            turnoAtual.setPoison(false);
            alternarTurno();
        }

        jogo.atualizarControlador(turnoAtual);
        jogo.atualizarTurnoLabel(); // Atualiza o JLabel
        int arvoreDropMaracuja = (int) (Math.random() * floresta.getNumArvores() + 1);// variavel usada para ajudar a
                                                                                      // escolher uma arvore aleatoria

        for (int i = 0; i < floresta.getDimensao(); i++) {// percorre a floresta, diminui a recarga das arvores e
                                                          // interage se tiver um player em baixo sem recarga
            for (int j = 0; j < floresta.getDimensao(); j++) {

                if (elementos[i][j] instanceof Arvore) {
                    Arvore arvore = (Arvore) elementos[i][j];
                    arvoreDropMaracuja--;

                    if (p1.getX() == i && p1.getY() == j) {
                        arvore.setControl(this);
                        arvore.interagir(p1);
                    }
                    if (p2.getX() == i && p2.getY() == j) {
                        arvore.setControl(this);
                        arvore.interagir(p2);
                    }
                    if (this.getLimiteMaracujas() > 0 && arvoreDropMaracuja == 0) {// se for a arvore que foi escolhido
                                                                                   // e o limite de maracujas nao foi
                                                                                   // atingido dropa um maracuja
                                                                                   // adjacente
                        int limTentativas = 20; // contador para caso sorteie uma arvore sem espaços livres adjacentes
                        while (limTentativas > 0) {
                            int x = (int) (Math.random() * 3) - 1 + i;
                            int y = (int) (Math.random() * 3) - 1 + j;
                            if (x < floresta.getDimensao() && y < floresta.getDimensao() && x > -1 && y > -1) {
                                if (elementos[x][y] instanceof Grama) {
                                    elementos[x][y] = new Maracuja(x, y, floresta.getChanceBichadas());
                                    setLimiteMaracujas(getLimiteMaracujas() - 1);
                                    break;
                                }
                            }
                            limTentativas--;
                        }
                        if (limTentativas == 0)
                            arvoreDropMaracuja++;// se não conseguiu alocar maracuja passa pra proxima arvore
                    }
                    arvore.cooldownReduction();
                }
            }
        }

        if (VerificarVitoria() != null) {
            System.out.println(VerificarVitoria().getId() + " ganhou");
            jogo.dispose();
            new MenuVitoria(VerificarVitoria());
        }

    }

    /**
     * distribui pontos caso um dos jogadores seja um Malandro.
     * 
     * @author NakyR19 - Rafael
     */
    private void distribuirPontosMovimento() {
        if (p1.getNome().equals("Malandro")) {
            if (this.turnoAtual.getNome().equals("Malandro")) {
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + 3);

            } else if (this.turnoAtual.getNome().equals("Edgreen Cullen")) {
                int sumMax = 0;
                if (this.turnoAtual.edgreenCullenCountFrutas() > 7) {
                    sumMax = 7;
                } else {
                    sumMax = this.turnoAtual.edgreenCullenCountFrutas();
                }
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + sumMax - 3);
                if (this.turnoAtual.getPontosMovimento() < 1) {
                    p1.malandro(0);
                    alternarTurno();
                } else {
                    this.turnoAtual.edgreenCullenMensagem(this.turnoAtual.edgreenCullenCountFrutas());
                }

            } else {
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() - 3);
                if (this.turnoAtual.getPontosMovimento() < 1) {
                    p1.malandro(0);
                    alternarTurno();
                }
            } // fimmmmmm
        } else if (p2.getNome().equals("Malandro")) {
            if (this.turnoAtual.getNome().equals("Malandro")) {
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + 3);

            } else if (this.turnoAtual.getNome().equals("Edgreen Cullen")) {
                int sumMax = 0;
                if (this.turnoAtual.edgreenCullenCountFrutas() > 7) {
                    sumMax = 7;
                } else {
                    sumMax = this.turnoAtual.edgreenCullenCountFrutas();
                }
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + sumMax - 3);
                if (this.turnoAtual.getPontosMovimento() < 1) {
                    p1.malandro(0);
                    alternarTurno();
                } else {
                    this.turnoAtual.edgreenCullenMensagem(this.turnoAtual.edgreenCullenCountFrutas());
                }

            } else {
                this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() - 3);
                if (this.turnoAtual.getPontosMovimento() < 1) {
                    p1.malandro(0);
                    alternarTurno();
                }
            } // fimmmmmm
        } else if (this.turnoAtual.getNome().equals("Edgreen Cullen")) {
            int sumMax = 0;
            if (this.turnoAtual.edgreenCullenCountFrutas() > 7) {
                sumMax = 7;
            } else {
                sumMax = this.turnoAtual.edgreenCullenCountFrutas();
            }
            this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + sumMax);
            this.turnoAtual.edgreenCullenMensagem(this.turnoAtual.edgreenCullenCountFrutas());

        } else {
            this.turnoAtual.setPontosMovimento(dado.rolarDoisDados() + 3);
        } if (turnoAtual.getNome().equals("Enzo Gabriel")) {
            if(turnoAtual.getPontosMovimento() <= 3){
                turnoAtual.setPontosMovimento(1);
            } else{
                turnoAtual.setPontosMovimento(dado.rolarDoisDados() - 3);
            }
        }
    }
}