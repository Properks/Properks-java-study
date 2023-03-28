package Chapter_09.Game;

/**
 * MiddlePlayer
 */
public class MiddlePlayer extends Playerlevel{

    public MiddlePlayer() {
        name = "NONE";
        level = "Middle";
    }
    public MiddlePlayer(String name) {
        this.name = name;
        level = "Middle";
    }
    @Override
    public void run() {
        System.out.println(name + " can run rapidly");
    }

    @Override
    public void jump() {
        System.out.println(name + " can jump");
    }

    @Override
    public void turn() {
        System.out.println(name + " can't turn");
    }    
}