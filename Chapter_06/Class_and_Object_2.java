package Chapter_06;

/**
 * Class_and_Object_2
 */
public class Class_and_Object_2 {

    public static void main(String[] args) {
        Person noName = new Person();
        Person Amy = new Person("Amy", 21);

        noName.printData();
        Amy.printData();
    }
}