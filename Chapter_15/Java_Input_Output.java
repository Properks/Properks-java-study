package Chapter_15;

import java.io.Console;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        Console Inputconsole = System.console();
        String buffer = Inputconsole.readLine();
        File Filename = new File("Chapter_15/" + buffer);
        
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(Filename))) { // InputStreamReader read it with character data form, FileInputStream read it with byte type
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}