package Chapter_12;

import java.util.ArrayList;

/**
 * Map
 */
public class Map<T, E> extends Pair<T, E>{

    ArrayList<Pair<T, E>> map = new ArrayList<>();

    public void setKeyBValue(Pair<T, E> p) {
        map.add(p);
    }

    public void setKeyBValue(T Key, E value) {
        Pair<T, E> p = new Pair<T, E>(Key, value);
        map.add(p);
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