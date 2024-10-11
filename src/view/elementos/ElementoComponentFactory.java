package view.elementos;

import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Arvore;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Maracuja;
import view.elementos.dinamico.LaranjaComponent;
import view.elementos.dinamico.MaracujaComponent;
import view.elementos.dinamico.PlayerComponent;
import view.elementos.estatico.ArvoreComponent;
import view.elementos.estatico.GramaComponent;
import view.elementos.estatico.PedraComponent;

/**
 * A classe ElementoComponentFactory é uma fábrica para criar componentes gráficos para diferentes tipos de elementos do jogo.
 * @author NakyR19 - Rafael
 */
public class ElementoComponentFactory {
     /**
     * Cria um componente gráfico para o elemento fornecido.
     *
     * @param elemento O elemento para o qual o componente gráfico será criado.
     * @return O componente gráfico correspondente ao elemento, ou null se o elemento não for reconhecido.
     */
    public static ElementoComponent criarComponente(Elemento elemento) {
        if (elemento instanceof Grama grama) {
            return new GramaComponent(grama);
        }
        if (elemento instanceof Pedra pedra) {
            return new PedraComponent(pedra);
        }
        if (elemento instanceof Player player) {
            return new PlayerComponent(player);
        }
        if(elemento instanceof Arvore arvore){
            return new ArvoreComponent(arvore);
        }
        if (elemento instanceof Laranja laranja){
            return new LaranjaComponent(laranja);
        }
        if (elemento instanceof Maracuja maracuja){
            return new MaracujaComponent(maracuja);
        }
        // ADICIONAR OS OUTROS ELEMENTOS
        return null;
    }
}
