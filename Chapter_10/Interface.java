package Chapter_10;

/**
 * Interface
 */
public class Interface {

    public static void main(String[] args) {
        Calculator Calcul = new Calculator();

        int num1 = 36;
        int num2 = 4;

        System.out.println("Add : " + Calcul.add(num1, num2));
        System.out.println("Substract : " + Calcul.substract(num1, num2));
        System.out.println("Times : " + Calcul.times(num1, num2));
        System.out.println("Divides : " + Calcul.divides(num1, num2));
        System.out.println("Divides with 0 : " + Calcul.divides(num1, 0));
    }
}