package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Coco;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe CocoComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Coco na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author MariaLuizaCA - MAria Luíza
 */

public class CocoComponent extends ElementoComponent{

     /**
     * coco - Referência ao objeto do tipo Coco.
     * imagemCoco - Imagem que representa o objeto Coco.
     */

    private Coco coco;
    private Image imagemCoco;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param c O objeto Coco associado a este componente.
     */

    public CocoComponent(Coco c){
        this.coco = c;
        ImageIcon referencia = new ImageIcon("");//colocar a referência depois
        imagemCoco = referencia.getImage();
    }

    /**
     * Desenha o objeto Coco na interface gráfica.
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
        g.drawImage(imagemCoco, x + offsetX, y +offsetY, 16, 16, null);
    }

    /**
     * Pega o objeto Coco associado a este componente.
     * @return O objeto Coco.
     */

    public Coco getCoco(){
        return coco;
    }

    /** 
     * Define o objeto Coco associado a este componente.
     * @return A imagem do objeto Coco.
     */

    public void setCoco(Coco coco){
        this.coco = coco;
    }

    /**
     * Pega a imagem do obejto Coco associada a este componente.
     * @return A imagem do objeto Coco.
     */

    public Image getImageCoco(){
        return imagemCoco;
    }

    /**
     * Define a imagem do objeto Coco associado a este componente.
     * @return  imagemCoco A nova imagem do objeto Coco.
     */

    public void setImagemCoco(Image imagemCoco){
        this.imagemCoco = imagemCoco;
    }
}



