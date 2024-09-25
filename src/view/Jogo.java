package view;

import controllers.PlayerController;
import models.ambiente.Floresta;
import models.elementos.dinamicos.Player;
import view.ambiente.FlorestaComponent;
import view.elementos.dinamico.PlayerComponent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jogo extends JFrame {
    private static final int CELL_SIZE = 64;
    private static final int WIDTH_OVER = 14;
    private static final int HEIGHT_OVER = 37;

    public Jogo(JFrame menuInicial) {
        // Definindo a dimensão da floresta como 6, tornar dinâmico posteriormente
        Floresta floresta = new Floresta(6);
        Player player = floresta.getPlayer();
        PlayerComponent playerComponent = new PlayerComponent(player);
        FlorestaComponent florestaComponent = new FlorestaComponent(floresta, playerComponent);

        add(florestaComponent);
        setTitle("Floresta");
        setSize(floresta.getDimensao() * CELL_SIZE + WIDTH_OVER, floresta.getDimensao() * CELL_SIZE + HEIGHT_OVER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Para gerenciar o fechamento manualmente
        this.setResizable(false);

        PlayerController playerController = new PlayerController(player, florestaComponent);
        addKeyListener(playerController);
        setFocusable(true);
        requestFocusInWindow();

        // Adiciona o listener para o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar a janela do menu inicial antes de fechar
                menuInicial.setVisible(true);

                // Destruir o objeto Jogo
                dispose(); // Fecha e remove o Jogo da memória
            }
        });
    }
}
