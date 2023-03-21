package Chapter_06;

/**
 * Bus
 */
public class Bus {
    int numberOfBus;
    int numberOfPassenger;
    int money;
    int[] fee = new int[3]; // 0 : adult fee, 1 : teenager fee, 2 : child fee

    public Bus() {
        numberOfPassenger = 0;
        money = 0;
        fee = new int[] {0,0,0};
    }
    public Bus(int busNumber, int adult, int teenager, int child) {
        this.numberOfBus = busNumber;
        fee[0] = adult;
        fee[1] = teenager;
        fee[2] = child;
    }

    public void plusMoney(int money) {
        this.money += money;
    }

    public void plusPassenger() {
        this.numberOfPassenger++;
    }

    public void showInfo() {
        System.out.println(this.numberOfBus + " has " + numberOfPassenger +" Passengers.");
        System.out.println(this.numberOfBus + " earn " + money);
    }
}