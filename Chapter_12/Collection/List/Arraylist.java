package Chapter_12.Collection.List;

import java.util.ArrayList;
import Chapter_12.Collection.Member;

/**
 * Arraylist
 */
public class Arraylist {

    private ArrayList<Member> memberList;

    public Arraylist() {
        memberList = new ArrayList<>();
    }

    public void addMember(Member m) {
        memberList.add(m);
    }

    public void addMember(String name, int memberID) {
        Member temp = new Member(name, memberID);
        memberList.add(temp);
    }

    public void removeMember(Member m) {
        memberList.remove(m);
    }

    public void removeMember(String name) {
        int temp = -1;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getName() == name) {
                temp = i;
            }
        }
        if (temp == -1) {
            System.err.println("Can't find " + name + " in Array");
            return;
        }
        else {
            memberList.remove(temp);
        }
    }

    public void showAllMember() {
        System.out.println("Memeber in Array=============================");
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i));
        }
        System.out.println("=============================================");
    }
}