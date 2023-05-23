package Chapter_15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        long second = 0;
        
        try (FileInputStream basefile = new FileInputStream("Chapter_15/base.zip");
        FileOutputStream duplicatedFile = new FileOutputStream("Chapter_15/copy.zip")) { // InputStreamReader read it with character data form, FileInputStream read it with byte type
            second = System.currentTimeMillis();
            int i;
            while ((i = basefile.read()) != -1) {
                duplicatedFile.write(i);
            }
            second = System.currentTimeMillis() - second;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Time : " + second); // print about 899

       try (FileInputStream basefile = new FileInputStream("Chapter_15/base.zip");
        FileOutputStream duplicatedFile = new FileOutputStream("Chapter_15/copy.zip")) { // InputStreamReader read it with character data form, FileInputStream read it with byte type
            BufferedInputStream base = new BufferedInputStream(basefile);
            BufferedOutputStream duplicate = new BufferedOutputStream(duplicatedFile);
            second = System.currentTimeMillis();
            int i;
            while ((i = base.read()) != -1) {
                duplicate.write(i);
            }
            second = System.currentTimeMillis() - second;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Time : " + second); // print about 26
    }
}