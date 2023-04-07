package Chapter_12;

import java.util.ArrayList;

/**
 * Map
 */
public class Map<T, E> extends Pair<T, E>{

    ArrayList<Pair<T, E>> map = new ArrayList<>();

    public void setKeyBValue(Pair<T, E> p) {
        for (int i = 0; i < map.size(); i++) {
            if (p.key == map.get(i).key) {
                map.get(i).value = p.value;
                return;
            }
        }
        map.add(p);
    }

    public void setKeyBValue(T Key, E value) {
        Pair<T, E> p = new Pair<T, E>(Key, value);
        for (int i = 0; i < map.size(); i++) {
            if (p.key == map.get(i).key) {
                map.get(i).value = p.value;
                return;
            }
        }
        map.add(p);
    }

    public E findValue(T source) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).key == source) {
                return map.get(i).getValue();
            }
        }
        return null;
    }

    public void processOfFind(T source) {
        E temp;
        if ((temp = this.findValue(source)) == null) {
            System.err.println("Can\'t find " + source);
        }
        else {
            System.out.println("John is " + temp + " years old");
        }
    }

    public void showInfo() {
        for (int i = 0; i < map.size(); i++) {
            if (i == map.size() - 1) {
                System.out.println("{" + map.get(i).key + ", " + map.get(i).value + "}");
            }
            else {
                System.out.print("{" + map.get(i).key + ", " + map.get(i).value + "}, ");
            }
        }
    }
}