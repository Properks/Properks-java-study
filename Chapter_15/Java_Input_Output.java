package Chapter_15;

import java.io.File;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        File filename = new File("Chapter_15/Input.txt");
        Data DataWritestream = new Data(filename);

        DataWritestream.writeData(100);
        DataWritestream.writeData('A');
        DataWritestream.writeData(10);
        DataWritestream.writeData(3.14f);
        DataWritestream.writeData("Test");

    }
}