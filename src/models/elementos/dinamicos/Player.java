package models.elementos.dinamicos;

import java.util.List;
import java.util.Random;

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
}