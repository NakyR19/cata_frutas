package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.elementos.Elemento;
import models.elementos.dinamicos.Fruta;
import models.elementos.dinamicos.Maracuja;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;
import view.Jogo;
import view.ambiente.FlorestaComponent;

/**
 * PlayerController é responsável por controlar o jogador "escutando" os eventos
 * do teclado.
 * Implementa a interface KeyListener para capturar os eventos.
 * 
 * @author NakyR19 - Rafael
 */
public class PlayerController implements KeyListener {

    private Player player;
    private FlorestaComponent florestaComponent;
    private Jogo jogo;
    private static int PLUS_ONE_MV = 1;
    private static int LESS_ONE_MV = -1;
    private boolean initialPositionCleared = false;
    private Player adversario;
    public int contPedras;
    private boolean empurrou = false;

    // Conjunto de teclas de controle
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;

    /**
     * Construtor da classe PlayerController
     * 
     * @param player            o jogador a ser controlado
     * @param florestaComponent o componente da floresta onde o jogador se move
     * @param upKey             a tecla para mover para cima
     * @param downKey           a tecla para mover para baixo
     * @param leftKey           a tecla para mover para a esquerda
     * @param rightKey          a tecla para mover para a direita
     * @param jogo              a instância do jogo para alternar turnos
     * @param adversario        o jogador adversario ao que esta sendo controlado
     * 
     * @author NakyR19 - Rafael
     */
    public PlayerController(Player player, FlorestaComponent florestaComponent, int upKey, int downKey, int leftKey,
            int rightKey, Jogo jogo, Player adversario) {
        this.player = player;
        player.setPlayerController(this);
        this.florestaComponent = florestaComponent;
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.jogo = jogo;
        this.adversario = adversario;
    }

    public FlorestaComponent getFlorestaComponent() {
        return florestaComponent;
    }

