package view.elementos;

import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;
import view.elementos.dinamico.PlayerComponent;
import view.elementos.estatico.GramaComponent;
import view.elementos.estatico.PedraComponent;


public class ElementoComponentFactory {
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
        return null; // Retorna nulo SE NÃO encontrar um componente para o elemento
    }
}
