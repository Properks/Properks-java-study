package Chapter_11;

/**
 * Book
 */
public class Book implements Cloneable {
    private String title;
    private String author;
    private int numPages;
    private int bookID;

    public Book(String title, String author, int numPages, int bookID) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public String toString() { // overriding
        return title + "(" + author + ")";
    }

    public Boolean equals(Book anotherBook) { // overriding
        if (this.title == anotherBook.title && this.author == anotherBook.author && this.numPages == anotherBook.numPages) {
            return true;
        }
        else {
            return false;
        }
    }

    public int hashCode() { // overriding
        return bookID;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void printBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numPages);
    }
}
