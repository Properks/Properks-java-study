package Chapter_13.Lamda;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Lamda_Expression max = (x, y) -> (x >= y) ? x : y;

        System.out.println(max.getMax(20, 10));

        String_Concat cat = (x, y) -> {return x + ", " + y;};
        String Str1 = "Hello";
        String Str2 = "World";

        System.out.println(cat.concat(Str1, Str2));
    }
}