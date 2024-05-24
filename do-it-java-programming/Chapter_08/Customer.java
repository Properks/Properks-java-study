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
    }

    public void setGrade() { // Set grade according to total amount
        if (this.totalBought < 100000) {
            this.customerGrade = "Rookie"; // 0 ~ 99,999
            this.bonusRatio = 0.0;
        }
        else if (this.totalBought < 200000) { // 100,000 ~ 199,999
            this.customerGrade = "Silver";
            this.bonusRatio = 0.02;
        }
        else if (this.totalBought < 500000) { // 200,000 ~ 499,999
            this.customerGrade = "Gold";
            this.bonusRatio = 0.03;
        }
        else if (this.totalBought < 1000000) { // 500,000 ~ 999,999
            this.customerGrade = "Diamond";
            this.bonusRatio = 0.04;
        }
        else if (this.totalBought < 2000000) { // 1,000,000 ~ 2,000,000
            this.customerGrade = "VIP";
            this.bonusRatio = 0.07;
        }
        else if (this.totalBought >= 2000000) { // 2,000,000 ~
            this.customerGrade = "VVIP";
            this.bonusRatio = 0.1;
        }
    }

    public int setPoint(int price) {
        return (int)(price * this.bonusRatio);
    }

    public void buySomething(int price) {
        this.totalBought += price;
        this.point += setPoint(price); // plus point
        setGrade(); // set grade automatically after buying
    }
    public void buySomething(int price, int point) {
        this.totalBought += (price - point);
        setGrade();
    }

    public String getGrade() {
        return customerGrade;
    }

    public int getID() {
        return customerID;
    }
    public int getTotal() {
        return totalBought;
    }

    public void showInfo() {
        System.out.println("Name : " + customerName + "(" + customerID + ")");
        System.out.println("Grade : " + customerGrade);
        System.out.println("Point : " + point);
    }
}