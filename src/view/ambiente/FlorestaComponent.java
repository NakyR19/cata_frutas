package view.ambiente;

import models.ambiente.Floresta;
import models.elementos.Elemento;
import view.elementos.ElementoComponent;
import view.elementos.ElementoComponentFactory;
import view.elementos.dinamico.PlayerComponent;

import javax.swing.*;
import java.awt.*;

/**
 * FlorestaComponent representa o componente gráfico da floresta no jogo.
 * Herda de JPanel e é responsável por desenhar a floresta e seus elementos.
 * @author NakyR19 - Rafael
 */
public class FlorestaComponent extends JPanel {
    /**
     * ############ ATRIBUTOS ############
     * Floresta - o objeto Floresta que representa a floresta no jogo.
     * playerComponent - O componente gráfico do jogador.
     * background - A imagem de fundo da floresta. (NÃO É OCASIONALMENTE VISTA)
     * CELL_SIZE - atributo estático(constante) para O tamanho da célula na grade da floresta.
     * initialPositionCleared - Indica se a posição inicial foi limpa.
     */
    private Floresta floresta;
    private PlayerComponent p1Component;
    private PlayerComponent p2Component;
    private Image background;
    private static final int CELL_SIZE = 64; // Definindo o tamanho da célula

    /**
     * Construtor
     *
     * @param floresta O objeto Floresta que representa a floresta no jogo.
     * @param playerComponent O componente gráfico do jogador.
     */
    public FlorestaComponent(Floresta floresta, PlayerComponent p1Component, PlayerComponent p2Component) {
        this.floresta = floresta;
        this.p1Component = p1Component;
        this.p2Component = p2Component;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/background.png"));; // ALTERAR PATH
        background = referencia.getImage();
    }

    /**
     * Sobrescreve o método paintComponent para desenhar a floresta e seus elementos.
     *
     * @param g O objeto Graphics usado para desenhar os componentes.
     */
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
        p1Component.desenhar(g, p1Component.getPlayer().getX() * CELL_SIZE, p1Component.getPlayer().getY() * CELL_SIZE, CELL_SIZE);
        p2Component.desenhar(g, p2Component.getPlayer().getX() * CELL_SIZE, p2Component.getPlayer().getY() * CELL_SIZE, CELL_SIZE);
    }

    public Floresta getFloresta() {
        return floresta;
    }
}
