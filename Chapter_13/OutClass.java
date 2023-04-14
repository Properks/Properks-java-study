package Chapter_13;

/**
 * OutClass
 */
public class OutClass {

    private int number1 = 10;
    private static int number2 = 20;

    InnerClass inclass;
    public OutClass() {
        inclass = new InnerClass();
    }

    public void addition() {
        inclass.sumNumbers();
        System.out.println(inclass.innerNumber1); // Can access private variable in innerclass
    }
    /**
     * InnerOutClass
     */
    public class InnerClass {
    
        private int innerNumber1 = number1 + number2;
        // static innerNumber2; // Error : Innerclass have to create after creating outclass. So, static has error
        final String str = "Innerclass is created"; // Can use final (constant)

        public InnerClass() {
            System.out.println(str);
        }
        void sumNumbers() {
            System.out.println(number1 + " + " + number2 + " = " + innerNumber1); // Can access value is in outclass
        }
    }
}