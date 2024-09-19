package view;
import javax.swing.JFrame;

import models.ambiente.Floresta;

public class Jogo extends JFrame {
    public Jogo() {
        // Fixando a dimensão da floresta como 6, tornar dinamico posteriormente
        add(new Floresta(6));
        setTitle("Floresta");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
