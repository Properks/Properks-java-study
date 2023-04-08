package Chapter_12.Collection.List;

import Chapter_12.Collection.*;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Arraylist listOfMember = new Arraylist();
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        listOfMember.addMember(John);
        listOfMember.addMember(Jack);
        listOfMember.addMember(David);
        listOfMember.addMember(Kane);
        listOfMember.addMember(Emily);
        listOfMember.addMember(Robert);

        listOfMember.showAllMember();

        listOfMember.removeMember("Dave");
        listOfMember.removeMember("Emily");
        listOfMember.removeMember(David);

        listOfMember.showAllMember();

    }
}