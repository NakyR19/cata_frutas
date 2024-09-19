package models.ambiente;

public class Dado {
    
    public int rolar(){//retorna um numero inteiro entre 1 - 6
        return (int)(Math.random()*(6) + 1);
    }
}
