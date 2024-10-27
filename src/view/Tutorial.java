package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame {

    private JButton buttonVoltar;
    private JLabel imgTutorial;

    public Tutorial(JFrame menuInicial) {

        ImageIcon tutorialImage = new ImageIcon(getClass().getResource("/res/images/tutorial.png"));
        this.imgTutorial = new JLabel(tutorialImage);
        
        this.buttonVoltar = new JButton("Voltar");
        
        aparencia();
        configB(menuInicial);
    }

    private void aparencia() {
        setTitle("Tutorial");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        add(imgTutorial, BorderLayout.CENTER);
        add(buttonVoltar, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void configB(JFrame menuInicial) {
        buttonVoltar.setBackground(Color.decode("#1F0C39"));
        buttonVoltar.setForeground(Color.WHITE);
        buttonVoltar.setPreferredSize(new Dimension(100, 40));
        buttonVoltar.setFocusPainted(false);

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuInicial.setVisible(true);
                dispose();
            }
        });
    }
}
