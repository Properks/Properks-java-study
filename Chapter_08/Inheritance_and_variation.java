package Chapter_08;

import java.util.ArrayList;

/**
 * Inheritance_and_variation
 */
public class Inheritance_and_variation {

    public static void main(String[] args) {
        ArrayList<VVIPcustomer> listVVIP = new ArrayList<VVIPcustomer>();

        Customer John = new Customer(202310001, "John");
        Customer Amy = new Customer(202310002, "Amy");

        System.out.println("=======Amy=======");
        buyProcess(listVVIP, Amy, 130000);
        Amy.showInfo();

        buyProcess(listVVIP, Amy, 500000);
        Amy.showInfo();

        System.out.println("=======John=======");
        buyProcess(listVVIP, John, 2560000);
        John.showInfo();

        System.out.println("=====VVIP list=====");
        System.out.println(listVVIP.get(0).getAgentID() + " : " + listVVIP.get(0).customerName);
    }

    public static void buyProcess(ArrayList<VVIPcustomer> listVVIP, Customer name, int price) {
        name.buySomething(price);
        if (name.getGrade() == "VVIP") {
            listVVIP.add(new VVIPcustomer(name, listVVIP.size() + 1));
        }
        else{
            return;
        }
    }
}