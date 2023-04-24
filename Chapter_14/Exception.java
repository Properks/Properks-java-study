package Chapter_14;

/**
 * Exception
 */
public class Exception {

    // FileNotFoundException
    // SocketException
    // ArithmeticException
    // IndexOutOfBoundsException
    public static void main(String[] args) {

        AutoClose test = new AutoClose();

        try (test) {
            
        } catch (java.lang.Exception e) {
            System.out.println("Run");
        }
        System.out.println("\nMake new exception=====================");
        try (test) {
            throw new java.lang.Exception();
        } catch (java.lang.Exception e) {
            System.out.println("Run");
        }
    }
}