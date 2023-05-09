package Chapter_15;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        FileInputStream filestream = null;
        int i; // input 
        try {
            filestream = new FileInputStream("Chapter_15/Input.txt"); // print word
            System.out.println("Word : ");
            while ((i = filestream.read()) != ' ') {
                System.out.print((char)i);
            }
            System.out.println();
            System.out.println();
            
            System.out.println("Sentence : ");
            filestream.close();
            filestream = new FileInputStream("Chapter_15/Input.txt"); // print sentence

            while ((i = filestream.read()) != '\n' && i != '.' && i != '?' && i != '!') {
                System.out.print((char)i);
            }
            System.out.println();
            System.out.println();
            
            System.out.println("All : ");
            filestream.close();
            filestream = new FileInputStream("Chapter_15/Input.txt"); // print all
            
            while ((i = filestream.read()) != -1) {
                System.out.print((char)i);
            }
            System.out.println();
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}