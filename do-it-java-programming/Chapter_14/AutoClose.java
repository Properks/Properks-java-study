package Chapter_14;

/**
 * AutoClose
 */
public class AutoClose implements AutoCloseable{

    @Override
    public void close() throws java.lang.Exception {
        System.out.println("Close file successfully");
    }
}