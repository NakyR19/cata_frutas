package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuMapas extends JFrame {
    private final JButton[] slots;
    private final boolean[] mapasCriados; // Controla quais slots têm mapas criados
    private final String[] predefinicoes; // Armazena as predefinições dos mapas

    public MenuMapas(JFrame menuInicial) { // Recebe a instância do MenuInicial
        super("Menu de Mapas");
        setLayout(new GridLayout(6, 1)); // 5 slots + 1 linha para o botão de fechar

        slots = new JButton[5];
        mapasCriados = new boolean[5];
        predefinicoes = new String[5];

        for (int i = 0; i < 5; i++) {
            int index = i; // Variável final para ser usada dentro da classe anônima

            slots[i] = new JButton("Slot " + (i + 1) + " (Vazio)");
            add(slots[i]);

            slots[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!mapasCriados[index]) {
                        String predefinicao = JOptionPane.showInputDialog("Insira as predefinições para o mapa:");
                        if (predefinicao != null && !predefinicao.isEmpty()) {
                            predefinicoes[index] = predefinicao;
                            mapasCriados[index] = true;
                            slots[index].setText("Slot " + (index + 1) + " (Mapa Criado)");
                        }
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir o mapa?");
                        if (confirm == JOptionPane.YES_OPTION) {
                            mapasCriados[index] = false;
                            predefinicoes[index] = null;
                            slots[index].setText("Slot " + (index + 1) + " (Vazio)");
                        }
                    }
                }
            });
        }

        // Botão para fechar o menu
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> System.exit(0));
        add(btnFechar);

        // Configurações da janela
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Para gerenciar o fechamento manualmente
        setVisible(true);

        // Adiciona o listener para o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar a janela do menu inicial antes de fechar
                menuInicial.setVisible(true);

                // Fechar e remover o MenuMapas da memória
                dispose();
            }
        });
    }
}
