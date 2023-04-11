package Chapter_12.Collection.List;

import Chapter_12.Collection.*;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Arraylist list = new Arraylist();
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        System.out.println("Remove when nothing is in list=====================");
        remove(list, Emily);
        System.out.println("Add in list============================");
        
        list.addMember(John);
        list.addMember(Jack);
        list.addMember(David);
        list.addMember(Kane);
        list.addMember(Emily);
        list.addMember(Robert);
        
        System.out.println("Arraylist===================================");
        list.showAllMember();
        
        System.out.println("Remove in Arraylist============================");
        remove(list, John);
        
        System.out.println("Stack===================================");
        list.showAllMember();
    }

    public static void remove(Arraylist list, Member M) {
        if (list.removeMember(M)) {
            System.out.println("Remove " + M.getName());
        }
        else {
            System.out.println("Can't find " + M.getName());
        }
    }

    public static void remove(Arraylist list, String name) {
        if (list.removeMember(name)) {
            System.out.println("Remove " + name);
        }
        else {
            System.out.println("Can't find " + name);
        }
    }
}