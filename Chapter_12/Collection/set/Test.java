package Chapter_12.Collection.set;

import Chapter_12.Collection.Member;
/**
 * HashSetTest
 */
public class Test {

    public static void main(String[] args) {
        
        Hashset set = new Hashset();
    
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        System.out.println("\nAdd in Set============================");

        set.addMember(John);
        set.addMember(Jack);
        set.addMember(David);
        set.addMember(Kane);
        set.addMember(Emily);
        set.addMember(Robert);
        set.addMember(Emily); // If it is in Set already, Doesn't add it.


        System.out.println("\nSet===================================");
        System.out.println(set);
        
        System.out.println("\nRemove in Set============================");
        remove(set, John);
        System.out.println(set); // Print element randomly.
        
        System.out.println("\nSearch in Set============================");
        search(set, "Emily");
        System.out.println("\nSearch anything that is not in Set============================");
        search(set, "John");
    }

    public static void remove(Hashset list, Member M) {
        if (list.removeMember(M)) {
            System.out.println("Remove " + M.getName());
        }
        else {
            System.out.println("Can't find " + M.getName());
        }
    }

    public static void remove(Hashset list, String name) {
        if (list.removeMember(name)) {
            System.out.println("Remove " + name);
        }
        else {
            System.out.println("Can't find " + name);
        }
    }

    public static void search(Hashset set, String name) {
        int temp;
        if ((temp = set.searchID(name)) != -1) {
            System.out.println(name + "'s ID is " + temp);
            return;
        }
        else {
            System.out.println("ERROR : Can't find " + name);
            return;
        }
    }
}// make a hashset with add