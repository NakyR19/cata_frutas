package models.elementos.dinamicos;

/**
 * representa a fruta Goiaba, fruta sem efeito.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author redbdb - Gustavo 
 */
public class Goiaba extends Fruta {

    /**
     * Construtor para a classe Goiaba.
     * Inicializa a fruta com suas coordenadas e define o tipo como "Goiaba".
     * Há uma chance de 10% da Goiaba ser bichada
     *
     * @param x A coordenada x da Goiaba.
     * @param y A coordenada y da Goiaba.
     * @param chanceBichada A chance da Goiaba estar bichada em porcentagem
     */
    public Goiaba(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        this.TipoFruta = "Goiaba";

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da Goiaba ao jogador.
     * Neste caso, a Goiaba não possui nenhum efeito.
     * se estiver bichada o player fica envenenado.
     *
     * @param p O jogador ao qual o efeito será aplicado.
     */
    @Override
    public void aplicarEfeito(Player player) {
        if(!this.Bichada){
            System.out.println(player.getId() + " comeu uma goiaba.");
         } else {
             player.setPoison(true);
             System.out.println(player.getId() + " comeu uma fruta bichada e está envenenado!");
         }
    }

    /**
     * Método para mover a Goiaba.
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
