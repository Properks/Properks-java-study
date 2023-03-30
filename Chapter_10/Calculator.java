package Chapter_10;

/**
 * Calculator
 */
public class Calculator implements Calculate{

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int substract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divides(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        }
        else {
            return ERROR;
        }
    }
}