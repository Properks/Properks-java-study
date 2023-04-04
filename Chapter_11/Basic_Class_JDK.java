package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) {
        
        Book Book1 = new Book("It starts with us", "Colleen Hoover", 336);
        Book Book2 = Book1;
        Book Book3 = new Book("It starts with us", "Colleen Hoover", 336);

        if (Book1 == Book2) {
            System.out.println("Book2's address is same as book1's");
        }
        else {
            System.out.println("Book2's address isn't same as book1's");
        }
        if (Book1.equals(Book2)) {
            System.out.println("Book2's body is same as book1's");
        }
        else {
            System.out.println("Book2's body isn't same as book1's");
        }

        if (Book1 == Book3) {
            System.out.println("Book2's address is same as book1's");
        }
        else {
            System.out.println("Book2's address isn't same as book1's");
        }
        if (Book1.equals(Book3)) {
            System.out.println("Book2's body is same as book1's"); // If i use overriding equal function.
        }
        else {
            System.out.println("Book2's body isn't same as book1's"); // If i don't use overriding equal function.
        }
    }
}