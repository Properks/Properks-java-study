package Chapter_08;

/**
 * Customer
 */
public class Customer {

    protected int customerID;
    protected String customerName;
    protected String customerGrade;
    protected int totalBought;
    int point;
    double bonusRatio;

    public Customer() {
        customerID = 0;
        customerName = "None";
        customerGrade = "Bronze"; // Rookie, Silver, Gold, Diamond, VIP, VVIP
        point = 0;
        bonusRatio = 0.0;
    }

    public Customer(int ID, String name) {
        this.customerID = ID;
        this.customerName = name;
        this.totalBought = 0;
        this.point = 0;
        setGrade();
        setPoint(0);
    }

    public void setGrade() {
        if (this.totalBought <= 2000) {
            this.customerGrade = "Rookie";
        }
        else if (this.totalBought < 10000) {
            this.customerGrade = "Silver";
        }
        else if (this.totalBought < 100000) {
            this.customerGrade = "Gold";
        }
        else if (this.totalBought < 200000) {
            this.customerGrade = "Diamond";
        }
        else if (this.totalBought < 500000) {
            this.customerGrade = "VIP";
        }
        else if (this.totalBought < 1000000) {
            this.customerGrade = "VIP";
        }
    }

    public int setPoint(int price) {
        return (int)(price * this.bonusRatio);
    }
}