package Chapter_13.Stream;

import Chapter_12.Collection.*;
import Chapter_12.Collection.List.Arraylist;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Run
 */
/**
 * ComapareString
 */
class ComapareString implements BinaryOperator<Member> {

    @Override
    public Member apply(Member s1, Member s2) {
        if (s1.getMemberID() > s2.getMemberID()) {
            return s1;
        }
        else {
            return s2;
        }
    }
}

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

        stream = list.stream();
        System.out.println("===============================");
        Member identity = new Member(null, 0); // For identity in reduce()
        Member latestMember = stream.reduce(identity, (s1, s2) -> { // reduece have single result
            if (s1.getMemberID() > s2.getMemberID()) {
                return s1;
            } 
            else {
                return s2;
            }
        });
        System.out.println("The latest Member is " + latestMember);
            
        stream = list.stream();
        System.out.println("===============================");
        System.out.println("The same way : " +stream.reduce(identity, new ComapareString())); // Use Binaryoperator

    }
}