package models.elementos.dinamicos;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

import controllers.PlayerController;
import view.elementos.dinamico.PlayerComponent;

import java.util.ArrayList;

// Apenas implementando logica de movimento e comando do teclado, implementar mochila e outros posteriormente
/**
 * Player representa um jogador que pode se mover, e que tem uma mochila com
 * frutas.
 * Esta classe herda da classe ElemDinamico.
 * 
 * @author NakyR19 - Rafael
 */
public class Player extends ElemDinamico {
    private String id;
    private int pontosMovimento;
    private List<Fruta> mochila;
    private int capacidadeMochila;
    private boolean poison = false;
    private int pontosVitoria = 0;
    private String direcaoAtual;
    private PlayerController playerController;
    private int multiplicadorForca = 1;
    private String nome = "biboca";
    private PlayerComponent playerComponent;
    private boolean cooldown = false;

    /**
     * Construtor da classe Player.
     * 
     * @param x  A coordenada x inicial do jogador.
     * @param y  A coordenada y inicial do jogador.
     * @param id O identificador do jogador.
     */
    public Player(int x, int y, String id, int capacidadeMochila) {
        super(x, y);
        this.id = id;
        this.mochila = new ArrayList<>();
        this.capacidadeMochila = capacidadeMochila;
        // this.pontosMovimento = pontosMovimento;
    }

    /**
     * Move o jogador para uma nova posição.
     * 
     * @param x A nova coordenada x do jogador.
     * @param y A nova coordenada y do jogador.
     */
    @Override
    public void mover(int x, int y) {
        this.x = x;
        this.y = y;
        if (playerController != null) {
            playerController.animateMovement();
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPlayerComponent(PlayerComponent playerComponent) {
        this.playerComponent = playerComponent;
    }

    public PlayerComponent getPlayerComponent() {
        return playerComponent;
    }

    public int getPontosMovimento() {
        return pontosMovimento;
    }

    public void setPontosMovimento(int pontosMovimento) {
        this.pontosMovimento = pontosMovimento;
    }

    public boolean isCooldown() {
        return cooldown;
    }

    public void setCooldown(boolean cooldown) {
        this.cooldown = cooldown;
    }

    public List<Fruta> getMochila() {
        return mochila;
    }

    public int getCapacidadeMochila() {
        return capacidadeMochila;
    }

    public boolean getPoison() {
        return this.poison;
    }

    public void setPoison(Boolean p) {
        this.poison = p;
    }

    public int getPontosVitoria() {
        return pontosVitoria;
    }

    public void setPontosVitoria(int n) {
        this.pontosVitoria = n;
    }

    public int getMultiplicadorForca() {
        return multiplicadorForca;
    }

    public void setMultiplicadorForca(int multiplicadorForca) {
        this.multiplicadorForca = multiplicadorForca;
    }

    public String getDirecaoAtual() {
        return direcaoAtual;
    }

    public void setDirecaoAtual(String direcaoAtual) {
        this.direcaoAtual = direcaoAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public int getForca() {
        return getMochila().size() * multiplicadorForca;
    }

    /**
     * Adiciona uma fruta na mochila do jogador.
     * 
     * @param fruta A fruta q vai ser adicionada.
     */
    public boolean pegarFruta(Fruta fruta) {
        if (mochila.size() < getCapacidadeMochila()) {
            this.mochila.add(fruta);
            if (fruta instanceof Maracuja)
                this.pontosVitoria += 1;
            return true;
        } else {
            System.out.println("Mochila cheia"); // adicionar popup futuramente
            return false;
        }
    }

    /**
     * Remove uma fruta da mochila do jogador.
     * 
     * @param fruta fruta q vai ser removida.
     * @return true se a fruta foi removida, false caso contrário.
     */
    public boolean removerFruta(Fruta fruta) {
        return this.mochila.remove(fruta);
    }

    public Fruta removerFrutaAleatoria() {
        if (this.mochila.isEmpty()) {
            System.out.println("Mochila vazia");
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(this.mochila.size());
        return this.mochila.remove(index);
    }

    public int ajudantePapaiNoel(int empurrar) {
        if (this.getNome().equals("Ajudante do Papai Noel")) {
            Random random = new Random();
            int num = random.nextInt(10);
            if (num < 2) { // 20% de chance (0 ou 1)
                empurrar = empurrar * 2;
                String mensagem = "Eita! A habilidade especial do Ajudante de Papai Noel foi ativada! PRESENTES (a si mesmo...), quando essa habilidade é ativada, o empurrão irá levar o dobro de frutas do oponente comparado ao empurrão normal! Chuva de present... Ops! Chuva de frutas no chão!";
                JOptionPane.showMessageDialog(null, mensagem, "Resultado do Empurrão", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return empurrar;
    }

    public void malandro(int qtdMalandros) {

        if (qtdMalandros == 2) {
            String mensagem = "Opa... Vejamos o que temos aqui! DOIS MALANDROS EM JOGO! A lábia é tão forte que sua habilidade especial se anula!";
            JOptionPane.showMessageDialog(null, mensagem, "Malandro", JOptionPane.INFORMATION_MESSAGE);
        } else if (qtdMalandros == 1) {
            String mensagem = "Opa... Vejamos o que temos aqui! Um Malandro em jogo!\n Todo ínicio de turno ele convence seu adversário a lhe dar 3 pontos de movimento!\n Malandro é malandro, mané é mané, podes crer que é...";
            JOptionPane.showMessageDialog(null, mensagem, "Malandro", JOptionPane.INFORMATION_MESSAGE);
        } else if (qtdMalandros == 0) {
            String mensagem = "Xiii... A quantidade de pontos roubad...\n Digo, que foi convecido a dar, foi tudo que tinha! Ficará esse turno sem jogar!";
            JOptionPane.showMessageDialog(null, mensagem, "Malandro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int edgreenCullenCountFrutas(){
        int count = 0;
        for (Fruta fruta : mochila) {
            if (fruta instanceof Goiaba || fruta instanceof Abacate) {
                count++;
            } 
        }
        return count;
    }

    public void edgreenCullenMensagem(int qntdFrutas){
        if (qntdFrutas > 7) {
            String mensagem = "Opa, nosso amigo da natureza ganhará 7 pontos de movimento, por ter mais de 7 frutas verdes na mochila!";
                JOptionPane.showMessageDialog(null, mensagem, "Edgreen Cullen", JOptionPane.INFORMATION_MESSAGE);
        } else if (qntdFrutas > 0 && qntdFrutas <= 7) {
            String mensagem = "Opa, nosso amigo da natureza ganhará "+qntdFrutas +" pontos de movimento, por ter essa exata quantidade de frutas verdes na mochila!";
                JOptionPane.showMessageDialog(null, mensagem, "Edgreen Cullen", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}