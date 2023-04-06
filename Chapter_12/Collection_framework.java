package Chapter_12;

/**
 * Collection_framework
 */
public class Collection_framework {

    public static void main(String[] args) {
        
        Pair<String, Integer> P = new Pair<String, Integer>("Number", 13);

        System.out.println("Value of P : " + P.getValue());
        P.set("John", 1102843);
        System.out.println("Value of P : " + P.getValue());
    }
}