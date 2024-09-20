package view;
import javax.swing.JFrame;
import view.ambiente.FlorestaComponent;
import models.ambiente.Floresta;

public class Jogo extends JFrame {
    public Jogo() {
        // Fixando a dimensão da floresta como 6, tornar dinamico posteriormente
        Floresta floresta = new Floresta(6);
        add(new FlorestaComponent(floresta));
        setTitle("Floresta");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
