package view;

import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JFrame {

    JButton buttonIniciarJogo;
    JButton buttonMenuMapas;
    JLabel logoLabel;

    public MenuInicial() {

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/res/images/logo.png"));
        this.logoLabel = new JLabel(logoIcon);

        this.buttonIniciarJogo = new JButton("Jogar");
        this.buttonMenuMapas = new JButton("Mapas");
        configFrame();
        configUI();
    }

    private void configFrame() {
        setTitle("Cata-Frutas");
        setSize(500, 500);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#1F0C39"));
    }

    private void configUI() {
        // add logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.decode("#1F0C39")); // Match the background color
        logoPanel.add(logoLabel);
        add(logoPanel, BorderLayout.NORTH);
        
        // Painel p os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Usar BoxLayout para respeitar o tamanho preferido
        buttonPanel.setBackground(Color.decode("#1F0C39")); // Cor de fundo dos botões

        // tamanho e alinhamento
        buttonIniciarJogo.setPreferredSize(new Dimension(100, 30));
        buttonMenuMapas.setPreferredSize(new Dimension(100, 30));
        buttonIniciarJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonMenuMapas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add ActionListener aos botões
        buttonListeners();

        // add botões ao painel com espaçamento
        buttonPanel.add(Box.createVerticalGlue()); // add flexbox antes dos botões
        buttonPanel.add(buttonIniciarJogo);
        buttonPanel.add(Box.createVerticalStrut(10)); // padding entre os botões
        buttonPanel.add(buttonMenuMapas);
        buttonPanel.add(Box.createVerticalGlue()); // add flexbox dps dos botões
        add(buttonPanel, BorderLayout.CENTER);

        //corrige o problema que as vezes os botões não apareciam ao iniciar
        setVisible(true);
    }

    private void buttonListeners() {
        buttonIniciarJogo.addActionListener(e -> {
            // setVisible(false);
            // new Jogo(MenuInicial.this);
            setVisible(false);
        new CharacterSelectionScreen(MenuInicial.this).setVisible(true);
        });

        buttonMenuMapas.addActionListener(e -> {
            new MenuMapas(MenuInicial.this);
            setVisible(false);
        });
    }

}
