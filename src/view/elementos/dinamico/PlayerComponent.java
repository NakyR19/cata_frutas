package view.elementos.dinamico;

import view.elementos.ElementoComponent;
import models.elementos.dinamicos.Player;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * PlayerComponent é um componente visual que lida com a imagem do jogador e seu
 * desenho na tela.
 * Ela herda de ElementoComponent.
 * 
 * @author NakyR19 - Rafael
 */
public class PlayerComponent extends ElementoComponent {
    /**
     * Atributos: Player
     */
    private Player player;
    private Image imagemPlayer;
    private int animationIndex = 0;
    private ImageIcon[][] characterAnimations = {
        {
                new ImageIcon(getClass().getResource("/res/images/malandro_0.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_1.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_3.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_4.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_5.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_7.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_8.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_9.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_11.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_12.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_13.png")),
                new ImageIcon(getClass().getResource("/res/images/malandro_15.png")),
        },
        {
            new ImageIcon(getClass().getResource("/res/images/ajudante0.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante1.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante3.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante4.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante5.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante7.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante8.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante9.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante11.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante12.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante13.png")),
            new ImageIcon(getClass().getResource("/res/images/ajudante15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/ash0.png")),
            new ImageIcon(getClass().getResource("/res/images/ash1.png")),
            new ImageIcon(getClass().getResource("/res/images/ash3.png")),
            new ImageIcon(getClass().getResource("/res/images/ash4.png")),
            new ImageIcon(getClass().getResource("/res/images/ash5.png")),
            new ImageIcon(getClass().getResource("/res/images/ash7.png")),
            new ImageIcon(getClass().getResource("/res/images/ash8.png")),
            new ImageIcon(getClass().getResource("/res/images/ash9.png")),
            new ImageIcon(getClass().getResource("/res/images/ash11.png")),
            new ImageIcon(getClass().getResource("/res/images/ash12.png")),
            new ImageIcon(getClass().getResource("/res/images/ash13.png")),
            new ImageIcon(getClass().getResource("/res/images/ash15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/cosplayer0.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer1.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer3.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer4.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer5.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer7.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer8.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer9.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer11.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer12.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer13.png")),
            new ImageIcon(getClass().getResource("/res/images/cosplayer15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_0.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_1.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_3.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_4.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_5.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_7.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_8.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_9.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_11.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_12.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_13.png")),
            new ImageIcon(getClass().getResource("/res/images/mariaChiquinha_15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/enzo0.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo1.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo3.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo4.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo5.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo7.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo8.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo9.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo11.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo12.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo13.png")),
            new ImageIcon(getClass().getResource("/res/images/enzo15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/praiana0.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana1.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana3.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana4.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana5.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana7.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana8.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana9.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana11.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana12.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana13.png")),
            new ImageIcon(getClass().getResource("/res/images/praiana15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/ametista0.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista1.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista3.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista4.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista5.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista7.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista8.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista9.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista11.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista12.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista13.png")),
            new ImageIcon(getClass().getResource("/res/images/ametista15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/fadinha0.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha1.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha3.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha4.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha5.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha7.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha8.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha9.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha11.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha12.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha13.png")),
            new ImageIcon(getClass().getResource("/res/images/fadinha15.png")),

        },
        {
            new ImageIcon(getClass().getResource("/res/images/cullen0.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen1.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen3.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen4.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen5.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen7.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen8.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen9.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen11.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen12.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen13.png")),
            new ImageIcon(getClass().getResource("/res/images/cullen15.png")),

        },
};


    /**
     * Construtor
     *
     * @param p o jogador a ser associado a este componente
     *          OBS.: FUTURAMENTE ADICIONAR PARAMETRO PARA RECEBER IMAGEM CONFORME
     *          MOVIMENTAÇÃO DO PLAYER
     *          Atribuição da referência de imagem a imagemPlayer
     */
    public PlayerComponent(Player p) {
        this.player = p;
        p.setPlayerComponent(this);
        ImageIcon referencia = characterAnimations[getImageByPlayer()][0];
        imagemPlayer = referencia.getImage();
    }

    /**
     * Desenha a imagem do jogador na posição especificada com o tamanho de célula
     * especificado.
     *
     * @param g        o objeto Graphics a ser usado para desenhar
     * @param x        a coordenada x em que irá ser desenhada a imagem
     * @param y        a coordenada y a qual irá ser desenhada a imagem
     * @param cellSize o tamanho da célula a qual a imagem será desenhada
     */

    public int getImageByPlayer() {
        switch (player.getNome()) {
            case "Malandro":
                return 0;
            case "Ajudante do Papai Noel":
                return 1;
            case "Ash Ketchup":
                return 2;
            case "Cosplayer":
                return 3;
            case "Maria Chiquinha":
                return 4;
            case "Enzo Gabriel":
                return 5;
            case "Praiana":
                return 6;
            case "Ametista":
                return 7;
            case "Fadinha":
                return 8;
            case "Edgreen Cullen":
                return 9;
            default:
                break;
        }
        return -1;
    }

    public Image getImagemPlayer() {
        return imagemPlayer;
    }

    @Override
    public void desenhar(Graphics g, int x, int y, int cellSize) {
        g.drawImage(imagemPlayer, x, y, cellSize, cellSize, null);
    }

    public void updateAnimation() {
        int directionOffset = 0;
        switch (player.getDirecaoAtual()) {
            case "baixo":
                directionOffset = 0; // Frames de idx 0 a 2
                break;
            case "esquerda":
                directionOffset = 3; // Frames de idx 3 a 5
                break;
            case "direita":
                directionOffset = 6; // Frames de idx 6 a 8
                break;
            case "cima":
                directionOffset = 9; // Frames de idx 9 a 11
                break;
        }
        animationIndex = (animationIndex + 1) % 3; // 3 frames por direção
        imagemPlayer = characterAnimations[getImageByPlayer()][directionOffset + animationIndex].getImage();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
