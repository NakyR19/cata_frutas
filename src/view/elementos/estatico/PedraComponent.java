package view.elementos.estatico;
import view.elementos.ElementoComponent;
import models.elementos.estaticos.Pedra;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * PedraComponent representa o componente gráfico da Pedra no jogo.
 * Herda de ElementoComponent e é responsável por desenhar a Pedra.
 * @author NakyR19 - Rafael
 */
public class PedraComponent extends ElementoComponent {
     /**
         * Pedra - O objeto Pedra que representa a Pedra no jogo.
         * imagemPedra - A imagem da Pedra.
         */
    private Pedra pedra;
    private Image imagemPedra;
    
    /**
     * Construtor da classe PedraComponent.
     *
     * @param p O objeto Pedra que representa a Pedra no jogo.
     */
    public PedraComponent(Pedra p) {
        this.pedra = p;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/pedraGrande.png"));
        imagemPedra = referencia.getImage();
    }
    
    /**
     * Desenha a imagem da Pedra na posição (x, y) com o tamanho de resolução da célula.
     *
     * @param g O objeto Graphics usado para desenhar os componentes.
     * @param x A coordenada x onde a imagem será desenhada.
     * @param y A coordenada y onde a imagem será desenhada.
     * @param cellSize O tamanho da célula em pixels.
     */
    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        // Desenha a imagem da pedra na posição (x, y) com o tamanho de resolução da célula 64 x 64
        g.drawImage(imagemPedra, x, y, cellSize, cellSize, null);
    }
    
    public Pedra getPedra() {
        return pedra;
    }
    
    public void setPedra(Pedra pedra) {
        this.pedra = pedra;
    }
    public Image getImagePedra() {
        return imagemPedra;
    }
    
    public void setImagemPedra(Image imagemPedra) {
        this.imagemPedra = imagemPedra;
    }

}
