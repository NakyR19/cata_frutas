package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSelectionScreen extends JFrame {
    private JLabel characterImageLabel;
    private JLabel nameLabel, originLabel;
    private JTextArea descriptionArea;
    private JButton nextButton, prevButton, confirmButton;

    // Informações dos personagens
    private String[] characterNames = {"Malandro", "Pedra", "Coqueiro"};
    private String[] characterOrigins = {"Rio de Janeiro", "Pedra", "Calor"};
    private String[] characterDescriptions = {
            "Um bom malandro, conquistador, tem naipe de artista, pique de jogador.",
            "Pedra",
            "Coco cai na cabeça de corno, curiosos começam a curiar o cara com coco no coco"
    };
    private ImageIcon[] characterImages = {
            new ImageIcon(getClass().getResource("/res/images/sambistaFrente(3).png")),
            new ImageIcon(getClass().getResource("/res/images/pedra(2).png")),
            new ImageIcon(getClass().getResource("/res/images/coqueiro.png"))
    };
    
    private int currentCharacterIndex = 0;
    private JFrame menuInicial;

    public CharacterSelectionScreen(JFrame menuInicial) {
        this.menuInicial = menuInicial;

        // setTitle("Selecionar Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLayout(new BorderLayout());

        // Painel à esquerda
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(new EmptyBorder(20, 50, 15, 20)); // Adiciona padding de 10 pixels em todos os lados
        // JLabel selectLabel = new JLabel("Selecionar Personagem", SwingConstants.CENTER);
        // selectLabel.setFont(new Font("Arial", Font.BOLD, 18));  // Melhorar fonte
        characterImageLabel = new JLabel();
        characterImageLabel.setIcon(new ImageIcon(characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // Redimensiona a imagem para 200x200 pixels

        // Painel para as setas de navegação
        JPanel arrowPanel = new JPanel();
        prevButton = new JButton("<");
        nextButton = new JButton(">");
        arrowPanel.add(prevButton);
        arrowPanel.add(nextButton);

        // leftPanel.add(selectLabel, BorderLayout.NORTH);
        leftPanel.add(characterImageLabel, BorderLayout.CENTER);
        leftPanel.add(arrowPanel, BorderLayout.SOUTH);

        // Painel à direita com estilo
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona borda com espaçamento

        // Nome
        nameLabel = new JLabel("Nome: " + characterNames[currentCharacterIndex]);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));  // Texto em negrito
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Alinhamento à esquerda
        
        // Naturalidade
        originLabel = new JLabel("Naturalidade: " + characterOrigins[currentCharacterIndex]);
        originLabel.setFont(new Font("Arial", Font.PLAIN, 14));  // Fonte menor
        originLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Alinhamento à esquerda

        // Descrição com JTextArea (que permite quebra de linha automática)
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setText(characterDescriptions[currentCharacterIndex]);
        descriptionArea.setWrapStyleWord(true);  // Quebra no final das palavras
        descriptionArea.setLineWrap(true);       // Ativa a quebra de linha automática
        descriptionArea.setOpaque(false);        // Fundo transparente, parece com JLabel
        descriptionArea.setEditable(false);      // Não editável
        descriptionArea.setFocusable(false);     // Sem foco
        descriptionArea.setFont(new Font("Arial", Font.ITALIC, 12));  // Texto em itálico
        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT);  // Alinhamento à esquerda

        // Botão "Próximo"
        confirmButton = new JButton("Próximo");
        confirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Adiciona os componentes ao painel direito com espaçamentos
        rightPanel.add(nameLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Espaço vertical entre componentes
        rightPanel.add(originLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Espaço vertical
        rightPanel.add(descriptionArea);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço vertical maior antes do botão
        rightPanel.add(confirmButton);

        // Ação de trocar de personagem
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentCharacterIndex = (currentCharacterIndex + 1) % characterNames.length;
                updateCharacterInfo();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentCharacterIndex = (currentCharacterIndex - 1 + characterNames.length) % characterNames.length;
                updateCharacterInfo();
            }
        });

        // Ação de iniciar o jogo
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Jogo(menuInicial);
            }
        });

        // Adiciona os painéis à janela
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    // Atualiza as informações do personagem
    private void updateCharacterInfo() {
        characterImageLabel.setIcon(new ImageIcon(characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // Redimensiona a imagem para 200x200 pixels
        nameLabel.setText("Nome: " + characterNames[currentCharacterIndex]);
        originLabel.setText("Naturalidade: " + characterOrigins[currentCharacterIndex]);
        descriptionArea.setText(characterDescriptions[currentCharacterIndex]);
    }
}