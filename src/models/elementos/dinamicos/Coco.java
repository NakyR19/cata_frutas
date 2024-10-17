package models.elementos.dinamicos;

/**
 * A classe Coco representa uma fruta que, quando coletada, dobra o número de pontos de movimento de uma rodada.
 * É uma subclasse de {@link Fruta}.
 *
 * <p> O efeito da fruta Coco é aumentar a agilidade do jogador, permitindo que ele tenha o dobro de movimentos em uma rodada.</p>
 *
 * @author Maria Luíza Andrade
 */
 public class Coco extends Fruta{
    /**
     * Constrói um objeto Coco com as coordenadas e propriedades especificadas.
     *
     * @param x a coordenada X do Coco.
     * @param y a coordenada Y do Coco.
     * @param TipoFruta o tipo da fruta (Coco).
     * @param Bichada indica se a fruta está bichada (não utilizado atualmente, padrão: false).
     */
    public Coco(int x, int y, String TipoFruta, boolean Bichada) {
       super(x, y);
        TipoFruta = "Coco";
        Bichada = false;
    }
    /**
     * Aplica o efeito de agilidade ao jogador, dobrando o número de pontos de movimento em uma rodada.
     *
     * @param p o jogador que receberá o efeito.
     * @todo Implementar a lógica para dobrar os pontos de movimento do jogador.
     *
     */
    @Override
       public void aplicarEfeito(Player p){
        // Dobrar o número de pontos de movimento de uma rodada
 }
    @Override
    public void mover(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }
}
