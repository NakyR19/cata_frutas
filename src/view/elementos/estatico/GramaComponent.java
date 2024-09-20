package view.elementos.estatico;
import view.elementos.ElementoComponent;
import models.elementos.estaticos.Grama;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GramaComponent extends ElementoComponent {
    private Grama grama;
    private Image imagemGrama;

    public GramaComponent(Grama g) {
        this.grama = g;
        ImageIcon referencia = new ImageIcon("res/images/grama.png");
        imagemGrama = referencia.getImage();
    }

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        // Desenha a imagem da grama na posição (x, y) com o tamanho de resolução da célula 64 x 64
        g.drawImage(imagemGrama, x, y, cellSize, cellSize, null);
    }
}

