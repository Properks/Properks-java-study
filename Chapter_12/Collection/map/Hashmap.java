package Chapter_12.Collection.map;

import java.util.HashMap;
import java.util.Iterator;

import Chapter_12.Collection.Member;

/**
 * Hashmap
 */
public class Hashmap {

    HashMap<Integer, Member> map;

    public Hashmap() {
        map = new HashMap<>();
    }

    public void addMember(Member M) {
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