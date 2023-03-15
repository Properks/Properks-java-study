package Chapter_04;

/**
 * Conditional_and_loop
 */
public class Conditional_and_loop {

    public static void main(String[] args) {
        String rank = "platinum";

        switch (rank) {
            case "bronze":
                System.out.println("Your ranking is bronze.");
                break;
            case "silver":
                System.out.println("Your ranking is silver.");
                break;
            case "gold":
                System.out.println("Your ranking is gold.");
                break;
            case "platinum":
                System.out.println("Your ranking is platinum.");
                break;
            case "diamond":
                System.out.println("Your ranking is diamond.");
                break;
            default:
                break;
        }        
    }
}