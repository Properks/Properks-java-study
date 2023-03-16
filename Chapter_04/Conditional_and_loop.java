package Chapter_04;

/**
 * Conditional_and_loop
 */
public class Conditional_and_loop {

    public static void main(String[] args) {
        int sum = 1, num = 2;

        while(sum % 50 != 0)
        {
            sum += num;
            num++;
        }
        System.out.println(sum);
    }
}