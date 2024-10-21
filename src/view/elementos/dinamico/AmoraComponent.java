package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Amora;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe AmoraComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Amora na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author
 */

public class AmoraComponent extends ElementoComponent{
    
    /**
     * Amora - Referência ao objeto do tipo Amora.
     * imagemAmora - Imagem que representa o objeto Amora.
     */

    private Amora Amora;
    private Image imagemAmora;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Amora associado a este componente.
     */

    public AmoraComponent(Amora l){
        this.Amora = l;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/amora.png"));;
        imagemAmora = referencia.getImage();
    }

    /**
     * Desenha o objeto Amora na interface gráfica.
     * 
     * @param g       O objeto Graphics usado para desenhar   
     * @param x       A coordenada x onde será desenhado 
     * @param y       A coordenada y onde será desenhada 
     * @param cellSize O tamanho da célula onde o objeto será desenhado
     */

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize){
        int frutaSize = 16;
        int offsetX = (cellSize - frutaSize) / 2;
    int offsetY = cellSize - frutaSize;
        g.drawImage(imagemAmora, x + offsetX, y +offsetY, 16, 16, null);
    }

    public Amora getAmora(){
        return Amora;
    }

    public void setAmora(Amora l){
        this.Amora = l;
    }

    public Image getImageAmora(){
        return imagemAmora;
    }

    public void setImagemAmora(Image imgL){
        this.imagemAmora = imgL;
    }

}
