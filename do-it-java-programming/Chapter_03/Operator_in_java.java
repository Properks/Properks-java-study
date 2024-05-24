package Chapter_03;

/**
 * Operator_in_java
 */
public class Operator_in_java {

    public static void main(String[] args) {
        int mathscore = 92;
        int engscore = 87;
        boolean value;
        String str;

        int totalscore = mathscore + engscore;
        System.out.print("Average : ");
        System.out.println(totalscore/2);

        value = (mathscore > 90)||(engscore > 90);
        System.out.println(value);
        str = (value) ? "Reach your goal" : "Sorry, you don't reach a goal";
        System.out.println(str);
    }
}