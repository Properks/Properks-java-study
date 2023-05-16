package Chapter_15;

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        Console Inputconsole = System.console();
        String buffer = Inputconsole.readLine();
        File Filename = new File("Chapter_15/" + buffer);

        if (Filename.exists()) {
            System.err.println(Filename + " already exist");
            return;
        }
        try (FileWriter writer = new FileWriter(Filename)) {
            System.out.println("Success to make file");
            String c;
            while (true) {
                c = Inputconsole.readLine();
                if (c.equals(":wq")){
                    break;
                }
                writer.write(c + '\n');
            }
            System.out.println("Success Input");
        } catch (IOException e) {
            System.out.println(e + " : Can't make file as " + Filename);
        }
    }
}