package Chapter_13;

/**
 * Inner_Class
 */
public class Inner_Class {

    public static void main(String[] args) {
        OutClass test = new OutClass();
        test.addition();

        OutClass.InnerClass intest = test.new InnerClass(); // Can create innerclass. but, need instance of outclass
        intest.sumNumbers();
    }
}