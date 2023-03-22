package Chapter_07;

/**
 * Array
 */
public class Array {

    public static void main(String[] args) {
        Book[] library = new Book[5];

        library[0] = new Book("It starts with us", "Colleen Hoover", "N001"); // N001 -> novel 1st
        library[1] = new Book("It ends with us", "Colleen Hoover", "N002");
        library[2] = new Book("Never Never : A twist, angsty romance", "Colleen Hoover, Tarryn Fisher", "N003");
        library[3] = new Book("Worthy Opponents", "Danielle Steel", "N004");
        library[4] = new Book("All about love", "Bell Hooks", "V001"); // v -> vision

        for (int i = 0; i < library.length; i++) { // Check whether each book's place is same or not
            for (int j = i + 1; j < library.length; j++) {
                if (library[i].place == library[j].place) {
                    System.out.println("Library error!! " + library[i].getName() + "\'s place is same as " + library[j].getName());
                    return;
                }

            }
        }

        System.out.println("=======Search book=======");
        searchPage(library, "Colleen Hoover"); // search author
        searchPage(library, "love"); // search a part of name of book
        searchPage(library, "All of "); // search wrong
        System.out.println("=======Search author=======");
        searchAuthor(library, "It");
        searchAuthor(library, "for");
    }
    public static void searchPage(Book[] library, String argument) {
        String temp; // Save string, return value
        int count = 0; // In order to print, If can't find argument in library.
        System.out.println("Result : ");
        for (int i = 0; i < library.length; i++) { // Check all library
            temp = library[i].searchBook(argument);
            if (temp != null) { // If temp isn't null, return string
                System.out.println(temp);
            }
            else {
                count++;
            }
        }
        if (count == library.length) {
            System.out.println("Can't find " + "\"" + argument + "\"" + " in library");
        }
    }

    public static void searchAuthor(Book[] library, String name) {
        String temp; // Save string, return value
        int count = 0; // In order to print, If can't find books that contains argument in library.
        for (int i = 0; i < library.length; i++) {
            temp = library[i].searchAuthor(name);
            if (temp != null) {
                System.out.println(temp);
            }
            else {
                count++;
            }
        }
        if (count == library.length) {
            System.out.println("Can't find book that contains " +"\"" + name + "\"");
        }
    }
}