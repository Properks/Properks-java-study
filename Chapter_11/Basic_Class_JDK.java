package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) throws ClassNotFoundException{
        
        Integer intValue = Integer.valueOf(42);
        
        Class<?> c = intValue.getClass();
        System.out.println("c : " + c);
        
        c = Integer.class;
        System.out.println("c : " + c);
        
        c = Class.forName("java.lang.Integer");
        System.out.println("c : " + c);
    }
}