package view;
import models.ambiente.Floresta;
import models.elementos.dinamicos.Player;

import javax.swing.JFrame;

import controllers.PlayerController;
import view.ambiente.FlorestaComponent;
import view.elementos.dinamico.PlayerComponent;

public class Jogo extends JFrame {
    private static final int CELL_SIZE = 64;  // Definindo o tamanho da célula
    private static final int WIDTH_OVER = 14;  // Definindo o tamanho da célula
    private static final int HEIGHT_OVER = 37;  // Definindo o tamanho da célula


    public Jogo() {
        // Fixando a dimensão da floresta como 6, tornar dinamico posteriormente
        Floresta floresta = new Floresta(6);
        add(new FlorestaComponent(floresta));
        setTitle("Floresta");
        // Para o calculo do tamanho do size irá ser 64x(dimensao)+14 para o width, e 64xdimensao+37 para height 
        setSize(floresta.getDimensao()*CELL_SIZE+WIDTH_OVER, floresta.getDimensao()*CELL_SIZE+HEIGHT_OVER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

         Player player = floresta.getPlayer();

        // Criando o PlayerComponent e o controlador
        PlayerComponent playerComponent = new PlayerComponent(player);
        add(playerComponent);

        PlayerController playerController = new PlayerController(player, playerComponent);
        addKeyListener(playerController); // Adiciona o KeyListener ao JFrame
        // int alturaTotal = getHeight();
        // int alturaConteudo = getContentPane().getHeight();
        // int alturaBarraTitulo = alturaTotal - alturaConteudo;
        // int larguraTotal = getWidth();
        // int larguraConteudo= getContentPane().getWidth();
        // int larguraBarra = larguraTotal - larguraConteudo;
        // System.out.println(alturaBarraTitulo + " " + larguraBarra);
    }
}
