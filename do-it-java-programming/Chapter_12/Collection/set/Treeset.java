package Chapter_12.Collection.set;

import java.util.Iterator;
import java.util.TreeSet;
import Chapter_12.Collection.Member;

/**
 * Treeset
 */
public class Treeset {

    TreeSet<Member> treeSet;

    public Treeset() {
        treeSet = new TreeSet<>();
    }

    public void addMember(Member M) {
        treeSet.add(M);
    }

    public boolean removeMember(String name) {
        Iterator<Member> ir = treeSet.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                treeSet.remove(temp);
                return true;
            }
        }
        return false;
    }

    public int searchID(String name) {
        Iterator<Member> ir = treeSet.iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                return temp.getMemberID();
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return treeSet.toString();
    }
}