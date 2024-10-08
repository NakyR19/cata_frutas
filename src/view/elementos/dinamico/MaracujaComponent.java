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
        ImageIcon referencia = new ImageIcon("");//colocar a referência depois
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
        g.drawImage(imagemMaracuja, x, y, cellSize, cellSize, null);
    }

    /**
     * Pega o objeto Maracuja associado a este componente.
     * @return O objeto Maracuja.
     */

    public Maracuja getMaracuja(){
        return maracuja;
    }

    /** 
     * Define o objeto Maracuja associado a este componente.
     * @return A imagem do objeto Maracuja.
     */

    public void setMaracuja(Maracuja m){
        this.maracuja = m;
    }

    /**
     * Pega a imagem do obejto Maracuja associada a este componente.
     * @return A imagem do objeto Maracuja.
     */

    public Image getImageMaracuja(){
        return imagemMaracuja;
    }

    /**
     * Define a imagem do objeto Maracuja associado a este componente.
     * @return  imagemLaranja A nova imagem do objeto Maracuja.
     */

    public void setImagemMaracuja(Image imgM){
        this.imagemMaracuja = imgM;
    }
    
}
