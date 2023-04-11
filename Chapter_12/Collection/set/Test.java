package Chapter_12.Collection.set;

import java.util.HashSet;
/**
 * HashSetTest
 */
public class Test {

    public static void main(String[] args) {
        
        HashSet<String> Hashset = new HashSet<String>();
    
        Hashset.add("John");
        Hashset.add("Jack");
        Hashset.add("David");
        Hashset.add("Emily");
        Hashset.add("Emily"); // If it is in Set already, Doesn't add it.

        System.out.println(Hashset); // Print element randomly.
    }

}// make a hashset with add