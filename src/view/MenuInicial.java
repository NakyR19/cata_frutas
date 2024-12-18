package view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que representa a tela inicial do jogo Cata-Frutas.
 * 
 * @author NakyR19 - Rafael
 */
public class MenuInicial extends JFrame {

    JButton buttonIniciarJogo;
    JButton buttonMenuMapas;
    JButton buttonTutorial;
    JLabel logoLabel;

    /**
     * Construtor da classe MenuInicial.
     * Inicializa os componentes da interface gráfica.
     * 
     * @author NakyR19 - Rafael
     */
    public MenuInicial() {

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/res/images/logo.png"));
        this.logoLabel = new JLabel(logoIcon);

        this.buttonIniciarJogo = new JButton("Jogar");
        this.buttonMenuMapas = new JButton("Mapas");
        this.buttonTutorial = new JButton("Tutorial");
        configFrame();
        configUI();
    }

    /**
     * Configura a janela principal.
     * 
     * @author NakyR19 - Rafael
     */
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

    /**
     * Configura os componentes da interface gráfica.
     * 
     * @author NakyR19 - Rafael
     */
    private void configUI() {
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
        buttonTutorial.setPreferredSize(new Dimension(100, 30));

        buttonIniciarJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonMenuMapas.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonTutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // add ActionListener aos botões
        buttonListeners();

        // add botões ao painel com espaçamento
        buttonPanel.add(Box.createVerticalGlue()); // add flexbox antes dos botões
        buttonPanel.add(buttonIniciarJogo);
        buttonPanel.add(Box.createVerticalStrut(10)); // padding entre os botões
        buttonPanel.add(buttonMenuMapas);
        buttonPanel.add(Box.createVerticalStrut(10)); // padding entre os botões
        buttonPanel.add(buttonTutorial);
        buttonPanel.add(Box.createVerticalGlue()); // add flexbox dps dos botões
        add(buttonPanel, BorderLayout.CENTER);

        //corrige o problema que as vezes os botões não apareciam ao iniciar
        setVisible(true);
    }

    /**
     * Adiciona os listeners aos botões.
     * 
     * @author NakyR19 - Rafael
     */
    private void buttonListeners() {
        buttonIniciarJogo.addActionListener(e -> {
             //setVisible(false);
             //new Jogo(MenuInicial.this);
            setVisible(false);
        new CharacterSelectionScreen(MenuInicial.this, 0, "").setVisible(true);
        });

        buttonMenuMapas.addActionListener(e -> {
            new MenuMapas(MenuInicial.this);
            setVisible(false);
        });

        buttonTutorial.addActionListener(e -> {
            new Tutorial(MenuInicial.this);
            setVisible(false);
        });
    }

}
