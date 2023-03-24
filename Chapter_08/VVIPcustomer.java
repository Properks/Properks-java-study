package Chapter_08;

/**
 * VVIPcustomer
 */
public class VVIPcustomer extends Customer{

    protected int agentID;
    double saleBonus = 0.2;

    public VVIPcustomer(Customer name, int number) {
        this.customerName = name.customerName;
        this.customerID = name.customerID;
        this.customerGrade = "VVIP";
        this.point = name.point;
        this.totalBought = name.totalBought;
        this.bonusRatio = 0.1;
        this.agentID = number;
    }

    public int getAgentID() { // it is similar with ranking
        return this.agentID;
    }

    public void buySomething(int price) {
        this.totalBought += price - (price * saleBonus);
        this.point += setPoint(price); // plus point
        setGrade(); // set grade automatically after buying
    }
}