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

        int[] arr = new int[5];

        try {
            for (int i = 0; i <= 5; i++) {
                arr[i] = i;
                
            }
            System.out.println("This doesn't work");
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("Exception handling");
        }
        System.out.println("System exit");
    }
}