package view.elementos.dinamico;
import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Player;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayerComponent extends ElementoComponent {
    private Player player;

    
    private Image imagemPlayer;
    
    public PlayerComponent(Player p) {
        this.player = p;
        ImageIcon referencia = new ImageIcon("res\\images\\playerFrente.png");
        imagemPlayer = referencia.getImage();
    }
    
    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        // Desenha a imagem da grama na posição (x, y) com o tamanho de resolução da célula 64 x 64
        g.drawImage(imagemPlayer, x, y, cellSize, cellSize, null);
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
