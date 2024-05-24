package Chapter_08;

import java.util.ArrayList;


/**
 * Inheritance_and_variation
 */
public class Inheritance_and_variation {
    
    private static ArrayList<Customer> listCustomer = new ArrayList<Customer>();
    private static ArrayList<VVIPcustomer> listVVIP = new ArrayList<VVIPcustomer>(); // list of VVIP
    public static void main(String[] args) {
        Customer John = new Customer(202310001, "John"); // Declare customer
        Customer Amy = new Customer(202310002, "Amy");
        Customer Jack = new Customer(202310003, "Jack");


        listCustomer.add(John); // TODO: When new customer come in, add in 'listcustomer' automatically
        listCustomer.add(Amy);
        listCustomer.add(Jack);

        System.out.println("=======Amy=======");
        Amy = buyProcess(Amy, 130000);
        Amy.showInfo();

        Amy = buyProcess(Amy, 500000);
        Amy.showInfo();

        System.out.println("=======John=======");
        John = buyProcess(John, 2560000); // In order to show VVIP
        John.showInfo();

        John = buyProcess(John, 1000000); //buySomething in buyProcess is VVIPcustomer's method
        John.showInfo();

        System.out.println(John.getTotal()); // Show whether sale applies to Customer John or not

        System.out.println("=======Jack=======");
        Jack = buyProcess(Jack, 3200000);
        Jack = buyProcess(Jack, 1000000);
        Jack.showInfo();
        System.out.println(Jack.getTotal());
    
        System.out.println("=====Customer list====="); // Print VVIP list
        printList(listCustomer);
    }

    public static Customer buyProcess(Customer name, int price) {
        name.buySomething(price);
        if (name instanceof Customer) { // If instance type is VVIPcustomer(), Doesn't execute
            if (name.getGrade() == "VVIP") { // If customer is VVIP and not in listVVIP, insert in listVVIP and redifined with VVIPcustomer constructor for using its method
                int index = listCustomer.indexOf(name);
                listVVIP.add(new VVIPcustomer(name, listVVIP.size() + 1));
                name = new VVIPcustomer(name, listVVIP.size());
                listCustomer.set(index, name); // refer again. If i didn't do, It is no longer updated
            }
            return name;
        }
        else{
            return name;
        }
    }
    // TODO: Fucntion that sort ArrayList

    public static void printList(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " : " + list.get(i).customerName + "(" + list.get(i).getGrade() + ")" + " : " + list.get(i).totalBought);
        }
    }
}