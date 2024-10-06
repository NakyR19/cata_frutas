package view;

import controllers.PlayerController;
import models.ambiente.Floresta;
import models.elementos.dinamicos.Player;
import view.ambiente.FlorestaComponent;
import view.elementos.dinamico.PlayerComponent;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Jogo extends JFrame {
    private static final int CELL_SIZE = 64;
    private static final int WIDTH_OVER = 14;
    private static final int HEIGHT_OVER = 37;
    private static final int DIMENSAO_MIN = 6;
    private static final int DIMENSAO_MAX = 12;

    /**
     * Construtor da classe Jogo.
     * @param menuInicial A janela do menu inicial.
     */
    public Jogo(JFrame menuInicial) {
        File diretorioMapas = new File("diretorio_dos_mapas"); // Diretório onde os mapas estão armazenados
        File[] arquivosDeMapa = diretorioMapas.listFiles((dir, name) -> name.endsWith(".txt"));

        if (arquivosDeMapa == null || arquivosDeMapa.length == 0) {
            // Se não houver mapas, abre o menu de mapas para criar um novo
            JOptionPane.showMessageDialog(this, "Nenhum mapa encontrado. Crie um novo mapa.");
            new MenuMapas(menuInicial);
            dispose();
            return;
        }

        // Se houver mapas, solicita que o usuário escolha um
        String[] nomesDeMapas = new String[arquivosDeMapa.length];
        for (int i = 0; i < arquivosDeMapa.length; i++) {
            nomesDeMapas[i] = arquivosDeMapa[i].getName();
        }

        String mapaSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione um mapa:", "Escolher Mapa",
                JOptionPane.PLAIN_MESSAGE, null, nomesDeMapas, nomesDeMapas[0]);

        if (mapaSelecionado == null) {
            // Se o usuário cancelar a seleção, volta ao menu inicial
            menuInicial.setVisible(true);
            dispose();
            return;
        }

        // Carrega as configurações do mapa a partir do arquivo selecionado
        File arquivoMapa = new File(diretorioMapas, mapaSelecionado);
        int dimensao = lerDimensaoDoMapa(arquivoMapa);
        int numPedras = lerNumPedrasDoMapa(arquivoMapa);

        if (dimensao < DIMENSAO_MIN || dimensao > DIMENSAO_MAX) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o mapa.");
            menuInicial.setVisible(true);
            dispose();
            return;
        }

        // Cria o jogo com a dimensão lida do arquivo
        Floresta floresta = new Floresta(dimensao, numPedras);
        Player p1 = floresta.getPlayer("p1");
        Player p2 = floresta.getPlayer("p2");
        PlayerComponent p1Component = new PlayerComponent(p1);
        PlayerComponent p2Component = new PlayerComponent(p2);
        FlorestaComponent florestaComponent = new FlorestaComponent(floresta, p1Component, p2Component);

        add(florestaComponent);
        setTitle("Floresta");
        setSize(floresta.getDimensao() * CELL_SIZE + WIDTH_OVER, floresta.getDimensao() * CELL_SIZE + HEIGHT_OVER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Para gerenciar o fechamento manualmente
        this.setResizable(false);

        // Controlador para p1 com teclas de seta
        PlayerController p1Controller = new PlayerController(p1, florestaComponent, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        addKeyListener(p1Controller);

        // Controlador para p2 com teclas WASD
        PlayerController p2Controller = new PlayerController(p2, florestaComponent, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
        addKeyListener(p2Controller);
        setFocusable(true);
        requestFocusInWindow();

        // Adiciona o listener para o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar a janela do menu inicial antes de fechar
                menuInicial.setVisible(true);

                // Destruir o objeto Jogo
                dispose(); // Fecha e remove o Jogo da memória
            }
        });
    }

    // Função para ler a dimensão do mapa a partir do arquivo
    private int lerDimensaoDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("dimensao")) {
                    // A linha tem o formato: "dimensao <valor>"
                    String[] partes = linha.split(" ");
                    if (partes.length == 2) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }
    
    /**
     * Função para ler a o número de Pedras do mapa a partir do arquivo.
     * @author NakyR19 - Rafael
     * @param arquivoMapa O arquivo que contém o mapa.
     * @return A dimensão do mapa.
     * @throws IOException Se ocorrer um erro ao ler o arquivo.
     */
    private int lerNumPedrasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("pedras")) {
                    // A linha tem o formato: "dimensao <valor>"
                    String[] partes = linha.split(" ");
                    if (partes.length == 2) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }
}
