package Chapter_09.Game;

/**
 * AdvancedPlayer
 */
public class AdvancedPlayer extends Playerlevel{

    public AdvancedPlayer() {
        name = "NONE";
        level = "Advanced";
    }
    public AdvancedPlayer(String name) {
        this.name = name;
        level = "Advanced";
    }
    @Override
    public void run() {
        System.out.println(name + " can run very fast as like light");
    }

    @Override
    public void jump() {
        System.out.println(name + " can jump highly");
    }

    @Override
    public void turn() {
        System.out.println(name + " can turn");
    }
}