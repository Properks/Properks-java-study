package Chapter_09;

/**
 * Bus
 */
public class Bus extends Car{

    @Override
    public void refuel() {
        System.out.println("Bus is filling up the gas");
    }

    @Override
    public void drive() {
        System.out.println("Bus goes to somewhere by shifting gears");
    }

    public void takePassenger() {
        System.out.println("A passenger take a bus");
    }
}