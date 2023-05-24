package Chapter_15;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class Data {
    
    DataOutputStream dataOutput; 
    FileOutputStream fileOutput;

    public Data(File filename) {
        try {
            fileOutput = new FileOutputStream(filename);
            dataOutput = new DataOutputStream(fileOutput);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
   
    public Data(String filePath) {
        try {
            fileOutput = new FileOutputStream(filePath);
            dataOutput = new DataOutputStream(fileOutput);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    

    public void writeData(Byte Input) {
        try {
            dataOutput.writeByte(Input);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }
    }

    public void writeData(char Input) {
        try {
            dataOutput.writeChar(Input);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }

    public void writeData(int Input) {
        try {
            dataOutput.writeInt(Input);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }      
    }

    public void writeData(String Input) {
        try {
            dataOutput.writeUTF(Input);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }

    public void writeData(Float Input) {
        try {
            dataOutput.writeFloat(Input);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }
}
