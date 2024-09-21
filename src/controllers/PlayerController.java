package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.elementos.dinamicos.Player;
import view.ambiente.FlorestaComponent;

public class PlayerController implements KeyListener {
    private Player player;
    private FlorestaComponent florestaComponent;

    private static int PLUS_ONE_MV = 1;
    private static int LESS_ONE_MV = -1;
    private boolean initialPositionCleared = false;

    public PlayerController(Player player, FlorestaComponent florestaComponent) {
        this.player = player;
        this.florestaComponent = florestaComponent;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla Pressionada: " + e.getKeyCode()); // Para verificar
        int novoX = player.getX();
        int novoY = player.getY();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                novoY += LESS_ONE_MV;
                break;
            case KeyEvent.VK_DOWN:
                novoY += PLUS_ONE_MV;
                break;
            case KeyEvent.VK_LEFT:
                novoX += LESS_ONE_MV;
                break;
            case KeyEvent.VK_RIGHT:
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
