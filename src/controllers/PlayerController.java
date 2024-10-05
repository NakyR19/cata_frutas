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

    /**
     * ############ ATRIBUTOS ############
     * Player - Espera receber o jogador que será movimentado
     * florestaComponent - O componente da floresta onde o jogador se move.
     * PLUS_ONE_MV - Constante p/ acréscimo de posição na matriz
     * LESS_ONE_MV - Constante p/ decrescimo de posição na matriz
     * initialPositionCleared - Indica se a posição inicial foi limpa.
     */

    private Player player;
    private FlorestaComponent florestaComponent;
    private static int PLUS_ONE_MV = 1;
    private static int LESS_ONE_MV = -1;
    private boolean initialPositionCleared = false;

    /**
     * ############ CONSTRUTOR ############
     * 
     * @param player            o jogador a ser controlado
     * @param florestaComponent o componente da floresta onde o jogador se move
     */
    public PlayerController(Player player, FlorestaComponent florestaComponent) {
        this.player = player;
        this.florestaComponent = florestaComponent;
    }

    /**
     * Método chamado quando uma tecla é pressionada.
     * Atualiza a posição do jogador com base na tecla pressionada.
     * 
     * @param e o evento de tecla
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int novoX = player.getX();
        int novoY = player.getY();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                novoY += LESS_ONE_MV;
                break;
            case KeyEvent.VK_W:
                novoY += LESS_ONE_MV;
                break;
            case KeyEvent.VK_DOWN:
                novoY += PLUS_ONE_MV;
                break;
            case KeyEvent.VK_S:
                novoY += PLUS_ONE_MV;
                break;
            case KeyEvent.VK_LEFT:
                novoX += LESS_ONE_MV;
                break;
            case KeyEvent.VK_A:
                novoX += LESS_ONE_MV;
                break;
            case KeyEvent.VK_RIGHT:
                novoX += PLUS_ONE_MV;
                break;
            case KeyEvent.VK_D:
                novoX += PLUS_ONE_MV;
                break;
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
