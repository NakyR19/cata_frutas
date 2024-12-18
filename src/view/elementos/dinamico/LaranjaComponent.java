package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Laranja;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe LaranjaComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo laranja na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author gustavo assunção
 */

public class LaranjaComponent extends ElementoComponent{
    
    /**
     * laranja - Referência ao objeto do tipo laranja.
     * imagemLaranja - Imagem que representa o objeto laranja.
     */

    private Laranja laranja;
    private Image imagemLaranja;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Laranja associado a este componente.
     * 
     * @author gustavo assunção
     */

    public LaranjaComponent(Laranja l){
        this.laranja = l;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/laranja.png"));;
        imagemLaranja = referencia.getImage();
    }

    /**
     * Desenha o objeto Laranja na interface gráfica.
     * 
     * @param g       O objeto Graphics usado para desenhar   
     * @param x       A coordenada x onde será desenhado 
     * @param y       A coordenada y onde será desenhada 
     * @param cellSize O tamanho da célula onde o objeto será desenhado
     * 
     * @author gustavo assunção
     */

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize){
        int frutaSize = 16;
        int offsetX = (cellSize - frutaSize) / 2;
    int offsetY = cellSize - frutaSize;
        g.drawImage(imagemLaranja, x + offsetX, y +offsetY, 16, 16, null);
    }

    public Laranja getLaranja(){
        return laranja;
    }

    public void setLaranja(Laranja l){
        this.laranja = l;
    }

    public Image getImageLaranja(){
        return imagemLaranja;
    }

    public void setImagemLaranja(Image imgL){
        this.imagemLaranja = imgL;
    }

}
