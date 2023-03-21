package Chapter_06;

/**
 * Bus
 */
public class Bus {

    int numberOfPassenger;
    int money;

    public Bus() {
        numberOfPassenger = 0;
        money = 0;
    }

    public void plusMoney(int money) {
        this.money += money;
    }

    public void plusPassenger() {
        this.numberOfPassenger++;
    }

    public void showInfo() {
        System.out.println(this.getClass().getName() + " has " + numberOfPassenger +" Passengers.");
        System.out.println(this.getClass().getName() + " earn " + money);
    }
}