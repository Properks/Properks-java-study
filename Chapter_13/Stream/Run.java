package Chapter_13.Stream;

import Chapter_12.Collection.*;
import Chapter_12.Collection.List.Arraylist;
import java.util.stream.Stream;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        
        Arraylist list = new Arraylist(); // Use arraylist in collection in Ch12
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        list.addMember(John);
        list.addMember(Jack);
        list.addMember(David);
        list.addMember(Kane);
        list.addMember(Emily);
        list.addMember(Robert);

        Stream<Member> stream = list.stream();
        System.out.println("===============================");
        stream.map(c -> c.getName()).forEach(i -> System.out.println(i)); // Print name with map

        stream = list.stream(); // After using terminal operation
        System.out.println("===============================");
        System.out.println(stream.filter(c -> c.getName().contains("J")).count()); // Print count of name constains "J"
        
        stream = list.stream();
        System.out.println("===============================");
        stream.filter(c -> c.getName().contains("J")).forEach(i -> System.out.println(i.getName())); // Print name constains "J"
    }
}