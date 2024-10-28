package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Acerola;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe AcerolaComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Acerola na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author NakyR19 - Rafael
 */

public class AcerolaComponent extends ElementoComponent{
    
    /**
     * Acerola - Referência ao objeto do tipo Acerola.
     * imagemAcerola - Imagem que representa o objeto Acerola.
     */

    private Acerola acerola;
    private Image imagemAcerola;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Acerola associado a este componente.
     * 
     * @author NakyR19 - Rafael
     */

    public AcerolaComponent(Acerola l){
        this.acerola = l;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/acerola.png"));;
        imagemAcerola = referencia.getImage();
    }

    /**
     * Desenha o objeto Acerola na interface gráfica.
     * 
     * @param g       O objeto Graphics usado para desenhar   
     * @param x       A coordenada x onde será desenhado 
     * @param y       A coordenada y onde será desenhada 
     * @param cellSize O tamanho da célula onde o objeto será desenhado
     * 
     * @author NakyR19 - Rafael
     */

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize){
        int frutaSize = 16;
        int offsetX = (cellSize - frutaSize) / 2;
    int offsetY = cellSize - frutaSize;
        g.drawImage(imagemAcerola, x + offsetX, y +offsetY, 16, 16, null);
    }

    public Acerola getAcerola(){
        return acerola;
    }

    public void setAcerola(Acerola a){
        this.acerola = a;
    }

    public Image getImageAcerola(){
        return imagemAcerola;
    }

    public void setImagemAcerola(Image imgL){
        this.imagemAcerola = imgL;
    }

}
