package Chapter_09.Game;

/**
 * BeginnerPlayer
 */
public class BeginnerPlayer extends Playerlevel{

    public BeginnerPlayer() {
        level = "Beginner";
    }
    @Override
    public void run() {
        System.out.println("You can run slowly");
    }

    @Override
    public void jump() {
        System.out.println("You can't jump");
    }

    @Override
    public void turn() {
        System.out.println("You can never jump");
    }
}