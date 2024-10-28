package models.elementos.dinamicos;
import javax.swing.JOptionPane;

/**
 * representa a fruta laranja, fruta antidoto no jogo.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * @author Gustavo Assunção 
 */
public class Laranja extends Fruta {

    /**
     * Construtor para a classe Laranja.
     * Inicializa a fruta com suas coordenadas e define o tipo como "Laranja".
     * Há uma chance de 10% da laranja ser bichada
     *
     * @param x A coordenada x da laranja.
     * @param y A coordenada y da laranja.
     * @param chanceBichada A chance da Laranja estar bichada em porcentagem
     * 
     * @author Gustavo Assunção
     */
    public Laranja(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        this.TipoFruta = "Laranja";

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da laranja ao jogador.
     * Neste caso, o efeito é um antídoto que remove o envenenamento do jogador.
     * se estiver bichado não acontece nada
     *
     * @param p O jogador ao qual o efeito será aplicado.
     * 
     * @author Gustavo Assunção
     */
    @Override
    public void aplicarEfeito(Player player){
        if(!this.Bichada){
            player.setPoison(false);
            System.out.println(player.getId() + " comeu uma laranja e se sente saudável!");
            JOptionPane.showMessageDialog(null, "O player está se sentido o Dráuzio Varella!\nSua saúde voltou ao ingerir 10 comprimidos de vitamina C... Digo, ao comer a laranja!", "Laranja", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        System.out.println(player.getId() + " comeu uma laranja mas sentiu que não fez efeito...");  
    }
}