package controllers;

import models.ambiente.Dado;
import models.ambiente.Floresta;
import models.elementos.Elemento;
import models.elementos.dinamicos.Maracuja;
import models.elementos.dinamicos.Player;
import view.Jogo;
import models.elementos.estaticos.Arvore;
import models.elementos.estaticos.Grama;

public class TurnoController {
    private Player p1;
    private Player p2;
    private Player turnoAtual;
    private Jogo jogo;
    private Dado dado;
    private Floresta floresta;
    private Elemento[][] elementos;
    private int limiteMaracujas;

    public TurnoController(Player p1, Player p2, Player jogadorInicial, Jogo jogo, Floresta floresta) {
        this.p1 = p1;
        this.p2 = p2;
        this.jogo = jogo;
        this.floresta = floresta;
        this.elementos = floresta.getElementos();
        this.limiteMaracujas = floresta.getNumMaracujasTotais() - floresta.getNumMaracujas();
        this.dado = new Dado();
        this.turnoAtual = jogadorInicial;
        this.turnoAtual.setPontosMovimento(dado.rolarDoisDados()); // Inicializa com 3 pontos de movimento
    }

    public Player getTurnoAtual() {
        return turnoAtual;
    }

    public int getLimiteMaracujas(){
        return limiteMaracujas;
    }

    public void setLimiteMaracujas(int n){
        limiteMaracujas = n;
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

        if(turnoAtual.getPoison()){//verifica se o player no turno estava envenenado, se estiver ele perde o status envenenado e o turno.
            System.out.println(turnoAtual.getId() + " perdeu o turno pois estava envenenado.");
            turnoAtual.setPoison(false);
            alternarTurno();
        }

        jogo.atualizarControlador(turnoAtual);
        jogo.atualizarTurnoLabel(); // Atualiza o JLabel
        int arvoreDropMaracuja = (int)(Math.random() * floresta.getNumArvores() + 1);//variavel usada para ajudar a escolher uma arvore aleatoria

        for(int i = 0; i < floresta.getDimensao(); i++){//percorre a floresta, diminui a recarga das arvores e interage se tiver um player em baixo sem recarga
            for(int j = 0; j < floresta.getDimensao(); j++){
                    
                if(elementos[i][j] instanceof Arvore){
                    Arvore arvore = (Arvore) elementos[i][j];
                    arvoreDropMaracuja--;
    
                    if(p1.getX() == i && p1.getY() == j){
                        arvore.setControl(this);
                        arvore.interagir(p1);
                    }
                    if(p2.getX() == i && p2.getY() == j){
                        arvore.setControl(this);
                        arvore.interagir(p2);
                    }
                    if(this.getLimiteMaracujas() > 0 && arvoreDropMaracuja == 0){//se for a arvore que foi escolhido e o limite de maracujas nao foi atingido dropa um maracuja adjacente
                        int limTentativas = 20; //contador para caso sorteie uma arvore sem espaços livres adjacentes
                        while(limTentativas > 0){
                            int x = (int)(Math.random() * 3) - 1 + i;
                            int y = (int)(Math.random() * 3) - 1 + j;
                            if(x < floresta.getDimensao() && y < floresta.getDimensao() && x > -1 &&  y > -1){
                                if(elementos[x][y] instanceof Grama){
                                    elementos[x][y] = new Maracuja(x, y, floresta.getChanceBichadas());
                                setLimiteMaracujas(getLimiteMaracujas() - 1);
                                    break;
                                }
                            }
                            limTentativas--; 
                        } if(limTentativas == 0) arvoreDropMaracuja++;//se não conseguiu alocar maracuja passa pra proxima arvore
                    }
                    arvore.cooldownReduction();
                }
            }
        }

        if(VerificarVitoria() != null){//alterar para futuramente encerrar o jogo.
            System.out.println(VerificarVitoria().getId() + " ganhou");
        }



    }
}