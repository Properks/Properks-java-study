package Chapter_06;

/**
 * Class_and_Object_2
 */
public class Class_and_Object_2 {

    public static void main(String[] args) {
        Person noName = new Person("John", 17, 8000);
        Person Amy = new Person("Amy", 21, 12000);

        noName.takeBus();
        noName.showInfo();
        Amy.takeBus();
        Amy.showInfo();
    }
}