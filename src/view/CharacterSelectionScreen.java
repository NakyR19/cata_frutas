package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * tela de seleção de personagens
 * 
 * @author NakyR19 - Rafael
 */
public class CharacterSelectionScreen extends JFrame {
    private JLabel characterImageLabel;
    private JLabel nameLabel, originLabel, modiferLabel;
    private JTextArea descriptionArea, modiferArea;
    private JButton nextButton, prevButton, confirmButton;
    // private int pIndex;

    // Informações dos personagens
    private String[] characterNames = { "Malandro", "Ajudante do Papai Noel", "Ash Ketchup", "Cosplayer",
            "Maria Chiquinha", "Enzo Gabriel", "Praiana", "Ametista", "Fadinha", "Edgreen Cullen" };
    private String[] characterOrigins = { "Rio de Janeiro - RJ", "Polo Norte", "Kanto", "Xique-Xique - BA",
            "Mimoso - GO", "São Paulo - SP", "Praia do Forte - BA", "Aracaju - SE", "Imperatriz - MA", "Transilvania" };
    private String[] characterNameHab = { "Lábia", "Presentes", "Double Catch", "Cópia", "Genaro", "Privilégios",
            "Água de Coco", "Târo da Morte", "Prodígio", "Clorofila" };
    private String[] characterDescriptions = {
            "Um bom malandro, conquistador, tem naipe de artista, pique de jogador.",
            "Muito esquentadinho, não tem paciência pra nada, mas uma ótima pessoa que sempre se deixa levar pelo coração.",
            "Caçador de pok... Ops! Frutas! \n " + "Frutas, temos que pegar, eu sei!\n Pega-lás eu tentarei!",
            "Cosplayer de evento de animes, gosta de se vestir como princesas dos jogos, contudo, discute sempre com sua mãe por causa disso.",
            "Que c'ocê foi fazer no mato, Maria Chiquinha?\r\n" + //
                    "Que c'ocê foi fazer no mato?",
            "Faria Limer com orgulho, Enzo Gabriel nunca pisou num sitío, fazenda ou algo parecido, a coisa mais próxima de uma floresta em que já pisou, foi no videogame 'playando meuh' Stardew Valley.",
            "Vive na praia, não tem muito o que falar dela não, apenas que está sempre bronzeada. (Isso vai render uns problemas de pele no futuro, mas... Quem disse que é problema meu?).",
            "Adoro ler todo tipo de livro, além de ser uma fiel seguidora das artes das trevas e uma verdadeira dependente do tarô! Pena que nenhuma carta acerta meu futuro.",
            "Campeã Mundial de Skate e com duas medalhas olímpicas no currículo. Um verdadeiro prodígio. (Se eu fosse primo dela choraria, não sei se por orgulho, ou por ter alguém na família falando: 'Ain mas sua prima é amada pelo Brasil todo, pq vc não é igual a ela?')",
            "É um vampiro com uma personalidade sensível e charmosa, mas não muito comunicativo, contudo, ao contrário dos vampiros usuais, ele tem uma preferência incomum, a qual prefere chupar a clorofila das plantas, motivo esse por qual seu cabelo está verde.",

    };

    private String[] charactersModifiers = {
            "Como um bom carioca, possui um dom de fala e persuação incrível, de tal forma que no início de cada turno convence com sua lábia o adversário a entregar 3 pontos de movimento.",
            "Chuva de present... Digo, frutas! Quando empurra um adversário, há uma chance de 20% de dobrar a quantidade de frutas que caem no chão.",
            "Por vontade do roteir... Digo, sorte de protagonista, curiosamente recebe o dobro de frutas ao capturá-las do chão. (Exceto maracujás)",
            "Na ação de comer uma fruta sem efeito, a fruta realiza um cosplay de outra existente no jogo e fornece ao jogador um efeito aleatório. (Exceto maracujás)",
            "Ela se dirige à mata todo fim de turno, não se sabe se é para cortar lenha, ou comer jamelão, de qualquer forma tem uma boa chance de voltar com frutas de lá!",
            "Herdou uma grande mochila, mas seu peso e lerdeza diminuem seus pontos de movimento.",
            "Como uma pessoa que adora a praia, não perde a chance de consumir um coco, ao comer um multiplica seus pontos de movimento em 3.",
            "Salagadula, mexicabula, bibidi-bobodi-bu, ao empurrar há uma chance de 50% de aplicar eficientemente uma magia das trevas, a qual envenena o oponente.",
            "Uma verdadeira prodígio, amada pelo Brasil, a qual tem uma chance de receber presentes dos seus fãs no turno, seja aumento na força, ou pontos de movimento.",
            "Ganha pontos de movimento extra sobre a quantidade de frutas verdes na sua mochila, limite de 7 pontos de movimento por turno."
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

    /**
     * contrutor da seleçõa de personagens
     * 
     * @param menuInicial menu inicial
     * @param pIndex      o indice que vai ter o sprite do personagem selecionado
     * @param p1Name      nome do personagem selecionado
     * 
     * @author NakyR19 - Rafael
     */
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
                characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // redimensiona
                                                                                                                     // a
                                                                                                                     // imagem
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

        // Habilidade
        modiferLabel = new JLabel("Habilidade: " + characterNameHab[currentCharacterIndex]);
        modiferLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte menor
        modiferLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhamento à esquerda
        modiferArea = new JTextArea(4, 20);
        modiferArea.setText(charactersModifiers[currentCharacterIndex]);
        modiferArea.setWrapStyleWord(true); // Quebra no final das palavras
        modiferArea.setLineWrap(true); // Ativa a quebra de linha automática
        modiferArea.setOpaque(false); // Fundo transparente, parece com JLabel
        modiferArea.setEditable(false); // Não editável
        modiferArea.setFocusable(false); // Sem foco
        modiferArea.setFont(new Font("Arial", Font.ITALIC, 12)); // Texto em itálico
        modiferArea.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhamento à esquerda

        // Botão "Próximo"
        confirmButton = new JButton("Próximo");
        confirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Adiciona os componentes ao painel direito com espaçamentos
        rightPanel.add(nameLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical entre componentes
        rightPanel.add(originLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical
        rightPanel.add(descriptionArea);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(modiferLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical
        rightPanel.add(modiferArea);
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
                    new CharacterSelectionScreen(menuInicial, 1, characterNames[currentCharacterIndex])
                            .setVisible(true);
                } else if (pIndex == 1) {

                    if (p1Name.equals(characterNames[currentCharacterIndex])) {
                        JOptionPane.showMessageDialog(null,
                                "Escolha outro personagem. O personagem do jogador 1 não pode ser igual ao do jogador 2.",
                                "Erro", JOptionPane.ERROR_MESSAGE);
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

    /**
     * atualiza infromações expostas na tela como: sprite, nome, naturalidade e
     * descrição.
     * 
     * @author NakyR19 - Rafael
     */
    private void updateCharacterInfo() {
        characterImageLabel.setIcon(new ImageIcon(
                characterImages[currentCharacterIndex].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // redimensiona
                                                                                                                     // a
                                                                                                                     // imagem
        nameLabel.setText("Nome: " + characterNames[currentCharacterIndex]);
        originLabel.setText("Naturalidade: " + characterOrigins[currentCharacterIndex]);
        descriptionArea.setText(characterDescriptions[currentCharacterIndex]);
        modiferLabel.setText("Habilidade: " + characterNameHab[currentCharacterIndex]);
        modiferArea.setText(charactersModifiers[currentCharacterIndex]);
    }
}