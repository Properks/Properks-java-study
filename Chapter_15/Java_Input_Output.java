package Chapter_15;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        File file = new File("Chapter_15/Input.txt");
        byte[] alphabets = new byte[26];
        byte initialValue = 65;
        try (FileOutputStream output = new FileOutputStream(file)) {
            for (int i = 0; i < 26; i++) {
                alphabets[i] = initialValue++;
            }
            output.write(alphabets);
            output.write('\n');
        } catch (Exception e) {
            e.printStackTrace();
        }

        initialValue = 97;
        try (FileOutputStream appendFileOutputStream = new FileOutputStream(file, true)) {
            for (int i = 0; i < 26; i++) {
                alphabets[i] = initialValue++;
            }
            appendFileOutputStream.write(alphabets, 0, 13);
            appendFileOutputStream.write('\n');
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Print success");
    }
}