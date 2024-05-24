package Chapter_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ThrowException
 */
public class ThrowException {

    /**
     * loadFile
     */
    public Class loadFile(String filename, String classname) throws FileNotFoundException, ClassNotFoundException {
    
        FileInputStream fis = new FileInputStream(filename);
        Class c = Class.forName(classname);
        return c;
    }
}