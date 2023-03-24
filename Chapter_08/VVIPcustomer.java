package Chapter_08;

/**
 * VVIPcustomer
 */
public class VVIPcustomer extends Customer{

    int agentID;
    double saleBonus = 0.2;

    public VVIPcustomer(Customer name) {
        this.customerName = name.customerName;
        this.customerID = name.customerID;
        this.customerGrade = "VVIP";
        this.point = name.point;
        this.totalBought = name.totalBought;
        this.bonusRatio = 0.1;
    }

    public int getAgentID() {
        return this.agentID;
    }
}