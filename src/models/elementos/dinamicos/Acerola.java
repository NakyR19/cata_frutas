package models.elementos.dinamicos;

/**
 * representa a fruta Acerola, fruta sem efeito.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Acerola extends Fruta{

    /**
     * Construtor para a classe Acerola.
     * Inicializa a fruta com suas coordenadas, chance de ser bichada e define o tipo como "Acerola".
     *
     * @param x A coordenada x da Acerola.
     * @param y A coordenada y da Acerola.
     * @param chanceBichada A chance da Acerola estar bichada em porcentagem
     */
    public Acerola(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        this.TipoFruta = "Acerola";

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da Acerola ao jogador.
     * Neste caso, a Acerola não possui nenhum efeito.
     * se estiver bichada o player fica envenenado.
     *
     * @param p O jogador ao qual o efeito será aplicado.
     */
    @Override
    public void aplicarEfeito(Player player) {
        if(!this.Bichada){
            System.out.println(player.getId() + " comeu uma acerola.");
         } else {
             player.setPoison(true);
             System.out.println(player.getId() + " comeu uma fruta bichada e está envenenado!");
         }
    }

    /**
     * Método para mover a Acerola.
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


