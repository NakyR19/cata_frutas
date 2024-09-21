package view.elementos.estatico;
import view.elementos.ElementoComponent;
import models.elementos.estaticos.Pedra;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PedraComponent extends ElementoComponent {
    private Pedra pedra;
    private Image imagemGrama;
    
    
    public PedraComponent(Pedra p) {
        this.pedra = p;
        ImageIcon referencia = new ImageIcon("res\\images\\coqueiro.png");
        imagemGrama = referencia.getImage();
    }
    
    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        // Desenha a imagem da pedra na posição (x, y) com o tamanho de resolução da célula 64 x 64
        g.drawImage(imagemGrama, x, y, cellSize, cellSize, null);
    }
    
    public Pedra getPedra() {
        return pedra;
    }
    
    public void setPedra(Pedra pedra) {
        this.pedra = pedra;
    }
    public Image getImagemGrama() {
        return imagemGrama;
    }
    
    public void setImagemGrama(Image imagemGrama) {
        this.imagemGrama = imagemGrama;
    }
    
}
