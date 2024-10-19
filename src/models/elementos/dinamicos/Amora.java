package models.elementos.dinamicos;

/**
 * representa a fruta Amora, fruta sem efeito.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Amora extends Fruta{

    /**
     * Construtor para a classe Amora.
     * Inicializa a fruta com suas coordenadas e define o tipo como "Amora".
     * Há uma chance de 10% da Amora ser bichada
     *
     * @param x A coordenada x da Amora.
     * @param y A coordenada y da Amora.
     */
    public Amora(int x, int y) {
        super(x, y);
        this.TipoFruta = "Amora";

        // 10% de chance de ser bichada
        if ((int)(Math.random() * 100 + 1) > 10) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da Amora ao jogador.
     * Neste caso, a Amora não possui nenhum efeito.
     * se estiver bichada o player fica envenenado.
     *
     * @param p O jogador ao qual o efeito será aplicado.
     */
    @Override
    public void aplicarEfeito(Player player) {
        if(!this.Bichada){
            System.out.println(player.getId() + " comeu uma amora.");
         } else {
             player.setPoison(true);
             System.out.println(player.getId() + " comeu uma fruta bichada e está envenenado!");
         }
    }

    /**
     * Método para mover a Amora.
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

