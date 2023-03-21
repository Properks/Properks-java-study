package Chapter_06;

/**
 * Class_and_Object_2
 */
public class Class_and_Object_2 {

    public static void main(String[] args) {
        Person John = new Person("John", 17, 8000);
        Person Amy = new Person("Amy", 21, 12000);
        Person Jack = new Person("Jack", 23, 1000);

        Bus _7016 = new Bus();
        Bus _1711 = new Bus();
        Bus _506 = new Bus();


        John.takeBus(_7016);
        Amy.takeBus(_1711);
        Jack.takeBus(_506);

        John.showInfo();
        Amy.showInfo();
        Jack.showInfo();

        _7016.showInfo();
        _1711.showInfo();
        _506.showInfo();
    }
}