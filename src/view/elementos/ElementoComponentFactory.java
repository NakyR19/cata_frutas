package view.elementos;

import models.elementos.Elemento;
import models.elementos.estaticos.Grama;
import view.elementos.estatico.GramaComponent;
import java.awt.Graphics;

public class ElementoComponentFactory {
    public static ElementoComponent criarComponente(Elemento elemento) {
        if (elemento instanceof Grama) {
            return new GramaComponent((Grama) elemento);
        }
        // ADICIONAR OS OUTROS ELEMENTOS
        return null; // Retorna nulo SE NÃO encontrar um componente para o elemento
    }
}
