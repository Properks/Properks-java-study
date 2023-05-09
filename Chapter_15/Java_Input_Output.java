package Chapter_15;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        FileInputStream filestream = null;

        try {
            filestream = new FileInputStream("Chapter_15/Input.txt");
            System.out.println((char)filestream.read());
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}