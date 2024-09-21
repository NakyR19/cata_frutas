package view.ambiente;

import models.ambiente.Floresta;
import models.elementos.Elemento;
import view.elementos.ElementoComponent;
import view.elementos.ElementoComponentFactory;
import view.elementos.dinamico.PlayerComponent;

import javax.swing.*;
import java.awt.*;

public class FlorestaComponent extends JPanel {
    private Floresta floresta;
    private PlayerComponent playerComponent;
    private Image background;
    private static final int CELL_SIZE = 64; // Definindo o tamanho da célula

    public FlorestaComponent(Floresta floresta, PlayerComponent playerComponent) {
        this.floresta = floresta;
        this.playerComponent = playerComponent;
        ImageIcon referencia = new ImageIcon("res/images/background.png"); // ALTERAR PATH
        background = referencia.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(background, 0, 0, getWidth(), getHeight(), null);

        Elemento[][] elementos = floresta.getElementos();
        int dimensao = floresta.getDimensao();

        // Itera sobre os elementos e desenha-os
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (elementos[i][j] != null) {
                    ElementoComponent componente = ElementoComponentFactory.criarComponente(elementos[i][j]);
                    if (componente != null) {
                        // Calcula a posição de desenho com base no tamanho da célula
                        componente.desenhar(g, i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        }
        playerComponent.desenhar(g, playerComponent.getPlayer().getX() * CELL_SIZE, playerComponent.getPlayer().getY() * CELL_SIZE, CELL_SIZE);
    }

    public Floresta getFloresta() {
        return floresta;
    }
}
