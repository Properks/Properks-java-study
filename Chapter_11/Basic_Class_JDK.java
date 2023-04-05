package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) {
        
        Integer intValue = Integer.valueOf(42); // == Integer.parseInt("42"); like atoi(char* s);
        Integer sameIntValue = 42; //  If intValue = Integer.valueOf("42");, sameIntValue = Integer.valueOf("42"); Result is same
        Integer assignIntValue = intValue;

        System.out.println("==========Before modify intValue==========");
        System.out.println("intValue : " + intValue.intValue());
        System.out.println("sameIntValue : " + sameIntValue.intValue()); 
        System.out.println("assignIntValue : " + assignIntValue.intValue());
        
        intValue = 21;
        System.out.println("==========After modify intValue==========");
        System.out.println("intValue : " + intValue.intValue());
        System.out.println("sameIntValue : " + sameIntValue.intValue()); // Not Reference
        System.out.println("assignIntValue : " + assignIntValue.intValue()); // Not Reference
    }
}