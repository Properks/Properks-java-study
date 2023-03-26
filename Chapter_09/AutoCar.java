package Chapter_09;

/**
 * AutoCar
 */
public class AutoCar extends Car{

    public void run() {
        System.out.println("Autocar is running");
    }

    public void refuel() {
        System.out.println("Autocar is filling up the natural gas"); 
    }

    public void load() {
        System.out.println("Autocar load up the burden");
    }
    
}