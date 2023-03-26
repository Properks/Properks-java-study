package Chapter_09;

/**
 * Abstract_Class
 */
public class Abstract_Class {

    public static void main(String[] args) {
        Bus bus = new Bus();
        AutoCar auto = new AutoCar();

        System.out.println("====Bus====");
        bus.run();
        System.out.println("====Auto====");
        auto.run();
    }
}