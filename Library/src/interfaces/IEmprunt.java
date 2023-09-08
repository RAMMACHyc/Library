package interfaces;

import classes.Emprunt;
import classes.Book;
import classes.Emprunteur;

public interface IEmprunt {
    Emprunt borrow(Book book, Emprunteur emprunteur);

    Emprunt returnBook(Book book, Emprunteur borrower);
}
