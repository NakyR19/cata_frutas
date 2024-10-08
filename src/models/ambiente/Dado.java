package models.ambiente;

public class Dado {
    
    public int rolarDoisDados(){// rola dois dados q retornam um numero inteiro entre 2 - 12
        return (int)(Math.random()*(6) + 1) + (int)(Math.random()*(6) + 1);
    }
}