    /**
     * Função que faz diferentes ações a depender da tecla que foi pressionada.
     * Pode mover o jogador, pegar frutas ou acabar o turno atual.
     * 
     * @param e         a tecla que foi pressionada
     * 
     * @author NakyR19 - Rafael
     */
    @Override
    public void keyPressed(KeyEvent e) {

        // Verifica se o jogador atual é o jogador do turno
        System.out.println("Turno atual: " + jogo.getTurnoController().getTurnoAtual().getId());
        System.out.println(
                "Jogador atual: " + player.getId() + " com " + player.getPontosMovimento() + " pontos de movimento");

        if (jogo.getTurnoController().getTurnoAtual() != player) {
            System.out.println("Não é o turno do jogador " + player.getId());
            return; // Se não for o turno do jogador, não faz nada
        }

        if (player.getPontosMovimento() <= 0) {
            return; // Se não houver pontos de movimento, não faz nada
        }

        if (player.isCooldown()) {
            return; // Se o cooldown estiver ativo, não faz nada
        }

        int novoX = player.getX();
        int novoY = player.getY();
        int keyCode = e.getKeyCode();

        boolean isMovementKey = false;

        if (keyCode == upKey) {
            novoY += LESS_ONE_MV;
            isMovementKey = true;
            player.setDirecaoAtual("cima");
        } else if (keyCode == downKey) {
            novoY += PLUS_ONE_MV;
            isMovementKey = true;
            player.setDirecaoAtual("baixo");
            animateMovement();
        } else if (keyCode == leftKey) {
            novoX += LESS_ONE_MV;
            isMovementKey = true;
            player.setDirecaoAtual("esquerda");
        } else if (keyCode == rightKey) {
            novoX += PLUS_ONE_MV;
            isMovementKey = true;
            player.setDirecaoAtual("direita");

        } else if (keyCode == KeyEvent.VK_E) {
            Elemento elemento = florestaComponent.getFloresta().getElementos()[player.getX()][player.getY()];
            if (elemento instanceof Fruta) {
                Fruta fruta = (Fruta) elemento;
                if (player.pegarFruta(fruta)) {
                    if(player.getNome().equals("Ash Ketchup") && !(fruta instanceof Maracuja)){
                        player.pegarFruta(fruta);
                        System.out.println("Ash Ketchup capturou uma fruta selvagem!");
                    }
                        
                    player.setPontosMovimento(player.getPontosMovimento() - 1);
                    jogo.atualizarTurnoLabel();
                    if (player.getPontosMovimento() < 1) {
                        jogo.getTurnoController().alternarTurno();
                    }
                    florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
                    System.out.println(fruta.TipoFruta + " coletada!");
                    florestaComponent.repaint();
                    System.out.println(player.getMochila());
                }
            }
        } else if (keyCode == KeyEvent.VK_F) {// botão para acabar a rodada
            System.out.println(player.getId() + " acabou com seu turno.");
            jogo.getTurnoController().alternarTurno();
            resetEmpurrou();
            florestaComponent.repaint();
        } else if (keyCode == KeyEvent.VK_I) {
            player.exibirInventario();
            return;
        }

        if (verificarPedra(novoX, novoY) > 0) {
            Elemento elemento = florestaComponent.getFloresta().getElementos()[novoX][novoY];
            Pedra pedra = (Pedra) elemento;
            pedra.interagir(player);
            jogo.atualizarTurnoLabel();
        }

        // Se a tecla pressionada não for uma tecla de movimento, não faz nada
        if (!isMovementKey) {
            return;
        }

        verificarPedra(novoX, novoY);

        // Limpa a posição inicial apenas uma vez
        if (!initialPositionCleared) {
            florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
            initialPositionCleared = true;
        }

        int posAnteriorX = player.getX();
        int posAnteriorY = player.getY();

        // Atualiza a posição do player no objeto Player
        if (!florestaComponent.getFloresta().isCollision(novoX, novoY)) {
            if (!isSamePos()) {
                player.mover(novoX, novoY);
                player.setPontosMovimento(player.getPontosMovimento() - 1); // Decresce os pontos de movimento
                System.out.println("Jogador " + player.getId() + " moveu para (" + novoX + ", " + novoY + ") com "
                        + player.getPontosMovimento() + " pontos de movimento restantes");
                jogo.atualizarTurnoLabel();
                System.out
                        .println(player.getX() + "" + player.getY() + " " + adversario.getX() + "" + adversario.getY());
            }
            System.out.println(isSamePos());
            System.out.println(adversario.getMochila());
            System.out.println("EMPURROU: " + empurrou);
            if (isSamePos() && empurrou) {
                String mensagem = "Calma aí nobre " + player.getNome()
                        + " tenha calma, só pode empurrar uma vez por turno!";
                JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
                player.mover(posAnteriorX, posAnteriorY);
            }
            if (isSamePos() && !empurrou) {
                empurrar();
                player.mover(posAnteriorX, posAnteriorY);
                System.out.println(adversario.getMochila());
                empurrou = true;
            }
        }

        // Alterna o turno se os pontos de movimento se esgotarem
        if (player.getPontosMovimento() <= 0) {
            jogo.getTurnoController().alternarTurno();
            resetEmpurrou();
        }

        florestaComponent.repaint(); // Atualiza o desenho

        // Evitando SPAM p/ andar (cooldown)
        player.setCooldown(true);
        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setCooldown(false);
                ((Timer) e.getSource()).stop();
            }
        }).start();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Função que verifica se existe uma pedra em uma posição e se existem outras em sequência.
     * 
     * @param x         Coordenada x que será verificada
     * @param y         Coordenada y que será verificada
     * @return          retorna 0 se não houver pedras, se houver retorna a quantidade de pedras.
     * 
     * @author Maria Luiza
     */
    public int verificarPedra(int x, int y) {
        Elemento elemento = florestaComponent.getFloresta().getElementos()[x][y];
        if (x < 0 || x >= florestaComponent.getFloresta().getDimensao() || y < 0
                || y >= florestaComponent.getFloresta().getDimensao()) {
            return 0;
        } else if (elemento instanceof Pedra) {
            switch (player.getDirecaoAtual()) {
                case "direita":
                    contPedras = 1 + verificarPedra(x + 1, y);
                    return contPedras;
                case "esquerda":
                    contPedras = 1 + verificarPedra(x - 1, y);
                    return contPedras;
                case "cima":
                    contPedras = 1 + verificarPedra(x, y - 1);
                    return contPedras;
                case "baixo":
                    contPedras = 1 + verificarPedra(x, y + 1);
                    return contPedras;
                default:
                    return 0;
            }
        } else {
            return 0;
        }

    }

    /**
     * Verifica se os jogadores estão na mesma posição
     * 
     * @return          true se ambos estiverem na mesm posição, false caso contrário.
     * 
     * @author NakyR19 - Rafael
     */
    public boolean isSamePos() {
        return player.getX() == adversario.getX() && player.getY() == adversario.getY();
    }

    /**
     * Função para a ação empurrar um jogador, usa as formulas dadas para calcular o drop de frutas.
     * Só pode empurrar uma vez por turno.
     * Se a personagem Ametista empurrou, existe chance de envenenar o adversario.
     * 
     * @author NakyR19 - Rafael
     */
    public void empurrar() {
        int forcaJogador = player.getForca();
        System.out.println(forcaJogador);
        int forcaAdversario = adversario.getForca();
        System.out.println(forcaAdversario);
        int calcForcaPlayer = (int) Math.round(Math.log(forcaJogador + 1) / Math.log(2));
        int calcForcaAdv = (int) Math.round(Math.log(forcaAdversario + 1) / Math.log(2));

        int empurrar = Math.max(0, calcForcaPlayer - calcForcaAdv);

        empurrar = player.ajudantePapaiNoel(empurrar);

        if(player.getNome().equals("Ametista")){//se for ametista que empurra tem 50% de chance de envenenar
            if((int)(Math.random() * 100 + 1) > 50){
                adversario.setPoison(true);
                String mensagem = "Ametista usou uma magia e envenenou " + adversario.getNome();
                JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        System.out.println(empurrar + "qntd frutas q cairao");
        if (adversario.getMochila().size() == 0) {
            String mensagem = "Calma aí " + player.getNome() + " dê uma tregua, " + adversario.getNome()
                    + " nem frutas têm na mochila!";
            JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
        } else if (empurrar > adversario.getMochila().size()) {
            String mensagem = "Jogador que empurrou: " + player.getNome() + "\n" +
                    "Jogador que foi empurrado: " + adversario.getNome() + "\n" +
                    "OOOPPPAAA, TODAS AS FRUTAS CAÍRAM, NO TOTAL DE:" + adversario.getMochila().size();
            JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String mensagem = "Jogador que empurrou: " + player.getNome() + "\n" +
                    "Jogador que foi empurrado: " + adversario.getNome() + "\n" +
                    "Quantidade de frutas que caíram: " + empurrar;
            JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
        }

        for (int i = 0; i < empurrar && adversario.getMochila().size() > 0; i++) {
            Fruta fruta = adversario.removerFrutaAleatoria();

            int posX = adversario.getX();
            int posY = adversario.getY();

            // Verifica as posições adjacentes
            int[][] direcoes = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Cima, Baixo, Esquerda, Direita
            boolean frutaColocada = false;

            for (int[] direcao : direcoes) {
                int novaX = posX + direcao[0];
                int novaY = posY + direcao[1];

                if (novaX >= 0 && novaX < florestaComponent.getFloresta().getDimensao() &&
                        novaY >= 0 && novaY < florestaComponent.getFloresta().getDimensao() &&
                        florestaComponent.getFloresta().getElementos()[novaX][novaY] instanceof Grama) {

                    florestaComponent.getFloresta().setFruta(novaX, novaY, fruta);
                    frutaColocada = true;
                    System.out.println("Fruta colocada em X:" + novaX + ",Y:" + novaY);
                    florestaComponent.repaint();
                    break;
                }

            }
            if (!frutaColocada) {
                System.out.println("Sem espaço no campo");
            }
        }
    }

    /**
     * Função para fazer animações ao andar
     * 
     * @author NakyR19 - Rafael
     */
    public void animateMovement() {
        Timer timer = new Timer(50, new ActionListener() { // 50 ms para cada frame
            private int frameCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (frameCount < 3) { // 3 frames de animação
                    player.getPlayerComponent().updateAnimation();
                    florestaComponent.repaint();
                    frameCount++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public boolean isEmpurrou() {
        return empurrou;
    }

    public void setEmpurrou(boolean empurrou) {
        this.empurrou = empurrou;
    }

    public void resetEmpurrou() {
        setEmpurrou(false);
    }
}