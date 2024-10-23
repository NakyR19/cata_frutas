package models.elementos.dinamicos;

/**
 * A classe Abacate representa uma fruta que, quando coletada, dobra a força do competidor.
 * É uma subclasse de {@link Fruta}.
 *
 * <p> O efeito da fruta Abacate é aumentar a força do jogador, dobrando sua capacidade de ataque ou defesa.</p>
 *
 * @author Maria Luíza Andrade
 */

public class Abacate extends Fruta{
    /**
     * Constrói um objeto Abacate com as coordenadas e propriedades especificadas.
     *
     * @param x a coordenada X do Abacate.
     * @param y a coordenada Y do Abacate.
     * @param chanceBichada A chance do Abacate estar bichado em porcentagem
     */
    public Abacate(int x, int y, int chanceBichada) {
        super(x, y, chanceBichada);
        TipoFruta = "Abacate";

        if ((int)(Math.random() * 100 + 1) > chanceBichada) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
    }

    /**
     * Aplica o efeito de força ao jogador, dobrando a força do competidor.
     *
     * @param p o jogador que receberá o efeito.
     * @todo Implementar a lógica para dobrar a força do jogador.
     */
    @Override
    public void aplicarEfeito(Player player){
        // Dobrar a força do competidor
        if( !this.Bichada){
            System.out.println(player.getId() + " comeu um abacate. ");
        }else{ 
            player.setPoison(true);
            System.out.println(player.getId() + " comeu um abacate e tá ruinzinho!");
        }
        // player.setForca(player.getForca()*2);
        System.out.println(player.getId() + " está com o dobro de força.");
        return;
    }

    @Override
    public void mover(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }
}