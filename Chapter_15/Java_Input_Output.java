package Chapter_15;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {

        File filename = new File("Chapter_15/Input.txt");
        try (FileOutputStream fileOutput = new FileOutputStream(filename); // DataInput or Outputstream read data with binary tpye
            DataOutputStream dataOutput = new DataOutputStream(fileOutput)) {
            dataOutput.writeByte(100);
            dataOutput.writeChar('A');
            dataOutput.writeInt(10);
            dataOutput.writeFloat(3.14f);
            dataOutput.writeUTF("Test");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInput = new FileInputStream(filename);
            DataInputStream dataInput = new DataInputStream(fileInput)) {
            System.out.println(dataInput.readByte());
            System.out.println(dataInput.readChar());
            System.out.println(dataInput.readInt());
            System.out.println(dataInput.readFloat());
            System.out.println(dataInput.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}