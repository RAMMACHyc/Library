package classes;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String status;

    public Book(int isbn, String title, String author, String status) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setStatus(status);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
