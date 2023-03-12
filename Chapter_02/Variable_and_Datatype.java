package Chapter_02;

/**
 * Variable_and_Datatype
 */
public class Variable_and_Datatype {

    public static void main(String[] args) {
        var it1 = 10; // Declare 'Local variable type inference'
        var DB1 = 12.345; // Warning : Only local variable, If you declare once(ex : var str = 1), Can't declare one more with another type(var str = 'A'; (X))
        var Ch1 = 'A';

        System.out.println(it1);
        System.out.println(DB1);
        System.out.println(Ch1);
    }
}