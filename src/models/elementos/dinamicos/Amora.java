package models.elementos.dinamicos;

/**
 * representa a fruta Amora, fruta sem efeito.
 * Esta classe herda de Fruta e implementa os métodos abstratos definidos na classe mãe.
 * 
 * @author Gustavo Assunção
 */
public class Amora extends Fruta{

    private int chanceBichada;
    /**
     * Construtor para a classe Amora.
     * Inicializa a fruta com suas coordenadas, chance de ser bichada e define o tipo como "Amora".
     *
     * @param x A coordenada x da Amora.
     * @param y A coordenada y da Amora.
     * @param chanceBichada A chance da Amora estar bichada em porcentagem
     * 
     * @author Gustavo Assunção
     */
    public Amora(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        this.TipoFruta = "Amora";
        this.chanceBichada = chanceBichada;

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito da Amora ao jogador.
     * Neste caso, a Amora não possui nenhum efeito.
     * se estiver bichada o player fica envenenado.
     * Caso o jogador que comeu a fruta seja uma Cosplayer, da um efeito aleatório.
     *
     * @param p O jogador ao qual o efeito será aplicado.
     * 
     * @author Gustavo Assunção
     */
    @Override
    public void aplicarEfeito(Player player) {
        if(!this.Bichada){
            System.out.println(player.getId() + " comeu uma amora.");
         } else {
             player.setPoison(true);
             System.out.println(player.getId() + " comeu uma fruta bichada e está envenenado!");
         }

         if(player.getNome().equals("Cosplayer")){//da um efeito aleatorio de fruta se for cosplayer
            switch((int)(Math.random()*3 )){
                case 0:
                    System.out.println(this.TipoFruta + " fez cosplay de Coco!");
                    Coco coco = new Coco(x, y, chanceBichada);
                    coco.aplicarEfeito(player);
                    break;

                case 1:
                    System.out.println(this.TipoFruta + " fez cosplay de Laranja!");
                    Laranja laranja = new Laranja(x, y, chanceBichada);
                    laranja.aplicarEfeito(player);
                    break;

                case 2: 
                    System.out.println(this.TipoFruta + " fez cosplay de Abacate!");
                    Abacate abacate = new Abacate(x, y, chanceBichada);
                    abacate.aplicarEfeito(player);
                    break;

                default:
                    break;
            }
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

