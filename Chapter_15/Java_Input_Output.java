package Chapter_15;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        File file = new File("Chapter_15/Input.txt");
        int i = 65;
        try (FileOutputStream output = new FileOutputStream(file)) {
            for (int j = 0; j < 3; j++) {
                output.write(i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileOutputStream appendFileOutputStream = new FileOutputStream(file, true)) {
            for (int j = 0; j < 3; j++) {
                appendFileOutputStream.write(i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Print success");
    }
}