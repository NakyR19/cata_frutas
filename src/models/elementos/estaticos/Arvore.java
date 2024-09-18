package models.elementos.estaticos;
import java.awt.Color;
import java.awt.Graphics;

public class Arvore extends Elemento {

    public Arvore(int x, int y) {
        super(x, y);
    }

    // Desenha uma arvore como um quadrado verde no tabuleiro
    @Override
    public void desenhar(Graphics g) {
        int tamanhoCelula = 60; // Tamanho de cada célula no grid
        int xPos = x * tamanhoCelula;
        int yPos = y * tamanhoCelula;

        // Fixando cor e desenhando um quadrado para a árvore
        g.setColor(Color.GREEN);
        g.fillRect(xPos, yPos, tamanhoCelula, tamanhoCelula);

        // Desenhando borda ao redor da célula
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, tamanhoCelula, tamanhoCelula);
    }
}
