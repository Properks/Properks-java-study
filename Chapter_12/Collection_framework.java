package Chapter_12;

/**
 * Collection_framework
 */
public class Collection_framework {

    public static void main(String[] args) {
        
        Map<String, Integer> map = new Map<>();

        Pair<String, Integer> P = new Pair<>("John", 13);

        map.setKeyBValue(P);
        map.setKeyBValue("Jack", 32);
        map.setKeyBValue("Amy", 14);
        map.setKeyBValue("David", 28);

        map.showInfo();
        map.processOfFind("John");; // Can find Key in map
        
        map.setKeyBValue("John", 23);
        map.showInfo();
        map.processOfFind("John"); // After change

        map.findValue("Joh"); // Can't find Key in map
    }
}