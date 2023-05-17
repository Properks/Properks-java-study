package Chapter_15;

import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        Console Inputconsole = System.console();
        String buffer = Inputconsole.readLine();
        File Filename = new File("Chapter_15/" + buffer);
        
        try (FileReader reader = new FileReader(Filename)) {
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char)i);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}