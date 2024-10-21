package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Maracuja;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe MaracujaComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Maracuja na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author redbdb - gustavo assunção
 */

public class MaracujaComponent extends ElementoComponent{

    /**
     * Maracuja - Referência ao objeto do tipo laranja.
     * imagemMaracuja - Imagem que representa o objeto laranja.
     */

    private Maracuja maracuja;
    private Image imagemMaracuja;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Maracuja associado a este componente.
     */

    public MaracujaComponent(Maracuja m){
        this.maracuja = m;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/maracuja.png"));;
        imagemMaracuja = referencia.getImage();
    }

    /**
     * Desenha o objeto Maracuja na interface gráfica.
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
        g.drawImage(imagemMaracuja, x + offsetX, y +offsetY, 16, 16, null);
    }

    public Maracuja getMaracuja(){
        return maracuja;
    }

    public void setMaracuja(Maracuja m){
        this.maracuja = m;
    }

    public Image getImageMaracuja(){
        return imagemMaracuja;
    }

    public void setImagemMaracuja(Image imgM){
        this.imagemMaracuja = imgM;
    }
    
}
