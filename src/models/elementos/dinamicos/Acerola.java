package models.elementos.dinamicos;

/**
 * representa a fruta Acerola, fruta sem efeito.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Acerola extends Fruta{

    /**
     * Construtor para a classe Acerola.
     * Inicializa a fruta com suas coordenadas e define o tipo como "Acerola".
     * Há uma chance de 10% da Acerola ser bichada
     *
     * @param x A coordenada x da Acerola.
     * @param y A coordenada y da Acerola.
     */
    public Acerola(int x, int y) {
        super(x, y);
        this.TipoFruta = "Acerola";

        // 10% de chance de ser bichada
        if ((int)(Math.random() * 100 + 1) > 10) {
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


