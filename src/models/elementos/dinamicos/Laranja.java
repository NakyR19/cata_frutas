package models.elementos.dinamicos;

/**
 * representa a fruta laranja, fruta antidoto no jogo.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Laranja extends Fruta {

    /**
     * Construtor para a classe Laranja.
     * Inicializa a fruta com suas coordenadas e define o tipo como "Laranja".
     * Há uma chance de 10% da laranja ser bichada
     *
     * @param x A coordenada x da laranja.
     * @param y A coordenada y da laranja.
     */
    public Laranja(int x, int y) {
        super(x, y);
        this.TipoFruta = "Laranja";

        // 10% de chance de ser bichada
        if ((int)(Math.random() * 100 + 1) > 10) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da laranja ao jogador.
     * Neste caso, o efeito é um antídoto que remove o envenenamento do jogador.
     * se estiver bichado o player fica envenenado
     *
     * @param p O jogador ao qual o efeito será aplicado.
     */
    @Override
    public void aplicarEfeito(Player player){
        if(!this.Bichada){
           player.setPoison(false); 
           System.out.println(player.getId() + " comeu uma laranja e não está mais envenenado!");
        } else {
            player.setPoison(true);
            System.out.println(player.getId() + " comeu uma fruta bichada e está envenenado!");
        }
        
    }

    /**
     * Método para mover a laranja.
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