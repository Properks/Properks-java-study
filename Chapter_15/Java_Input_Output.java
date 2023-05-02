package Chapter_15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {
        // READ BYTE
        // FileInputStream
        // FileOutputStream
        // BufferedInputStream
        // BufferedOutputStream

        // READ CHARACTER
        // FileReader
        // FileWriter
        // BufferedReader
        // BufferedWriter
        int i;
        System.out.println("Enter one character");

        try {
            i = System.in.read(); // Read 1 byte with read()
            System.out.println("Entered character : " + (char)i); // If don't use (char), print ASCII code.
        } catch (IOException e) { // for exception
            e.printStackTrace();
        }

        System.out.println("Enter a word");

        try {
            // i = System.in.read(); // for printing "Entered word : "
            // System.out.print("Entered word : ");
            // do {
            //     System.out.print((char)i);
            // } while ((i = System.in.read()) != -1);
            while ((i = System.in.read()) != -1) { // input with while
                System.out.print((char)i);
            }
            
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}