package Chapter_04;

/**
 * Conditional_and_loop
 */
public class Conditional_and_loop {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            int count = 0;
            if(i == 1 || i ==2 || i == 3)
            {
                System.out.print(i);
                System.out.println("is prime number");
            }
            else
            {
                for (int j = 2; j <= i/2; j++) {
                    if (i % j == 0) {
                        System.out.print(i);
                        System.out.println("isn't prime number");
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    System.out.print(i);
                    System.out.println("is prime number");
                }
            }           
        }
    }
}