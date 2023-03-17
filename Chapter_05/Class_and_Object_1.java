package Chapter_05;

/**
 * Class_and_Object_1
 */
public class Class_and_Object_1 {

    public static void main(String[] args) {
        int number = 5;
        int expo = 0;
        expo = exponent(number);
        System.out.println(expo);
    }

    public static int exponent(int num) {
        return (num * num);
    }
}