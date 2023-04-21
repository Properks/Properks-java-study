package Chapter_13.Travel;

import java.util.stream.Stream;
import java.util.ArrayList;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {

        int price = 300;
        int Totalprice = 0;
        ArrayList<Traveler> listOfTraveler = new ArrayList<>();

        Traveler John = new Traveler("John", 23);
        Traveler Jack = new Traveler("Jack", 12);
        Traveler David = new Traveler("David", 17);
        Traveler Kane = new Traveler("Kane", 26);
        Traveler Emily = new Traveler("Emily", 31);
        Traveler Robert = new Traveler("Robert", 21);

        listOfTraveler.add(John);
        listOfTraveler.add(Jack);
        listOfTraveler.add(David);
        listOfTraveler.add(Kane);
        listOfTraveler.add(Emily);
        listOfTraveler.add(Robert);

        Stream<String> name = listOfTraveler.stream().map(c -> c.getName());
        Totalprice = calculateTotalPrice(listOfTraveler, price);

        System.out.print("List : ");
        name.forEach(c -> System.out.print(c + ((c != listOfTraveler.get(listOfTraveler.size() - 1).getName()) ? ", " : ".")));
        System.out.println();
        System.out.println("Total price : $" + Totalprice);
    }

    public static int calculateTotalPrice(ArrayList<Traveler> list, int price) {
        int totalPrice = 0;

        Stream<Traveler> calculatePrice = list.stream();
        totalPrice += calculatePrice.filter((c -> c.getAge() > 19)).count() * price;
        calculatePrice = list.stream();
        totalPrice += calculatePrice.filter((c -> c.getAge() <= 19)).count() * price * 0.8;

        return totalPrice;
    }

}