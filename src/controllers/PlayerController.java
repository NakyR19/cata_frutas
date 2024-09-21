package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.elementos.dinamicos.Player;
import view.elementos.dinamico.PlayerComponent;

public class PlayerController implements KeyListener {
    private Player player;
    private PlayerComponent playerComponent;
    private static int ONE_MV = 1;
    private static int LESS_ONE_MV = -1;
    private static int ZERO_MV = 0;


    public PlayerController(Player player, PlayerComponent playerComponent) {
        this.player = player;
        this.playerComponent = playerComponent;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla Pressionada: " + e.getKeyCode()); // Para verificar
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.mover(ZERO_MV, LESS_ONE_MV);
                break;
            case KeyEvent.VK_DOWN:
                player.mover(ZERO_MV, ONE_MV);
                break;
            case KeyEvent.VK_LEFT:
                player.mover(LESS_ONE_MV, ZERO_MV);
                break;
            case KeyEvent.VK_RIGHT:
                player.mover(ONE_MV, ZERO_MV);
                break;
        }

        
        playerComponent.repaint(); // Atualiza o desenho
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
