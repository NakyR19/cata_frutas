package models.ambiente;

/**
 * Classe que representa os dados do jogo
 * 
 * @author Gustavo Assunção
 */
public class Dado {
    
    /**
     * gera dois numeros aleatórios entre 1 e 6, simbolizando 2 dados.
     * 
     * @return  um inteiro entre 2 e 12, a soma de dois dados de 6.
     * 
     * @author Gustavo Assunção
     */
    public int rolarDoisDados(){// rola dois dados q retornam um numero inteiro entre 2 - 12
        return (int)(Math.random()*(6) + 1) + (int)(Math.random()*(6) + 1);
    }
}
