package models.elementos.dinamicos;

/**
 * representa maracuja, a fruta usada como marcador de pontos de vitoria
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Maracuja extends Fruta {

    /**
     * Construtor para a classe Maracuja.
     * Inicializa a fruta com suas coordenadas, chance de ser bichada e define o tipo como "Maracuja".
     *
     * @param x A coordenada x do maracujá.
     * @param y A coordenada y do maracujá.
     * @param chanceBichada A chance do maracujá estar bichado em porcentagem
     */
    public Maracuja(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        this.TipoFruta = "Maracuja";

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito do maracujá ao jogador.
     * Neste caso, o maracujá não pode ser consumido, então o efeito não é aplicado.
     *
     * @param p O jogador ao qual o efeito seria aplicado.
     */
    @Override
    public void aplicarEfeito(Player p) {
        //maracujá não pode ser consumido
    }

    /**
     * Método para mover o maracujá.
     * Este método não é implementado e lança uma exceção.
     *
     * @param x A nova coordenada x.
     * @param y A nova coordenada y.
     * @throws UnsupportedOperationException se o método for chamado.
     */
    @Override
    public void mover(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }
}
