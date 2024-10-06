package models.elementos.dinamicos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.Jogo;


// classe para testar a implementação de uma fruta
public class Frutinha extends Fruta implements KeyListener{
    
    private Player player;
    private Jogo jogo;
    private int useKey;

    public Frutinha(int x, int y, Player player, int useKey) {
        super(x, y);
        // 20% de chance de ser bichado
        if ((int)(Math.random() * 100 + 1) > 20) {
            this.Bichada = false;
        } else {
            this.Bichada = true;
        }
        this.player = player;
        this.useKey = useKey;
    }

    // adiciona três pontos de movimento ao player
    @Override
    public void aplicarEfeito() {
        player.setPontosMovimento(player.getPontosMovimento() + 3);
        jogo.atualizarTurnoLabel();
    }
    //ignorar, talvez tirar 
    @Override
    public void mover(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == useKey) {
            aplicarEfeito();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
