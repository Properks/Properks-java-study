package Chapter_08;

import java.util.ArrayList;


/**
 * Inheritance_and_variation
 */
public class Inheritance_and_variation {

    public static void main(String[] args) {
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        ArrayList<VVIPcustomer> listVVIP = new ArrayList<VVIPcustomer>(); // list of VVIP

        Customer John = new Customer(202310001, "John"); // Declare customer
        Customer Amy = new Customer(202310002, "Amy");

        listCustomer.add(John);
        listCustomer.add(Amy);

        System.out.println("=======Amy=======");
        Amy = buyProcess(listVVIP, Amy, 130000);
        Amy.showInfo();

        Amy = buyProcess(listVVIP, Amy, 500000);
        Amy.showInfo();

        System.out.println("=======John=======");
        John = buyProcess(listVVIP, John, 2560000); // In order to show VVIP
        John.showInfo();

        John = buyProcess(listVVIP, John, 1000000); //buySomething in buyProcess is VVIPcustomer's method
        John.showInfo();
        System.out.println(John.getTotal()); // Show whether sale applies to Customer John or not
    
        System.out.println("=====Customer list====="); // Print VVIP list
        printList(listCustomer);
    }

    public static Customer buyProcess(ArrayList<VVIPcustomer> listVVIP, Customer name, int price) {
        name.buySomething(price);
        for (int i = 0; i < listVVIP.size(); i++) { // If Customer is in listVVIP, Do not anything
            if(listVVIP.get(i).getID() == name.getID()) {
                return name;
            }
        }
        if (name.getGrade() == "VVIP") { // If customer is VVIP and not in listVVIP, insert in listVVIP and redifined with VVIPcustomer constructor for using its method
            listVVIP.add(new VVIPcustomer(name, listVVIP.size() + 1));
            name = new VVIPcustomer(name, listVVIP.size());
            return name;
        }
        else{
            return name;
        }
    }
    // TODO: Fucntion that sort ArrayList

    public static void printList(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + list.get(i).customerName + "(" + list.get(i).getGrade() + ")" + " : " + list.get(i).totalBought);
        }
    }
}