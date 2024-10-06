package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.elementos.dinamicos.Player;
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
     */
    public PlayerController(Player player, FlorestaComponent florestaComponent, int upKey, int downKey, int leftKey, int rightKey) {
        this.player = player;
        this.florestaComponent = florestaComponent;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    @Override
public void keyPressed(KeyEvent e) {
    int novoX = player.getX();
    int novoY = player.getY();
    int keyCode = e.getKeyCode();

    if (keyCode == upKey) {
        novoY += LESS_ONE_MV;
    } else if (keyCode == downKey) {
        novoY += PLUS_ONE_MV;
    } else if (keyCode == leftKey) {
        novoX += LESS_ONE_MV;
    } else if (keyCode == rightKey) {
        novoX += PLUS_ONE_MV;
    }

    // Limpa a posição inicial apenas uma vez
    if (!initialPositionCleared) {
        florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
        initialPositionCleared = true;
    }
    // Atualiza a posição do player no objeto Player
    if (!florestaComponent.getFloresta().isCollision(novoX, novoY)) {
        player.mover(novoX, novoY);
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