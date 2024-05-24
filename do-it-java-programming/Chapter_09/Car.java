package Chapter_09;

/**
 * Car
 */
public abstract class Car { // abstract classs
    public abstract void refuel(); // abstract method
    public abstract void drive();
    public void stop() {
        System.out.println("Car is stop");
    }

    public void turnOn() {
        System.out.println("The engine is on");
    }

    public void turnOff() {
        System.out.println("The engine is off");
    }

    final void run() { // template method. If you wirte final, Can't redefine it in derived class.
        turnOn();
        drive();
        stop();
        turnOff();
        refuel();
        turnOn();
        drive();
    }
}