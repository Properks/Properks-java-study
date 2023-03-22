package Chapter_07;

/**
 * Book
 */
public class Book {

    private String nameOfBook;
    private String author;
    private String place;

    public Book() { // Basic constructor.
        nameOfBook = "Default";
        author = "Default";
        place = "A000";
    }

    public Book(String name, String author, String place) { // Constructor with data.
        this.nameOfBook = name;
        this.author = author;
        this.place = place;
    }

    public String searchBook(String name) {
        if (this.nameOfBook.contains(name)) { // Whether name of book contains argument or not.
            return "Name : " + this.nameOfBook + ", Author : " + this.author + ", Place : " + this.place;
        }
        else if (this.author.contains(name)) { // Whether author contains argument or not.
            return "Name : " + this.nameOfBook + ", Author : " + this.author + ", Place : " + this.place;
        }
        else { // If name has been contained in both nameOfBook and Author, will return null.
            return null;
        }
    }

    public String searchAuthor(String name) {
        if (this.nameOfBook.contains(name)) { // If name of book contains name, will return author
            return this.nameOfBook + "\'s Author : " + this.author;
        }
        else {
            return null;
        }
    }
}