package Chapter_09;

/**
 * AutoCar
 */
public class AutoCar extends Car{
    
    @Override
    public void refuel() {
        System.out.println("Autocar is filling up the natural gas"); 
    }

    @Override
    public void drive() {
        System.out.println("AutoCar goes to somewhere");
    }

    public void load() {
        System.out.println("Autocar load up the burden");
    }
    
}