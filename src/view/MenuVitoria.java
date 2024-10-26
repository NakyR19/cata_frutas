package view;

import javax.swing.*;
import java.awt.*;

public class MenuVitoria extends JFrame{

    JButton buttonFinalizar;

    public MenuVitoria(){

        this.buttonFinalizar = new JButton("Voltar ao menu principal");
        configFrame();
        configUI();
    
    }

    private void configFrame(){//configura a janela
        setTitle("Fim de jogo");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#1F0C39"));
    }

    private void configUI(){
        
        //adicionar depois alguma logo ou algo do tipo para finalizar o jogo

        //cria painel com o botão e o boxlayout que o contem
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.decode("#1F0C39")); 

        //dimensão e alinhamento do botão
        buttonFinalizar.setPreferredSize(new Dimension(100,30));
        buttonFinalizar.setAlignmentX(Component.CENTER_ALIGNMENT);

        //lê a ação do botão
        buttonListeners();

        //add botão com flexbox 
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(buttonFinalizar);
        buttonPanel.add(Box.createVerticalGlue());
        add(buttonPanel, BorderLayout.CENTER);

    }

    private void buttonListeners(){//fecha o jogo atual e volta para o menu inicial
        buttonFinalizar.addActionListener(e -> {
            new MenuInicial();
            setVisible(false);
        });
    }

    
}
