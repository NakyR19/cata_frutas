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
     * @param chanceBichada A chance do coco estar bichado em porcentagem
     */
    public Coco(int x, int y, int chanceBichada) {
       super(x, y, chanceBichada);
        TipoFruta = "Coco";
        
        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }
    /**
     * Aplica o efeito de agilidade ao jogador, dobrando o número de pontos de movimento em uma rodada.
     *
     * @param p o jogador que receberá o efeito.
     * @todo Implementar a lógica para dobrar os pontos de movimento do jogador.
     *
     */
    @Override
       public void aplicarEfeito(Player player){
            // Dobrar o número de pontos de movimento de uma rodada
            if( !this.Bichada){
                System.out.println(player.getId() + " comeu um coco. ");
            }else{ 
                player.setPoison(true);
                System.out.println(player.getId() + " comeu um coco e tá ruinzinho!");
            }
            player.setPontosMovimento(player.getPontosMovimento()*2);
            System.out.println(player.getId() + " está com mais agilidade.");
            return;
 }
    @Override
    public void mover(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }
}
