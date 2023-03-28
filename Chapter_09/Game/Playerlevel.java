package Chapter_09.Game;

/**
 * Playerlevel
 */
public abstract class Playerlevel{

    protected String name;
    protected String level;

    public abstract void run();
    public abstract void jump();
    public abstract void turn();

    final public void Action(int count) {
        if (level == "Beginner") {
            System.out.println("====" + name + "(" + level + ")" + "====");
            for (int i = 0; i < count; i++) {
                run();
                jump();
                turn();
            }
        }
        if (level == "Middle") {
            System.out.println("====" + name + "(" + level + ")" + "====");
            for (int i = 0; i < count; i++) {
                run();
                jump();
                turn();
            }
        }
        if (level == "Advanced") {
            System.out.println("====" + name + "(" + level + ")" + "====");
            for (int i = 0; i < count; i++) {
                run();
                jump();
                turn();
            }
        }
    }
}