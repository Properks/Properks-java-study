package Chapter_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Exception
 */
public class Exception {

    // FileNotFoundException
    // SocketException
    // ArithmeticException
    // IndexOutOfBoundsException
    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // System.out.println(e);
            return;
        }
    }
}