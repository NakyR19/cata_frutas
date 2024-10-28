package view.elementos;

import models.elementos.Elemento;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Arvore;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;
import models.elementos.dinamicos.Abacate;
import models.elementos.dinamicos.Acerola;
import models.elementos.dinamicos.Amora;
import models.elementos.dinamicos.Coco;
import models.elementos.dinamicos.Goiaba;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Maracuja;
import view.elementos.dinamico.AbacateComponent;
import view.elementos.dinamico.AcerolaComponent;
import view.elementos.dinamico.AmoraComponent;
import view.elementos.dinamico.CocoComponent;
import view.elementos.dinamico.GoiabaComponent;
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
     * 
     * @author NakyR19 - Rafael
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
        if(elemento instanceof Arvore){
            return new ArvoreComponent((Arvore) elemento);
        }
        if (elemento instanceof Laranja){
            return new LaranjaComponent((Laranja) elemento);
        }
        if (elemento instanceof Maracuja){
            return new MaracujaComponent((Maracuja) elemento);
        }
        if (elemento instanceof Abacate){
            return new AbacateComponent((Abacate) elemento);
        }
        if (elemento instanceof Acerola){
            return new AcerolaComponent((Acerola) elemento);
        }
        if (elemento instanceof Amora){
            return new AmoraComponent((Amora) elemento);
        }
        if (elemento instanceof Coco){
            return new CocoComponent((Coco) elemento);
        }
        if (elemento instanceof Goiaba){
            return new GoiabaComponent((Goiaba) elemento);
        }
        // ADICIONAR OS OUTROS ELEMENTOS
        return null;
    }
}
