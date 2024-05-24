package Chapter_12.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import Chapter_12.Collection.Member;

/**
 * Arraylist
 */
public class Arraylist {

    private ArrayList<Member> memberList;

    public Arraylist() {
        memberList = new ArrayList<>();
    }

    public Stream<Member> stream() {
        Stream<Member> tempStream = memberList.stream();
        return tempStream;
    }

    public void addMember(Member m) {
        memberList.add(m);
    }

    public void addMember(String name, int memberID) {
        Member temp = new Member(name, memberID);
        memberList.add(temp);
    }

    public boolean removeMember(Member m) {
        Iterator<Member> ir = memberList.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == m.getName()) {
                memberList.remove(m);
                return true;
            }
        }
        return false;
    }

    public boolean removeMember(String name) { // modify code with iterator, without get(int)
        Iterator<Member> ir = memberList.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                memberList.remove(temp);
                return true;
            }
        }
        return false;
    }

    public void showAllMember() {
        System.out.println("Memeber in Array=============================");
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i));
        }
        System.out.println("=============================================");
    }
}