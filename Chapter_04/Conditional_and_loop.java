package Chapter_04;

/**
 * Conditional_and_loop
 */
public class Conditional_and_loop {

    public static void main(String[] args) {
        char gender = 'F';

        if(gender == 'F' || gender == 'f')
        {
            System.out.println("She is a woman");
        }
        else if (gender == 'M' || gender == 'm')
        {
            System.out.println("He is a man");
        }
        else
        {
            System.out.println("Input error!!");
        }
    }
}