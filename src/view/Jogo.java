package view;

import models.ambiente.Floresta;
import models.elementos.dinamicos.Player;

import javax.swing.JFrame;

import controllers.PlayerController;
import view.ambiente.FlorestaComponent;
import view.elementos.dinamico.PlayerComponent;

public class Jogo extends JFrame {
    private static final int CELL_SIZE = 64; // Definindo o tamanho da célula
    private static final int WIDTH_OVER = 14; // Definindo o tamanho da célula
    private static final int HEIGHT_OVER = 37; // Definindo o tamanho da célula

    public Jogo() {
        // Fixando a dimensão da floresta como 6, tornar dinamico posteriormente
        Floresta floresta = new Floresta(6);
        Player player = floresta.getPlayer();
        PlayerComponent playerComponent = new PlayerComponent(player);
        FlorestaComponent florestaComponent = new FlorestaComponent(floresta, playerComponent);


        add(florestaComponent);
        setTitle("Floresta");
        // Para o calculo do tamanho do size irá ser 64x(dimensao)+14 para o width, e
        // 64xdimensao+37 para height
        setSize(floresta.getDimensao() * CELL_SIZE + WIDTH_OVER, floresta.getDimensao() * CELL_SIZE + HEIGHT_OVER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        PlayerController playerController = new PlayerController(player, florestaComponent);
        addKeyListener(playerController);
        setFocusable(true);
        requestFocusInWindow();
    }
}
