package Chapter_12.Collection.map;

import Chapter_12.Collection.Member;
/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        
        Hashmap map = new Hashmap();
    
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);
        Member Trace = new Member("Trace", 20201195);
    
        System.out.println("\nAdd in Map============================");
    
        map.addMember(John);
        map.addMember(Jack);
        map.addMember(David);
        map.addMember(Kane);
        map.addMember(Emily);
        map.addMember(Robert);
        map.addMember(Emily); // If it is in Map already, Doesn't add it.
        map.addMember(Trace);

        System.out.println("\nMap===================================");
        map.showInfo();
        
        System.out.println("\nRemove in Map============================");
        map.removeMember("John");
        map.removeMember(20201191); // Jack
        map.removeMember(20201190); // John
        map.showInfo();
        
        System.out.println("\nSearch in Map============================");
        search(map, "Kane");
        System.out.println("\nSearch anyone who is not in Map============================");
        search(map, "John");

    }
    public static void search(Hashmap map, String name) {
        Member temp;
        if ((temp = map.searchID(name)) != null) {
            System.out.println(temp);
            return;
        }
        else {
            System.out.println("ERROR : Can't find " + name);
            return;
        }
    }

}