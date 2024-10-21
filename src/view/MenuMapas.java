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

    private int qntdMinElementos(int dimensao) {
        switch (dimensao) {
            case 6:
                return 1;
            case 7:
                return 1;
            case 8:
                return 1;
            case 9:
                return 1;
            case 10:
                return 1;
            case 11:
                return 1;
            case 12:
                return 1;
            default:
                break;
        }
        return -1;
    }

    private int qntdMaxElementos(int dimensao) {
        switch (dimensao) {
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 4;
            case 9:
                return 5;
            case 10:
                return 6;
            case 11:
                return 7;
            case 12:
                return 8;
            default:
                break;
        }
        return -1;
    }

    private int qntdMinMaracuja(int dimensao) {
        switch (dimensao) {
            case 6:
                return 1;
            case 7:
                return 1;
            case 8:
                return 1;
            case 9:
                return 3;
            case 10:
                return 3;
            case 11:
                return 3;
            case 12:
                return 3;
            default:
                break;
        }
        return -1;
    }

    private int qntdMaxMaracuja(int dimensao) {
        switch (dimensao) {
            case 6:
                return 3;
            case 7:
                return 3;
            case 8:
                return 5;
            case 9:
                return 5;
            case 10:
                return 7;
            case 11:
                return 7;
            case 12:
                return 9;
            default:
                break;
        }
        return -1;
    }

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
                            int dimensao;
                            while (true) {
                                try {
                                    dimensao = Integer.parseInt(
                                            JOptionPane.showInputDialog("Digite a dimensão do mapa (entre 6 e 12):"));
                                    if (dimensao >= 6 && dimensao <= 12) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "A dimensão deve ser um número entre 6 e 12.");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int pedras = 0;
                            while (true) {
                                try {
                                    pedras = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de pedras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de pedras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (pedras >= qntdMinElementos(dimensao) && pedras <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de pedras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }

                            int totalMaracujas = 0;
                            while (true) {
                                try {
                                    totalMaracujas = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número total de maracujas: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade total deve ser maior ou igual que: "
                                                            + qntdMinMaracuja(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxMaracuja(dimensao) + "."));
                                    if (totalMaracujas >= qntdMinMaracuja(dimensao) && totalMaracujas <= qntdMaxMaracuja(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número total de maracujas deve ser um número maior ou igual que "+ qntdMinMaracuja(dimensao)+" e menor ou igual que "+ qntdMaxMaracuja(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }

                            int maracuja = 0;
                            while (true) {
                                try {
                                    maracuja = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de maracujas no châo: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade total deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxMaracuja(dimensao) + "."));
                                    if (maracuja >= qntdMinElementos(dimensao) && maracuja <= qntdMaxMaracuja(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de maracujas no châo deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxMaracuja(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }

                            int laranjeiras = 0;
                            while (true) {
                                try {
                                    laranjeiras = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de laranjeiras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de laranjeiras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (laranjeiras >= qntdMinElementos(dimensao) && laranjeiras <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de pedras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int laranjas = 0;
                            while (true) {
                                try {
                                    laranjas = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de laranjas: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de laranjas deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (laranjas >= qntdMinElementos(dimensao) && laranjas <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de laranjas deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int abacateiros = 0;
                            while (true) {
                                try {
                                    abacateiros = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de abacateiros: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de abacateiros deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (abacateiros >= qntdMinElementos(dimensao) && abacateiros <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de abacateiros deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int abacates = 0;
                            while (true) {
                                try {
                                    abacates = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de abacates: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de abacates deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (abacates >= qntdMinElementos(dimensao) && abacates <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de abacates deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int coqueiros = 0;
                            while (true) {
                                try {
                                    coqueiros = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de coqueiros: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de coqueiros deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (coqueiros >= qntdMinElementos(dimensao) && coqueiros <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de coqueiros deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int cocos = 0;
                            while (true) {
                                try {
                                    cocos = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de cocos: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de cocos deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (cocos >= qntdMinElementos(dimensao) && cocos <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de cocos deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int aceroleira = 0;
                            while (true) {
                                try {
                                    aceroleira = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de aceroleiras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de aceroleiras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (aceroleira >= qntdMinElementos(dimensao) && aceroleira <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de aceroleiras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor que ou igual"+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int acerola = 0;
                            while (true) {
                                try {
                                    acerola = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de acerolas: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de acerolas deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (acerola >= qntdMinElementos(dimensao) && acerola <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de acerolas deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int amoreiras = 0;
                            while (true) {
                                try {
                                    amoreiras = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de amoreiras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de amoreiras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (amoreiras >= qntdMinElementos(dimensao) && amoreiras <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de amoreiras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int amora = 0;
                            while (true) {
                                try {
                                    amora = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de amoras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de amoras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (amora >= qntdMinElementos(dimensao) && amora <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de amoras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int goiabeira = 0;
                            while (true) {
                                try {
                                    goiabeira = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de goiabeiras: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de goiabeiras deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (goiabeira >= qntdMinElementos(dimensao) && goiabeira <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de goiabeiras deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int goiabas = 0;
                            while (true) {
                                try {
                                    goiabas = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de goiabas: (Obs.: Devido a dimensão solicitada ("
                                                            + dimensao
                                                            + "), a quantidade de goiabas deve ser maior ou igual que: "
                                                            + qntdMinElementos(dimensao) + " e menor ou igual que: "
                                                            + qntdMaxElementos(dimensao) + "."));
                                    if (goiabas >= qntdMinElementos(dimensao) && goiabas <= qntdMaxElementos(dimensao)) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de goiabas deve ser um número maior ou igual que "+ qntdMinElementos(dimensao)+" e menor ou igual que "+ qntdMaxElementos(dimensao)+".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }

                            int totalFrutas = abacates + acerola + goiabas + amora + laranjas + maracuja + cocos;
                            int bichadas = 0;
                            while (true) {
                                try {
                                    bichadas = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite o número de frutas bichadas: Obs.: a quantidade de frutas bichadas deve ser maior ou igual que: "
                                                            + 0 + " e menor ou igual que: "
                                                            + totalFrutas/3 + "."));
                                    if (bichadas >= 0 && bichadas <= totalFrutas/3) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de frutas bichadas deve ser um número maior ou igual que "+ 0 +" e menor que "+ totalFrutas/3 +".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }
                            int mochila = 0;
                            while (true) {
                                try {
                                    mochila = Integer
                                            .parseInt(JOptionPane.showInputDialog(
                                                    "Digite a capacidade da mochila: Obs.: a capacidade deve ser maior ou igual que: "
                                                            + 8 + " e menor ou igual que: "
                                                            + totalFrutas + "."));
                                    if (mochila >= 8 && mochila <= totalFrutas) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Por favor, o número de frutas mochila deve ser um número maior ou igual que "+ 8 +" e menor que "+ totalFrutas +".");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                                }
                            }

                            // modificar leitor true
                            if (true) {
                                try {
                                    // Criar e escrever no arquivo do mapa
                                    File novoMapa = new File(diretorioMapas, "mapa" + (index + 1) + ".txt");
                                    FileWriter writer = new FileWriter(novoMapa);
                                    writer.write("dimensao " + dimensao + "\n");
                                    writer.write("pedras " + pedras + "\n");
                                    writer.write("maracuja " + totalMaracujas + " " + maracuja + "\n");
                                    writer.write("laranja " + laranjeiras + " " + laranjas +"\n");
                                    writer.write("abacate " + abacateiros + " " + abacates +"\n");
                                    writer.write("coco " + coqueiros + " " + cocos +"\n");
                                    writer.write("acerola " + aceroleira + " " + acerola + "\n");
                                    writer.write("amora " + amoreiras + " " + amora + "\n");
                                    writer.write("goiaba " + goiabeira + " "+ goiabas +"\n");
                                    writer.write("bichadas " + bichadas + "\n");
                                    writer.write("mochila " + mochila + "\n");
                                    writer.close();
                                    slots[index].setText("Slot " + (index + 1) + " (" + novoMapa.getName() + ")");
                                } catch (IOException ioException) {
                                    JOptionPane.showMessageDialog(null,
                                            "Erro ao criar o mapa: " + ioException.getMessage());
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Limite de 5 mapas atingido. Exclua um mapa antes de adicionar outro.");
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
                                JOptionPane.showMessageDialog(null,
                                        "Erro ao excluir o mapa: " + ioException.getMessage());
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
