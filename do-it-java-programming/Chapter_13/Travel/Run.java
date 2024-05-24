package Chapter_13.Travel;

import java.util.stream.Stream;
import java.util.ArrayList;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {

        int price = 300; // price per person
        int Totalprice = 0; // total price
        ArrayList<Traveler> listOfTraveler = new ArrayList<>();

        Traveler John = new Traveler("John", 23); // input privacy data
        Traveler Jack = new Traveler("Jack", 12);
        Traveler David = new Traveler("David", 17);
        Traveler Kane = new Traveler("Kane", 26);
        Traveler Emily = new Traveler("Emily", 31);
        Traveler Robert = new Traveler("Robert", 21);

        //add list
        listOfTraveler.add(John); // add to list
        listOfTraveler.add(Jack);
        listOfTraveler.add(David);
        listOfTraveler.add(Kane);
        listOfTraveler.add(Emily);
        listOfTraveler.add(Robert);

        // print
        Stream<String> name = listOfTraveler.stream().map(c -> c.getName()); // name list
        Totalprice = calculateTotalPrice(listOfTraveler, price);

        System.out.print("List : ");
        name.forEach(c -> System.out.print(c + ((c != listOfTraveler.get(listOfTraveler.size() - 1).getName()) ? ", " : ".")));
        System.out.println();
        System.out.println("Total price : $" + Totalprice);

        //Search
        search(listOfTraveler, "Jack"); // can find
        search(listOfTraveler, "Lay"); // Can't find
    }

    public static int calculateTotalPrice(ArrayList<Traveler> list, int price) {
        int totalPrice = 0;

        Stream<Traveler> calculatePrice = list.stream();
        totalPrice += calculatePrice.filter((c -> c.getAge() > 19)).count() * price;
        calculatePrice = list.stream();
        totalPrice += calculatePrice.filter((c -> c.getAge() <= 19)).count() * price * 0.8;

        return totalPrice;
    }

    public static Traveler forSearch(ArrayList<Traveler> list, String name) { // find and return class. I divide search system two function in order to use other function
        for (Traveler traveler : list) {
            if (traveler.getName() == name) {
                return traveler;
            }
        }
        return null;
    }

    public static void search(ArrayList<Traveler> list, String name) { // find and print
        Traveler temp;
        if ((temp = forSearch(list, name)) != null) {
            System.out.println(temp);
        }
        else {
            System.out.println("Can't find " + name);
        }
    }
}