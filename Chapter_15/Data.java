package Chapter_15;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Data {
    
    private DataOutputStream dataOutput; 
    private FileOutputStream fileOutput;
    private Queue<Consumer<DataInputStream>> functionQueue = new LinkedList<>();

    FileInputStream fileInput;
    DataInputStream dataInput;

    public Data(File filename) {
        try {
            fileOutput = new FileOutputStream(filename);
            dataOutput = new DataOutputStream(fileOutput);
            fileInput = new FileInputStream(filename);
            dataInput = new DataInputStream(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
   
    public Data(String filePath) {
        try {
            fileOutput = new FileOutputStream(filePath);
            dataOutput = new DataOutputStream(fileOutput);
            fileInput = new FileInputStream(filePath);
            dataInput = new DataInputStream(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    

    public void writeData(Byte Input) {
        try {
            dataOutput.writeByte(Input);
            functionQueue.add(stream -> {
                try {
                    byte data = stream.readByte();
                    System.out.print(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }});
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }
    }

    public void writeData(char Input) {
        try {
            dataOutput.writeChar(Input);
            functionQueue.add(stream -> {try {
                char data = stream.readChar();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }});
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }

    public void writeData(int Input) {
        try {
            dataOutput.writeInt(Input);
            functionQueue.add(stream -> {try {
                int data = stream.readInt();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }});
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }      
    }

    public void writeData(String Input) {
        try {
            dataOutput.writeUTF(Input);
            functionQueue.add(out-> {try {
                String data = out.readUTF();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }});
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }

    public void writeData(Float Input) {
        try {
            dataOutput.writeFloat(Input);
            functionQueue.add(out -> {try {
                float data = out.readFloat();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }});
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Initialize Stream with constructor plz");
        }       
    }

    void Output() {
        while (!functionQueue.isEmpty()) {
            Consumer<DataInputStream> function = functionQueue.poll();
            function.accept(dataInput);
        }
    }
}
