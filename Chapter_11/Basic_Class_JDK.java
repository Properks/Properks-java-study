package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) {
        
        Book Book1 = new Book("It starts with us", "Colleen Hoover", 336, 1101100);
        Book Book2 = Book1;
        Book Book3 = new Book("It starts with us", "Colleen Hoover", 336, 1101101);

        System.out.println("=======Reference=======");
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

        System.out.println("=======New but same name=======");
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
        System.out.println("=======hashcode=======");
        System.out.println(Book1.hashCode()); // overriding. will return bookID
        if (Book1.hashCode() == Book2.hashCode()) {
            System.out.println("Book1 has same code with Book2");
        }
        else {
            System.out.println("Book1 doesn't have same code with Book2");
        }
        if (Book1.hashCode() == Book3.hashCode()) {
            System.out.println("Book1 has same code with Book3");
        }
        else {
            System.out.println("Book1 doesn't have same code with Book3");
        }
        
    }
}