package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class MenuMapas extends JFrame {
    private final JButton[] slots;
    private final File diretorioMapas;

    public MenuMapas(JFrame menuInicial) {
        super("Menu de Mapas");
        setLayout(new GridLayout(6, 1)); // 5 slots + 1 linha para o botão de fechar
        slots = new JButton[5];
        diretorioMapas = new File("diretorio_dos_mapas"); // Diretório onde os mapas serão salvos

        // Cria o diretório se ele não existir
        if (!diretorioMapas.exists()) {
            diretorioMapas.mkdir();
        }

        // Carrega os mapas existentes no diretório
        File[] arquivosDeMapa = diretorioMapas.listFiles((dir, name) -> name.endsWith(".txt"));
        int totalMapas = arquivosDeMapa != null ? arquivosDeMapa.length : 0;

        // Inicializa os botões de slots
        for (int i = 0; i < 5; i++) {
            int index = i; // Variável final para ser usada dentro da classe anônima
            slots[i] = new JButton("Slot " + (i + 1) + " (Vazio)");
            add(slots[i]);

            if (i < totalMapas) {
                // Se houver um arquivo para este slot, exibe o nome do arquivo
                File arquivo = arquivosDeMapa[i];
                slots[i].setText("Slot " + (i + 1) + " (" + arquivo.getName() + ")");
            }

            slots[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (slots[index].getText().contains("(Vazio)")) {
                        // Se o slot estiver vazio, cria um novo mapa
                        if (totalMapas < 5) {
                            // Solicitar as predefinições do usuário para cada atributo
                            String dimensao = JOptionPane.showInputDialog("Digite a dimensão do mapa:");
                            String pedras = JOptionPane.showInputDialog("Digite o número de pedras:");

                            String maracuja = JOptionPane.showInputDialog("Digite o número de maracujás e quantos no chão (ex: 3 1):");
                            String laranja = JOptionPane.showInputDialog("Digite o número de laranjeiras e quantas frutas no chão (ex: 2 1):");
                            String abacate = JOptionPane.showInputDialog("Digite o número de abacateiros e quantas frutas no chão (ex: 2 3):");
                            String coco = JOptionPane.showInputDialog("Digite o número de coqueiros e quantas frutas no chão (ex: 2 1):");
                            String acerola = JOptionPane.showInputDialog("Digite o número de aceroleiras e quantas frutas no chão (ex: 1 2):");
                            String amora = JOptionPane.showInputDialog("Digite o número de amoreiras e quantas frutas no chão (ex: 1 1):");
                            String goiaba = JOptionPane.showInputDialog("Digite o número de goiabeiras e quantas frutas no chão (ex: 1 1):");

                            String bichadas = JOptionPane.showInputDialog("Digite a quantidade de frutas bichadas:");
                            String mochila = JOptionPane.showInputDialog("Digite a capacidade da mochila:");

                            if (dimensao != null && pedras != null && maracuja != null && laranja != null && abacate != null
                                    && coco != null && acerola != null && amora != null && goiaba != null
                                    && bichadas != null && mochila != null) {
                                try {
                                    // Criar e escrever no arquivo do mapa
                                    File novoMapa = new File(diretorioMapas, "mapa" + (index + 1) + ".txt");
                                    FileWriter writer = new FileWriter(novoMapa);
                                    writer.write("dimensao " + dimensao + "\n");
                                    writer.write("pedras " + pedras + "\n");
                                    writer.write("maracuja " + maracuja + "\n");
                                    writer.write("laranja " + laranja + "\n");
                                    writer.write("abacate " + abacate + "\n");
                                    writer.write("coco " + coco + "\n");
                                    writer.write("acerola " + acerola + "\n");
                                    writer.write("amora " + amora + "\n");
                                    writer.write("goiaba " + goiaba + "\n");
                                    writer.write("bichadas " + bichadas + "\n");
                                    writer.write("mochila " + mochila + "\n");
                                    writer.close();
                                    slots[index].setText("Slot " + (index + 1) + " (" + novoMapa.getName() + ")");
                                } catch (IOException ioException) {
                                    JOptionPane.showMessageDialog(null, "Erro ao criar o mapa: " + ioException.getMessage());
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Limite de 5 mapas atingido. Exclua um mapa antes de adicionar outro.");
                        }
                    } else {
                        // Se o slot já estiver ocupado, permite excluir o mapa
                        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir o mapa?");
                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                File arquivoMapa = new File(diretorioMapas, "mapa" + (index + 1) + ".txt");
                                Files.delete(arquivoMapa.toPath()); // Deleta o arquivo
                                slots[index].setText("Slot " + (index + 1) + " (Vazio)");
                            } catch (IOException ioException) {
                                JOptionPane.showMessageDialog(null, "Erro ao excluir o mapa: " + ioException.getMessage());
                            }
                        }
                    }
                }
            });
        }

        // Botão para voltar ao menu inicial
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            menuInicial.setVisible(true);
            dispose();
        });
        add(btnVoltar);

        // Configurações da janela
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Para gerenciar o fechamento manualmente
        setVisible(true);

        // Adiciona o listener para o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar a janela do menu inicial antes de fechar
                System.exit(0);

                // Fechar e remover o MenuMapas da memória
                dispose();
            }
        });
    }
}
