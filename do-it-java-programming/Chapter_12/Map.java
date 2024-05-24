package Chapter_12;

import java.util.ArrayList;

/**
 * Map
 */
public class Map<T, E> {

    ArrayList<Pair<T, E>> map = new ArrayList<>();

    public void setKeyBValue(Pair<T, E> p) { // Set with pair.
        for (int i = 0; i < map.size(); i++) { // Check whether key is already in map or not.
            if (p.key == map.get(i).key) {
                map.get(i).value = p.value;
                return;
            }
        }
        map.add(p); // Add it ArrayList called map.
    }

    public void setKeyBValue(T Key, E value) { // Set with Key and Value.
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
        for (int i = 0; i < map.size(); i++) { // Find key in map.
            if (map.get(i).key == source) {
                return map.get(i).getValue(); // return value if it find key in map.
            }
        }
        return null; // If it doesn't exist key in map.
    }

    public void processOfFind(T source) {
        E temp;
        if ((temp = this.findValue(source)) == null) { // If return value of findValue is null, print error message.
            System.err.println("Can\'t find " + source);
        }
        else {
            System.out.println("John is " + temp + " years old");
        }
    }

    public void showInfo() { // print map's data.
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