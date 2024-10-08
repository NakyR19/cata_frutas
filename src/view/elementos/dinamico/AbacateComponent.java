package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Abacate;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A classe AbacateComponent representa um componente gráfico dinâmico
 * que exibe uma imagem de um objeto do tipo Abacate na interface gráfica.
 * Herda da classe ElementoComponent para reutilizar funcionalidades.
 * 
 * @author MariaLuizaCA - Maria Luíza 
 */

public class AbacateComponent extends ElementoComponent{

    /**
     * abacate - Referêencia ao objeto do tipo Abacate associado a este componente.
     * imagemAbacate - Imagem que representa o objeto Abacate
     */

    private Abacate abacate;
    private Image imagemAbacate;

    /**
     * Construtor da classe que inicializa o componente gráfico.
     * @param a     O objeto Abacate associado a este componente.
     */

    public AbacateComponent(Abacate a){
        this.abacate = a;
        ImageIcon referencia = new ImageIcon("");  //colocar a referência depois
        imagemAbacate = referencia.getImage();
    }

    /**
     * Desenha o objeto Abacate na interface gráfica.
     * 
     * @param g       O objeto Graphics usado para desenhar   
     * @param x       A coordenada x onde será desenhado 
     * @param y       A coordenada y onde será desenhada 
     * @param cellSize O tamanho da célula onde o objeto será desenhado
     */

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize){
        g.drawImage(imagemAbacate, x, y, cellSize, cellSize, null);
    }

    /**
     * Pega o objeto Abacate associado a este componente.
     * @return O objeto Abacate.
     */

    public Abacate getAbacate(){
        return abacate;
    }

    /** 
     * Define o objeto Abacate associado a este componente.
     * @return A imagem do objeto Abacate.
     */

    public void setAbacate(Abacate abacate){
        this.abacate = abacate;
    }

        /**
     * Pega a imagem do obejto Abacate associada a este componente.
     * @return A imagem do objeto Abacate.
     */

    public Image getImageAbacate(){
        return imagemAbacate;
    }

    /**
     * Define a imagem do objeto Abacate associado a este componente.
     * @return  imagemAbacate A nova imagem do objeto Abacate.
     */

    public void setImagemAbacate(Image imagemAbacate){
        this.imagemAbacate = imagemAbacate;
    }
}








