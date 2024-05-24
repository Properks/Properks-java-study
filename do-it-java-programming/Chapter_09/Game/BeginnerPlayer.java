package Chapter_09.Game;

/**
 * BeginnerPlayer
 */
public class BeginnerPlayer extends Playerlevel{

    public BeginnerPlayer() {
        name = "NONE";
        level = "Beginner";
    }
    public BeginnerPlayer(String name) {
        this.name = name;
        level = "Beginner";
    }
    @Override
    public void run() {
        System.out.println(name + " can run slowly");
    }

    @Override
    public void jump() {
        System.out.println(name + " can't jump");
    }

    @Override
    public void turn() {
        System.out.println(name + " can never jump");
    }
}