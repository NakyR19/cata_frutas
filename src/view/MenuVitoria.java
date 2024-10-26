package view;

import javax.swing.*;

import models.elementos.dinamicos.Player;

import java.awt.*;

public class MenuVitoria extends JFrame{

    JButton buttonFinalizar;
    JLabel texto;

    Player vencedor;
    
    private ImageIcon[] characterImages = {
        new ImageIcon(getClass().getResource("/res/images/malandro_0.png")),
        new ImageIcon(getClass().getResource("/res/images/ajudante0.png")),
        new ImageIcon(getClass().getResource("/res/images/ash0.png")),
        new ImageIcon(getClass().getResource("/res/images/cosplayer0.png")),
        new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_0.png")),
        new ImageIcon(getClass().getResource("/res/images/enzo0.png")),
        new ImageIcon(getClass().getResource("/res/images/praiana0.png")),
        new ImageIcon(getClass().getResource("/res/images/ametista0.png")),
        new ImageIcon(getClass().getResource("/res/images/fadinha0.png")),
        new ImageIcon(getClass().getResource("/res/images/cullen0.png")),
    };

    public MenuVitoria(Player vencedor){

        this.vencedor = vencedor;

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
        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.setBackground(Color.decode("#1F0C39")); 

        //texto parabenizando o vencedor
        texto = new JLabel(vencedor.getNome() + " (" + vencedor.getId() + ") ganhou!");
        texto.setFont(new Font("Arial", Font.BOLD, 16)); 
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setForeground(Color.decode("#FFFFFF"));
        
        //dimensão e alinhamento do botão
        buttonFinalizar.setPreferredSize(new Dimension(100,30));
        buttonFinalizar.setAlignmentX(Component.CENTER_ALIGNMENT);

        //lê a ação do botão
        buttonListeners();

        //add botão e texto com flexbox 
        Panel.add(Box.createVerticalGlue());
        Panel.add(texto);
        Panel.add(Box.createVerticalGlue());
        Panel.add(buttonFinalizar);
        Panel.add(Box.createVerticalGlue());
        add(Panel, BorderLayout.CENTER);

    }

    private void buttonListeners(){//fecha o jogo atual e volta para o menu inicial
        buttonFinalizar.addActionListener(e -> {
            new MenuInicial();
            setVisible(false);
        });
    }

    
}
