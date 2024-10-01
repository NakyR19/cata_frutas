package models.elementos.dinamicos;

/**
 * representa um elemento dinâmico no jogo que pode ter efeitos sobre o jogador
 * Esta classe é a classe mãe para todas as frutas que podem ter diferentes tipos e estados (bichada ou não).
 * @author redbdb - Gustavo 
 */
public abstract class Fruta extends ElemDinamico {

    /**
     * O tipo da fruta.
     */
    public String TipoFruta;

    /**
     * Indica se a fruta está bichada.
     */
    public boolean Bichada;

    /**
     * Construtor para a classe Fruta.
     *
     * @param x A coordenada x da fruta.
     * @param y A coordenada y da fruta.
     */
    public Fruta(int x, int y) {
        super(x, y);
    }

    /**
     * Aplica o efeito da fruta ao jogador.
     * Este método deve ser implementado pelas subclasses para definir o efeito específico da fruta.
     *
     * @param p O jogador ao qual o efeito será aplicado.
     * @return true se o efeito foi aplicado com sucesso, false caso contrário.
     */
    public abstract boolean aplicarEfeito(Player p);
}