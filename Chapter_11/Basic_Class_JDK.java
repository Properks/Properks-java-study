package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) {
        
        Book Book1 = new Book("It starts with us", "Colleen Hoover", 336);

        
        System.out.println(Book1); // Result : Chapter_11.Book@(hashcode)
        System.out.println(Book1.toString()); // It is same as above code

        System.out.println(Book1.getClass().getName()); // Result : Chapter_11.Book
        System.out.println(Book1.getClass().getSimpleName()); // Result : Book

        String str = new String("Test string class in JDK");
        System.out.println(str);
    }
}