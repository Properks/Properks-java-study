package Chapter_14.Exception_number;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        
        try {
            Between1_100 test = new Between1_100(51);
            System.out.println(test.getNumber());
            test = new Between1_100(101);
            System.out.println(test.getNumber());
        } catch (NumberOutOfRangeException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}