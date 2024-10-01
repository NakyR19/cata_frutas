package models.elementos.dinamicos;

/**
 * A classe Abacate representa uma fruta que, quando coletada, dobra a força do competidor.
 * É uma subclasse de {@link Fruta}.
 *
 * <p> O efeito da fruta Abacate é aumentar a força do jogador, dobrando sua capacidade de ataque ou defesa.</p>
 *
 * @author Maria Luíza Andrade
 */

public class Abacate extends Fruta{
    /**
     * Constrói um objeto Abacate com as coordenadas e propriedades especificadas.
     *
     * @param x a coordenada X do Abacate.
     * @param y a coordenada Y do Abacate.
     * @param TipoFruta o tipo da fruta (Abacate).
     * @param Bichada indica se a fruta está bichada (não utilizado atualmente, padrão: false).
     */
    public Abacate(int x, int y, String TipoFruta, boolean Bichada) {
        super(x, y);
        TipoFruta = 'Abacate';
        Bichada = false;
    }

    /**
     * Aplica o efeito de força ao jogador, dobrando a força do competidor.
     *
     * @param p o jogador que receberá o efeito.
     * @todo Implementar a lógica para dobrar a força do jogador.
     */
    @Override
    public void aplicarEfeito(Player p){
        // Dobrar a força do competidor
    }
}