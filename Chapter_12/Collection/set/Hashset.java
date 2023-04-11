package Chapter_12.Collection.set;

import java.util.HashSet;
import java.util.Iterator;
import Chapter_12.Collection.Member;

/**
 * Hashset
 */
public class Hashset {

    private HashSet<Member> set;

    public Hashset() {
        set = new HashSet<>();
    }

    public void addMember(Member M) {
        set.add(M);
    }

    public void addMember(String name, int ID) {
        set.add(new Member(name, ID));
    }

    public boolean removeMember(String name) {
        Iterator<Member> ir = set.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                set.remove(temp);
                return true;
            }
        }
        return false;
    }

    public boolean removeMember(Member M) {
        Iterator<Member> ir = set.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == M.getName()) {
                set.remove(temp);
                return true;
            }
        }
        return false;
    }

    public int searchID(String name) {
        Iterator<Member> ir = set.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                return temp.getMemberID();
            }
        }
        return -1;
    }

    public String toString() {
        return set.toString();
    }
}