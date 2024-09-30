package view.elementos;

import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;
import view.elementos.dinamico.PlayerComponent;
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
        if (elemento instanceof Grama) {
            return new GramaComponent((Grama) elemento);
        }
        if (elemento instanceof Pedra) {
            return new PedraComponent((Pedra) elemento);
        }
        if (elemento instanceof Player) {
            return new PlayerComponent((Player) elemento);
        }
        // ADICIONAR OS OUTROS ELEMENTOS
        return null;
    }
}
