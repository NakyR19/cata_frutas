package view;

import controllers.PlayerController;
import controllers.TurnoController;
import models.ambiente.Floresta;
import models.elementos.dinamicos.Player;
import utils.MapaUtils;
import view.ambiente.FlorestaComponent;
import view.elementos.dinamico.PlayerComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

public class Jogo extends JFrame {
    private static final int CELL_SIZE = 64;
    private static final int WIDTH_OVER = 14;
    private static final int HEIGHT_OVER = 67;
    private static final int DIMENSAO_MIN = 6;
    private static final int DIMENSAO_MAX = 12;

    private Player p1;
    private Player p2;
    private PlayerController p1Controller;
    private PlayerController p2Controller;
    private TurnoController turnoController;
    private JLabel turnoLabel;
    private MapaUtils mapaUtils;

    /**
     * Construtor da classe Jogo.
     * 
     * @param menuInicial A janela do menu inicial.
     */
    public Jogo(JFrame menuInicial) {
        this.mapaUtils = new MapaUtils();
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
        int dimensao = mapaUtils.lerDimensaoDoMapa(arquivoMapa);
        int numPedras = mapaUtils.lerNumPedrasDoMapa(arquivoMapa);
        int numLaranjeiras = mapaUtils.lerNumLaranjeirasDoMapa(arquivoMapa);
        int numLaranjas = mapaUtils.lerNumLaranjas(arquivoMapa);
        int numGoiabeiras = mapaUtils.lerNumGoiabeirasDoMapa(arquivoMapa);
        int numGoiabas = mapaUtils.lerNumGoiabasDoMapa(arquivoMapa);
        int numCoqueiros = mapaUtils.lerNumCoqueirosDoMapa(arquivoMapa);
        int numCocos = mapaUtils.lerNumCocosDoMapa(arquivoMapa);
        int numAmoreiras = mapaUtils.lerNumAmoreirasDoMapa(arquivoMapa);
        int numAmoras = mapaUtils.lerNumAmorasDoMapa(arquivoMapa);
        int numAceroleiras = mapaUtils.lerNumAceroleirasDoMapa(arquivoMapa);
        int numAcerolas = mapaUtils.lerNumAcerolasDoMapa(arquivoMapa);
        int numAbacateiros = mapaUtils.lerNumAbacateirosDoMapa(arquivoMapa);
        int numAbacates = mapaUtils.lerNumAbacatesDoMapa(arquivoMapa);
        int numMaracujasTotais = mapaUtils.lerNumMaracujasTotais(arquivoMapa);
        int numMaracujas = mapaUtils.lerNumMaracujas(arquivoMapa);
        int capacidadeMochila = mapaUtils.lerCapacidadeMochila(arquivoMapa);
        int chanceBichadas = mapaUtils.lerChanceBichadas(arquivoMapa);

        if (dimensao < DIMENSAO_MIN || dimensao > DIMENSAO_MAX) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o mapa.");
            menuInicial.setVisible(true);
            dispose();
            return;
        }

        // Cria o jogo com a dimensão lida do arquivo
        Floresta floresta = new Floresta(dimensao, numPedras, numLaranjeiras, numLaranjas, numGoiabeiras, numGoiabas, numCoqueiros, numCocos, numAmoreiras, numAmoras,
            numAceroleiras, numAcerolas, numAbacateiros, numAbacates, numMaracujas, numMaracujasTotais, chanceBichadas, capacidadeMochila);
        p1 = floresta.getPlayer("p1");
        p2 = floresta.getPlayer("p2");
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

        // Inicializa os controladores dos jogadores
        p1Controller = new PlayerController(p1, florestaComponent, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT, this, p2);
        p2Controller = new PlayerController(p2, florestaComponent, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A,
                KeyEvent.VK_D, this, p1);
                // Randomiza quem irá iniciar o jogo
        Random random = new Random();
        Player jogadorInicial = random.nextBoolean() ? p1 : p2;
        turnoController = new TurnoController(p1, p2, jogadorInicial, this, floresta);
        addKeyListener(jogadorInicial == p1 ? p1Controller : p2Controller); // randomiza quem irá iniciar o jogo
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
        // Adiciona o JLabel para exibir o turno e os pontos de movimento
        infoInterface();
        add(turnoLabel, BorderLayout.NORTH);
        atualizarTurnoLabel();

    }

    public void atualizarControlador(Player turnoAtual) {
        if (turnoAtual == p1) {
            System.out.println("Atualizando controlador para p1");
            removeKeyListener(p2Controller);
            addKeyListener(p1Controller);
        } else {
            System.out.println("Atualizando controlador para p2");
            removeKeyListener(p1Controller);
            addKeyListener(p2Controller);
        }
        setFocusable(true);
        requestFocusInWindow();
        atualizarTurnoLabel();
    }

    public TurnoController getTurnoController() {
        return turnoController;
    }

    public void atualizarTurnoLabel() {
        Player turnoAtual = turnoController.getTurnoAtual();
        turnoLabel
                .setText("Turno: " + turnoAtual.getId() + " | Pontos de Movimento: " + turnoAtual.getPontosMovimento());
    }

    private void infoInterface (){
        // Adiciona o JLabel para exibir o turno e os pontos de movimento
        turnoLabel = new JLabel();
        turnoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        turnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnoLabel.setBackground(Color.LIGHT_GRAY);
        turnoLabel.setOpaque(true);
        turnoLabel.setForeground(Color.BLACK);
        turnoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
    }
}
