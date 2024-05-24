package Chapter_12.Collection.map;

import java.util.Iterator;
import java.util.TreeMap;
import Chapter_12.Collection.Member;

/**
 * Treemap
 */
public class Treemap {

    TreeMap<Integer, Member> map;

    public Treemap() {
        map = new TreeMap<>();
    }

    public void addMember(Member M) {
        if (map.isEmpty() == false) {
            Iterator<Integer> ir = map.keySet().iterator();
            while (ir.hasNext()) {
                int temp = ir.next();
                if (temp == M.getMemberID()) {
                    System.err.println(M.getMemberID() + " is already in map");
                    return;
                }
            }
        }
        map.put(M.getMemberID(), M);
    }

    public void removeMember(Member M) {
        if (map.containsValue(M)) {
            map.remove(M.getMemberID(), M);
        }
        else {
            System.err.println("ERROR : Can't find member");
        }
    }

    public void removeMember(String name) {
        Iterator<Member> ir = map.values().iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                map.remove(temp.getMemberID(), temp);
                return;
            }
        }
        System.err.println("ERROR : Can't find " + name);
    }

    public void removeMember(Integer Key) {
        if (map.containsKey(Key)) {
            map.remove(Key);
        }
        else {
            System.err.println("ERROR : Can't find " + Key);
        }
    }

    public Member searchID(String name) {
        Iterator<Member> ir = map.values().iterator();
        while (ir.hasNext()) {
            Member temp = ir.next();
            if (temp.getName() == name) {
                return temp;
            }
        }
        return null;
    }

    public void showInfo() {
        Iterator<Integer> ir= map.keySet().iterator();
        while (ir.hasNext()) {
            Integer key = ir.next();
            Member temp = map.get(key);
            System.out.println(temp);
        }
    }
}