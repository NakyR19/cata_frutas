package view.elementos.dinamico;
import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Player;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * PlayerComponent é um componente visual que lida com a imagem do jogador e seu desenho na tela.
 * Ela herda de ElementoComponent.
 * @author NakyR19 - Rafael
 */
public class PlayerComponent extends ElementoComponent {
    /**
     * Atributos: Player
     */
    private Player player;
    private Image imagemPlayer;
    
    /**
     * Construtor
     *
     * @param p o jogador a ser associado a este componente
     * OBS.: FUTURAMENTE ADICIONAR PARAMETRO PARA RECEBER IMAGEM CONFORME MOVIMENTAÇÃO DO PLAYER
     * Atribuição da referência de imagem a imagemPlayer
     */
    public PlayerComponent(Player p) {
        this.player = p;
        ImageIcon referencia = new ImageIcon("res\\images\\playerFrente.png");
        imagemPlayer = referencia.getImage();
    }
    
    /**
     * Desenha a imagem do jogador na posição especificada com o tamanho de célula especificado.
     *
     * @param g o objeto Graphics a ser usado para desenhar
     * @param x a coordenada x em que irá ser desenhada a imagem
     * @param y a coordenada y a qual irá ser desenhada a imagem
     * @param cellSize o tamanho da célula a qual a imagem será desenhada
     */
    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        g.drawImage(imagemPlayer, x, y, cellSize, cellSize, null);
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
