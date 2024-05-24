package Chapter_14;

/**
 * Exception
 */
public class Exception_handling { // Rename for extends exception

    // FileNotFoundException
    // SocketException
    // ArithmeticException
    // IndexOutOfBoundsException
    public static void main(String[] args) {

        String ID = null; 
        IDException test = new IDException();

        try {
            test.check(ID);
        } catch (IDFormatException e) {
            e.printStackTrace();
        }
    }
}