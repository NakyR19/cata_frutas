package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame {
    public MenuInicial(){

        setTitle("Cata-Frutas");
        setSize(400,500);
        setLayout(new GridLayout(2,1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JButton ButtonIniciarJogo = new JButton("Jogar");
        JButton ButtonMapas = new JButton("Mapas");
        ButtonIniciarJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Jogo(MenuInicial.this);
            }
        });
        ButtonMapas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuMapas(MenuInicial.this);
            }
        });
        add(ButtonIniciarJogo);
        add(ButtonMapas);
        setVisible(true);
    }
}
