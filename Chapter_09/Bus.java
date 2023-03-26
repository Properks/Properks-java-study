package Chapter_09;

/**
 * Bus
 */
public class Bus extends Car{

    public void takePassenger() {
        System.out.println("A passenger take a bus");
    }

    public void run() {
        System.out.println("Bus is running");
    }

    public void refuel() {
        System.out.println("Bus is filling up the gas");
    }
}