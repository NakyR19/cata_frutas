package view.elementos.estatico;

import view.elementos.ElementoComponent;
import models.elementos.estaticos.Grama;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * GramaComponent representa o componente gráfico da grama no jogo.
 * Herda de ElementoComponent e é responsável por desenhar a grama.
 * @author NakyR19 - Rafael
 */
public class GramaComponent extends ElementoComponent {
     /**
         * grama - O objeto Grama que representa a grama no jogo.
         * imagemGrama - A imagem da grama.
         */
    private Grama grama;
    private Image imagemGrama;

    /**
     * Construtor da classe GramaComponent.
     *
     * @param g O objeto Grama que representa a grama no jogo.
     */
    public GramaComponent(Grama g) {
        this.grama = g;
        ImageIcon referencia = new ImageIcon("res\\images\\grama.png");
        imagemGrama = referencia.getImage();
    }

    /**
     * Desenha a imagem da grama na posição (x, y) com o tamanho de resolução da célula.
     *
     * @param g O objeto Graphics usado para desenhar os componentes.
     * @param x A coordenada x onde a imagem será desenhada.
     * @param y A coordenada y onde a imagem será desenhada.
     * @param cellSize O tamanho da célula em pixels.
     */
    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        // Desenha a imagem da grama na posição (x, y) com o tamanho de resolução da
        // célula 64 x 64
        g.drawImage(imagemGrama, x, y, cellSize, cellSize, null);
    }

    public Grama getGrama() {
        return grama;
    }

    public void setGrama(Grama grama) {
        this.grama = grama;
    }
}
