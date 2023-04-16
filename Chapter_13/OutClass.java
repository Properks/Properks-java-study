package Chapter_13;

/**
 * OutClass
 */
public class OutClass {

    private int number1 = 10;
    static int number2 = 20;

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


    static public class InStaticClass {
    
        int innerNumber1 = 80;
        static int instaticnum = 100;
        final String str = "InStaticclass is created"; // Can use final (constant)

        public InStaticClass() {
            System.out.println(str);
        }
        void sumNumbers() {
            System.out.println(number2 + " + " + innerNumber1 + " = " + instaticnum); // Can't use non-staticvalue in outer class
        }
        static void sumNumbers2() {
            System.out.println(number2 + " + " + 80 + " = " + instaticnum); // Can't use number1 because 
        } // Can't use non-static variable in innerclass

        // The reason why you cannot access non-static members of the outer class directly from a static inner class is because the non-static members of the outer class are associated with a specific instance of the outer class, and you cannot reference them without an instance of the outer class.
    }

    Runnable getRunnable() {    
        int varinMethod = 111;

        return new Runnable() { // Anonymous class
            int varInClass = 222;
        
            @Override
            public void run() {
                System.out.println("Run=====================");
                System.out.println("Variable in method : " + varinMethod);
                System.out.println("Variable in class : " + varInClass);
                System.out.println("Variable in Outter class : " + number1);
                System.out.println("Static variable in Outter class : " + number2);
                System.out.println("Static variable in Static inner class : " + InStaticClass.instaticnum);
                System.out.println("End=====================");
            }
        };
    }
    Runnable Runner = new Runnable() { // another type of Anonymous class
        int varinMethod = 111;
        int varInClass = 222;
        
        @Override
        public void run() {
            System.out.println("Run=====================");
            System.out.println("Variable in method : " + varinMethod);
            System.out.println("Variable in class : " + varInClass);
            System.out.println("Variable in Outter class : " + number1);
            System.out.println("Static variable in Outter class : " + number2);
            System.out.println("Static variable in Static inner class : " + InStaticClass.instaticnum);
            System.out.println("End=====================");
        }
    };
}