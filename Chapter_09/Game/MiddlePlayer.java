package Chapter_09.Game;

/**
 * MiddlePlayer
 */
public class MiddlePlayer extends Playerlevel{

    public MiddlePlayer() {
        level = "Middle";
    }
    @Override
    public void run() {
        System.out.println("You can run rapidly");
    }

    @Override
    public void jump() {
        System.out.println("You can jump");
    }

    @Override
    public void turn() {
        System.out.println("You can't turn");
    }    
}