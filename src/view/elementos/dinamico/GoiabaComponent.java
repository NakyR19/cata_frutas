package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Goiaba;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe GoiabaComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Goiaba na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author 
 */

public class GoiabaComponent extends ElementoComponent{

     /**
     * Goiaba - Referência ao objeto do tipo Goiaba.
     * imagemGoiaba - Imagem que representa o objeto Goiaba.
     */

    private Goiaba Goiaba;
    private Image imagemGoiaba;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Goiaba associado a este componente.
     */

    public GoiabaComponent(Goiaba c){
        this.Goiaba = c;
        ImageIcon referencia = new ImageIcon(getClass().getResource("/res/images/goiaba.png"));//colocar a referência depois
        imagemGoiaba = referencia.getImage();
    }

    /**
     * Desenha o objeto Goiaba na interface gráfica.
     * 
     * @param g       O objeto Graphics usado para desenhar   
     * @param x       A coordenada x onde será desenhado 
     * @param y       A coordenada y onde será desenhada 
     * @param cellSize O tamanho da célula onde o objeto será desenhado
     */

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize){
        int frutaSize = 32;
        int offsetX = (cellSize - frutaSize) / 2;
    int offsetY = cellSize - frutaSize;
        g.drawImage(imagemGoiaba, x + offsetX, y +offsetY, 32, 32, null);
    }

    /**
     * Pega o objeto Goiaba associado a este componente.
     * @return O objeto Goiaba.
     */

    public Goiaba getGoiaba(){
        return Goiaba;
    }

    /** 
     * Define o objeto Goiaba associado a este componente.
     * @return A imagem do objeto Goiaba.
     */

    public void setGoiaba(Goiaba Goiaba){
        this.Goiaba = Goiaba;
    }

    /**
     * Pega a imagem do obejto Goiaba associada a este componente.
     * @return A imagem do objeto Goiaba.
     */

    public Image getImageGoiaba(){
        return imagemGoiaba;
    }

    /**
     * Define a imagem do objeto Goiaba associado a este componente.
     * @return  imagemGoiaba A nova imagem do objeto Goiaba.
     */

    public void setImagemGoiaba(Image imagemGoiaba){
        this.imagemGoiaba = imagemGoiaba;
    }
}



