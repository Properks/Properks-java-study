package Chapter_12;

/**
 * Collection_framework
 */
public class Collection_framework {

    public static void main(String[] args) {
        
        Map<String, Integer> map = new Map<>();

        Pair<String, Integer> P = new Pair<>("John", 13);
        // Pair<Integer, String> PPrime = new Pair<>(13,"John");
        map.setKeyBValue(P);
        map.setKeyBValue("Jack", 32);
        // map.setKeyBValue(PPrime); Has type error

        map.showInfo();
    }
}