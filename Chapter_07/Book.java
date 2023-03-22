package Chapter_07;

/**
 * Book
 */
public class Book {

    private String nameOfBook;
    private String author;
    private String place;

    public Book() {
        nameOfBook = "Default";
        author = "Default";
        place = "A000";
    }

    public Book(String name, String author, String place) {
        this.nameOfBook = name;
        this.author = author;
        this.place = place;
    }

    public String searchBook(String name) {
        if (this.nameOfBook == name) {
            return "Name : " + this.nameOfBook + ", Author : " + this.author + ", Place : " + this.place;
        }
        else if (this.author == name) {
            return "Name : " + this.nameOfBook + ", Author : " + this.author + ", Place : " + this.place;
        }
        else {
            return null;
        }
    }

    public String searchAuthor(String name) {
        if (this.nameOfBook == name) {
            return "Author : " + this.author;
        }
        else {
            return null;
        }
    }
}