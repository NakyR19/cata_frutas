package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import models.elementos.Elemento;
import models.elementos.dinamicos.Fruta;
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


    // Conjunto de teclas de controle
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;

    /**
     * Construtor
     * 
     * @param player            o jogador a ser controlado
     * @param florestaComponent o componente da floresta onde o jogador se move
     * @param upKey             a tecla para mover para cima
     * @param downKey           a tecla para mover para baixo
     * @param leftKey           a tecla para mover para a esquerda
     * @param rightKey          a tecla para mover para a direita
     * @param jogo              a instância do jogo para alternar turnos
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
    public FlorestaComponent getFlorestaComponent(){
        return florestaComponent;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    // Verifica se o jogador atual é o jogador do turno
    System.out.println("Turno atual: " + jogo.getTurnoController().getTurnoAtual().getId());
    System.out.println("Jogador atual: " + player.getId() + " com " + player.getPontosMovimento() + " pontos de movimento");

    if (jogo.getTurnoController().getTurnoAtual() != player) {
        System.out.println("Não é o turno do jogador " + player.getId());
        return; // Se não for o turno do jogador, não faz nada
    }

    if (player.getPontosMovimento() <= 0) {
        return; // Se não houver pontos de movimento, não faz nada
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
    } else if (keyCode == leftKey) {
        novoX += LESS_ONE_MV;
        isMovementKey = true;
        player.setDirecaoAtual("esquerda");
    } else if (keyCode == rightKey) {
        novoX += PLUS_ONE_MV;
        isMovementKey = true;
        player.setDirecaoAtual("direita");

    } else if (keyCode == KeyEvent.VK_E){
        Elemento elemento = florestaComponent.getFloresta().getElementos()[player.getX()][player.getY()];
            if (elemento instanceof Fruta) {
                Fruta fruta = (Fruta) elemento;
                if (player.pegarFruta(fruta)) {
                    florestaComponent.getFloresta().setTileAsGrama(player.getX(), player.getY());
                    System.out.println(fruta.TipoFruta + " coletada!");
                    florestaComponent.repaint();
                    System.out.println(player.getMochila());
                }
            }
    } else if(keyCode == KeyEvent.VK_F){//botão provisório para acabar a rodada, pode ser removido, trocado ou alterado futuramente
        System.out.println(player.getId() + " acabou com seu turno.");
        jogo.getTurnoController().alternarTurno();
        florestaComponent.repaint();
    }

    if (verificarPedra(novoX, novoY)>0){
        Elemento elemento = florestaComponent.getFloresta().getElementos()[novoX][novoY];
        Pedra pedra = (Pedra) elemento;
        pedra.interagir(player);
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

    // Atualiza a posição do player no objeto Player
    if (!florestaComponent.getFloresta().isCollision(novoX, novoY)) {
        player.mover(novoX, novoY);
        player.setPontosMovimento(player.getPontosMovimento() - 1); // Decresce os pontos de movimento
        System.out.println("Jogador " + player.getId() + " moveu para (" + novoX + ", " + novoY + ") com " + player.getPontosMovimento() + " pontos de movimento restantes");
        jogo.atualizarTurnoLabel();
    }

    // Alterna o turno se os pontos de movimento se esgotarem
    if (player.getPontosMovimento() <= 0) {
        jogo.getTurnoController().alternarTurno();
    }

    florestaComponent.repaint(); // Atualiza o desenho

    

    
}

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

       //Verifica se o objeto na frente é uma pedra 
    public int verificarPedra(int x, int y){
        Elemento elemento = florestaComponent.getFloresta().getElementos()[x][y];
        if (x < 0 || x >= florestaComponent.getFloresta().getDimensao() || y < 0 || y >= florestaComponent.getFloresta().getDimensao()){
            return 0;
        }
        else if (elemento instanceof Pedra){
            switch (player.getDirecaoAtual()) {
                case "direita":
                    contPedras = 1 + verificarPedra(x + 1, y);
                    return contPedras;
                case "esquerda":
                    contPedras = 1 + verificarPedra(x - 1, y);
                    return contPedras;
                case "cima":
                    contPedras =  1 + verificarPedra(x, y - 1);
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

    public boolean isSamePos(){
        return player.getX() == adversario.getX() && player.getY() == adversario.getY();
    }

    public void empurrar(){
        int forcaJogador = player.getForca();
        System.out.println(forcaJogador);
        int forcaAdversario = adversario.getForca();
        System.out.println(forcaAdversario);
        int calcForcaPlayer = (int) Math.round(Math.log(forcaJogador + 1) / Math.log(2));
        int calcForcaAdv = (int) Math.round(Math.log(forcaAdversario + 1) / Math.log(2));

        int empurrar = Math.max(0, calcForcaPlayer - calcForcaAdv);
        System.out.println(empurrar + "qntd frutas q cairao");
        String mensagem = "Jogador que empurrou: " + player.getNome() + "\n" +
                          "Jogador que foi empurrado: " + adversario.getNome() + "\n" +
                          "Quantidade de frutas que caíram: " + empurrar;
        JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
        for(int i = 0; i < empurrar && adversario.getMochila().size() > 0; i++) {
            Fruta fruta = adversario.removerFrutaAleatoria();

            int posX = adversario.getX();
            int posY = adversario.getY();

            // Verifica as posições adjacentes
            int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Cima, Baixo, Esquerda, Direita
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
        if(!frutaColocada){
            System.out.println("Sem espaço no campo");
        }
        }
    }
}