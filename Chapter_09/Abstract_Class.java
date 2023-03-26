package Chapter_09;

/**
 * Abstract_Class
 */
public class Abstract_Class {

    public static void main(String[] args) {
        Bus bus = new Bus();
        AutoCar auto = new AutoCar();

        bus.run();
        auto.run();

        bus.refuel();
        auto.refuel();

        bus.takePassenger();
        auto.load();

        bus.stop();
        auto.stop();
    }
}