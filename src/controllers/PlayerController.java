package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.elementos.Elemento;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Player;
import view.Jogo;
import view.ambiente.FlorestaComponent;

/**
 * PlayerController é responsável por controlar o jogador "escutando" os eventos
 * do teclado.
 * Implementa a interface KeyListener para capturar os eventos.
 * 
 * @author NakyR19 - Rafael
 */
public class PlayerController implements KeyListener {

    private Player player;
    private FlorestaComponent florestaComponent;
    private Jogo jogo;
    private static int PLUS_ONE_MV = 1;
    private static int LESS_ONE_MV = -1;
    private boolean initialPositionCleared = false;

    // Conjunto de teclas de controle
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;

    /**
     * Construtor
     * 
     * @param player            o jogador a ser controlado
     * @param florestaComponent o componente da floresta onde o jogador se move
     * @param upKey             a tecla para mover para cima
     * @param downKey           a tecla para mover para baixo
     * @param leftKey           a tecla para mover para a esquerda
     * @param rightKey          a tecla para mover para a direita
     * @param jogo              a instância do jogo para alternar turnos
     */
    public PlayerController(Player player, FlorestaComponent florestaComponent, int upKey, int downKey, int leftKey,
            int rightKey, Jogo jogo) {
        this.player = player;
        this.florestaComponent = florestaComponent;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.jogo = jogo;
    }

    @Override
public void keyPressed(KeyEvent e) {
    
    // Verifica se o jogador atual é o jogador do turno
    System.out.println("Turno atual: " + jogo.getTurnoController().getTurnoAtual().getId());
    System.out.println("Jogador atual: " + player.getId() + " com " + player.getPontosMovimento() + " pontos de movimento");

    if (jogo.getTurnoController().getTurnoAtual() != player) {
        System.out.println("Não é o turno do jogador " + player.getId());
        return; // Se não for o turno do jogador, não faz nada
    }

    if(player.getPoison()){
        System.out.println(player.getId() + " perdeu o turno pois estava envenenado.");
        player.setPoison(false);
        jogo.getTurnoController().alternarTurno();
        return; //Se o player estiver envenenado perde o turno e o status de envenenado
    }

    if (player.getPontosMovimento() <= 0) {
        return; // Se não houver pontos de movimento, não faz nada
    }

    int novoX = player.getX();
    int novoY = player.getY();
    int keyCode = e.getKeyCode();

    boolean isMovementKey = false;

    if (keyCode == upKey) {
        novoY += LESS_ONE_MV;
        isMovementKey = true;
    } else if (keyCode == downKey) {
        novoY += PLUS_ONE_MV;
        isMovementKey = true;
    } else if (keyCode == leftKey) {
        novoX += LESS_ONE_MV;
        isMovementKey = true;
    } else if (keyCode == rightKey) {
        novoX += PLUS_ONE_MV;
        isMovementKey = true;
    } else if (keyCode == KeyEvent.VK_E){
        Elemento elemento = florestaComponent.getFloresta().getElementos()[player.getX()][player.getY()];
            if (elemento instanceof Laranja) {
                Laranja laranja = (Laranja) elemento;
                if (player.pegarFruta(laranja)) {
                    florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
                    System.out.println("Laranja coletada!");
                    florestaComponent.repaint();
                }
            }
    }

    // Se a tecla pressionada não for uma tecla de movimento, não faz nada
    if (!isMovementKey) {
        return;
    }
    // Limpa a posição inicial apenas uma vez
    if (!initialPositionCleared) {
        florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
        initialPositionCleared = true;
    }

    // Atualiza a posição do player no objeto Player
    if (!florestaComponent.getFloresta().isCollision(novoX, novoY)) {
        player.mover(novoX, novoY);
        player.setPontosMovimento(player.getPontosMovimento() - 1); // Decresce os pontos de movimento
        System.out.println("Jogador " + player.getId() + " moveu para (" + novoX + ", " + novoY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
        jogo.atualizarTurnoLabel();
    }

    // Alterna o turno se os pontos de movimento se esgotarem
    if (player.getPontosMovimento() <= 0) {
        jogo.getTurnoController().alternarTurno();
    }

    florestaComponent.repaint(); // Atualiza o desenho
}

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}