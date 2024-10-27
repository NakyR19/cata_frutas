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
    // private int pIndex;

    // Informações dos personagens
    private String[] characterNames = { "Malandro", "Ajudante do Papai Noel", "Ash Ketchup", "Cosplayer", "Maria Chiquinha", "Enzo Gabriel", "Praiana", "Ametista", "Fadinha", "Edgreen Cullen"};
    private String[] characterOrigins = { "Rio de Janeiro - RJ", "Polo Norte", "Kanto", "Xique-Xique - BA", "Mimoso - GO", "São Paulo - SP", "Praia do Forte - BA", "Aracaju - SE", "Imperatriz - MA", "Transilvania"};
    private String[] characterDescriptions = {
            "Um bom malandro, conquistador, tem naipe de artista, pique de jogador.",
            "Muito esquentadinho, não tem paciência pra nada, mas uma ótima pessoa que sempre se deixa levar pelo coração.",
            "Caçador de pok... Ops! Frutas! \nEsse é seu jeito de viver\r\n" + //
                                "Ninguém nunca foi igual\r\n" + //
                                "A sua vida é fazer\r\n" + //
                                "O bem vencer o mal\r\n" + //
                                "Pelo mundo viajará\r\n" + //
                                "Tentando encontrar\r\n" + //
                                "Uma Fruta Ouro e com o seu poder\r\n" + //
                                "Tudo transformar\r\n" + //
                                "Fruta!\r\n" + //
                                "Tenho que pegá-los (isso eu sei)\r\n" + //
                                "Pegá-los eu tentarei\r\n" + //
                                "Fruta!\r\n" + //
                                "Juntos teremos que, a mochila defender\r\n" + //
                                "Fruta! ",
            "Cosplayer de evento de animes, gosta de se vestir como princesas dos jogos, contudo, discute sempre com sua mãe por causa disso.",
            "Que c'ocê foi fazer no mato, Maria Chiquinha?\r\n" + //
                                "Que c'ocê foi fazer no mato?",
            "Faria Limer com orgulho, Enzo Gabriel nunca pisou num sitío, fazenda ou algo parecido, a coisa mais próxima de uma floresta em que já pisou, foi no videogame 'playando meuh' Stardew Valley.",
            "Vive na praia, não tem muito o que falar dela não, apenas que está sempre bronzeada. (Isso vai render uns problemas de pele no futuro, mas... Quem disse que é problema meu?).",
            "Adora ler todo o tipo de livro, além de amar Steven Universo, deseja ser escritora quando crescer, é uma verdadeira sonhadora! Pena que as livrarias estão falindo.",
            "Campeã Mundial de Skate e com duas medalhas olímpicas no currículo. Um verdadeiro prodígio. (Se eu fosse primo dela choraria, não sei se por orgulho, ou por ter alguém na família falando: 'Ain mas sua prima é amada pelo Brasil todo, pq vc não é igual a ela?')",
            "É um vampiro com uma personalidade sensível e charmosa, mas não muito comunicativo, contudo, ao contrário dos vampiros usuais, que chupam sangue, esse tem uma preferência incomum, ele prefere chupar a clorofila das plantas, motivo esse por qual seu cabelo está verde.",

    };
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

    private int currentCharacterIndex = 0;

    public CharacterSelectionScreen(JFrame menuInicial, int pIndex, String p1Name) {
        // this.pIndex = pIndex;
        // setTitle("Selecionar Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel à esquerda
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(new EmptyBorder(20, 50, 15, 20)); // Adiciona padding de 10 pixels em todos os lados
        // JLabel selectLabel = new JLabel("Selecionar Personagem",
        // SwingConstants.CENTER);
        // selectLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Melhorar fonte
        characterImageLabel = new JLabel();
        characterImageLabel.setIcon(new ImageIcon(
                characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // redimensiona a imagem
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
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Texto em negrito
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhamento à esquerda

        // Naturalidade
        originLabel = new JLabel("Naturalidade: " + characterOrigins[currentCharacterIndex]);
        originLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte menor
        originLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhamento à esquerda

        // Descrição com JTextArea (que permite quebra de linha automática)
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setText(characterDescriptions[currentCharacterIndex]);
        descriptionArea.setWrapStyleWord(true); // Quebra no final das palavras
        descriptionArea.setLineWrap(true); // Ativa a quebra de linha automática
        descriptionArea.setOpaque(false); // Fundo transparente, parece com JLabel
        descriptionArea.setEditable(false); // Não editável
        descriptionArea.setFocusable(false); // Sem foco
        descriptionArea.setFont(new Font("Arial", Font.ITALIC, 12)); // Texto em itálico
        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhamento à esquerda

        // Botão "Próximo"
        confirmButton = new JButton("Próximo");
        confirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Adiciona os componentes ao painel direito com espaçamentos
        rightPanel.add(nameLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical entre componentes
        rightPanel.add(originLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical
        rightPanel.add(descriptionArea);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaço vertical maior antes do botão
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
                if (pIndex == 0) {
                    setVisible(false);
                    new CharacterSelectionScreen(menuInicial, 1, characterNames[currentCharacterIndex]).setVisible(true);
                } else if (pIndex == 1) {

                    if(p1Name.equals(characterNames[currentCharacterIndex])){
                        JOptionPane.showMessageDialog(null, "Escolha outro personagem. O personagem do jogador 1 não pode ser igual ao do jogador 2.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        setVisible(false);
                        new Jogo(menuInicial, p1Name, characterNames[currentCharacterIndex]);
                    }
                }
            }
        });

        // Adiciona os painéis à janela
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    // Atualiza as informações do personagem
    private void updateCharacterInfo() {
        characterImageLabel.setIcon(new ImageIcon(
                characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // redimensiona a imagem
        nameLabel.setText("Nome: " + characterNames[currentCharacterIndex]);
        originLabel.setText("Naturalidade: " + characterOrigins[currentCharacterIndex]);
        descriptionArea.setText(characterDescriptions[currentCharacterIndex]);
    }
}