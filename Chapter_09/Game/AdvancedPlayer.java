package Chapter_09.Game;

/**
 * AdvancedPlayer
 */
public class AdvancedPlayer extends Playerlevel{

    public AdvancedPlayer() {
        level = "Advanced";
    }
    @Override
    public void run() {
        System.out.println("You can run very fast as like light");
    }

    @Override
    public void jump() {
        System.out.println("You can jump highly");
    }

    @Override
    public void turn() {
        System.out.println("You can turn");
    }
}