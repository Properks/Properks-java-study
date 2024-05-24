package Chapter_14.Exception_number;

/**
 * Between1_100
 */
public class Between1_100 {

    int number;
    public Between1_100(int number) throws NumberOutOfRangeException {
        if (number < 1 || number > 100) {
            throw new NumberOutOfRangeException("This number is over 100 or less than 1");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}