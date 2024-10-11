package view.elementos.estatico;

import view.elementos.ElementoComponent;
import models.elementos.estaticos.Arvore;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * ArvoreComponent representa o componente gráfico da Arvore no jogo.
 * Herda de ElementoComponent e é responsável por desenhar a Arvore.
 * @author redbdb - Gustavo Assunção
 */

public class ArvoreComponent extends ElementoComponent{
    
     /**
         * arvore - O objeto arvore que é usado no jogo.
         * imagemArvore - A imagem da arvore.
         */
        private Arvore arvore;
        private Image imagemArvore;
        
        /**
         * Construtor da classe ArvoreComponent.
         *
         * @param p O objeto que reprsenta arvore no jogo.
         */
        public ArvoreComponent(Arvore a) {
            this.arvore = a;
            ImageIcon referencia = new ImageIcon("res\\images\\coqueiro.png");//sprite provisorio de coqueiro, possivel mudança
            imagemArvore = referencia.getImage();
        }
        
        /**
         * Desenha a imagem da Arvore na posição (x, y) com o tamanho de resolução da célula.
         *
         * @param g O objeto Graphics usado para desenhar os componentes.
         * @param x A coordenada x onde a imagem será desenhada.
         * @param y A coordenada y onde a imagem será desenhada.
         * @param cellSize O tamanho da célula em pixels.
         */
        @Override
        public void desenhar(Graphics g, int x, int y, int cellSize) {
            // Desenha a imagem na posição (x, y) com o tamanho de resolução da célula 64 x 64
            g.drawImage(imagemArvore, x, y, cellSize, cellSize, null);
        }
        
        public Arvore getArvore() {
            return arvore;
        }
        
        public void setArvore(Arvore a) {
            this.arvore = a;
        }
        public Image getImageArvore() {
            return imagemArvore;
        }
        
        public void setImagemArvore(Image imagemArvore) {
            this.imagemArvore = imagemArvore;
        }
    
}
