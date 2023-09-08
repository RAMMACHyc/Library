package interfaces;

import classes.Book;

import java.util.List;

public interface IBook {
    void add(Book book);
    boolean update(Book book);
    boolean delete(int isbn);
    List<Book> showStatistics();

    List<Book> show();
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);



}
