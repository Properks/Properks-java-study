package Chapter_09.Game;

/**
 * Execute
 */
public class Execute {

    public static void main(String[] args) {
        BeginnerPlayer begginner = new BeginnerPlayer("John");
        MiddlePlayer middle = new MiddlePlayer("Jack");
        AdvancedPlayer advanced = new AdvancedPlayer("Crown");

        begginner.Action(1);
        middle.Action(2);
        advanced.Action(3);
    }
}