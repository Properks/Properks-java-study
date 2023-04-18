package Chapter_13.Lamda;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Lamda_Expression max = (x, y) -> (x >= y) ? x : y;

        System.out.println(max.getMax(20, 10));
    }
}