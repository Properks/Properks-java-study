package Chapter_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Exception
 */
public class Exception {

    // FileNotFoundException
    // SocketException
    // ArithmeticException
    // IndexOutOfBoundsException
    public static void main(String[] args) {

        FileInputStream file = null;
        try {
            file = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println(e);
            return;
        }
        finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) { // It doesn't run
                    System.out.println(e);
                }
            }
            System.out.println("Run this in finally"); // Print it regardless of whether return statement in catch run or not
        }
        System.out.println("Run this in main and out of try"); //Cannot run if catch run.
    }
}