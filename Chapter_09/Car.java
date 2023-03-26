package Chapter_09;

/**
 * Car
 */
public abstract class Car {
    public abstract void run();
    public abstract void refuel();
    public void stop() {
        System.out.println("Car is stop");
    }
}