package Chapter_14;

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

        ThrowException test = new ThrowException();
        try {
            test.loadFile("a.txt", "java.lang.String");
            System.out.println("Didn't run");
        } catch (FileNotFoundException | ClassNotFoundException e) { // like if statement
            System.out.println(e);
        } catch (java.lang.Exception e) { // like else statement
            System.out.println(e);
        }
        System.out.println("Run");
    }
}