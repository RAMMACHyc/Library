package classes;

import java.util.Date;

public class Emprunt {
    private Book book;

    private Emprunteur emprunteur ;

    private Date borrowingDate;

    private Date returnDate;

    private int borrowingDuration;

    public Emprunt(Book book, Emprunteur borrower, Date borrowingDate, Date returnDate, int borrowingDuration) {
        setBook(book);
        setEmprunteur(emprunteur);
        setBorrowingDate(borrowingDate);
        setReturnDate(returnDate);
        setBorrowingDuration(borrowingDuration);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Emprunteur getBorrower() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur borrower) {
        this.emprunteur = borrower;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getBorrowingDuration() {
        return borrowingDuration;
    }

    public void setBorrowingDuration(int borrowingDuration) {
        this.borrowingDuration = borrowingDuration;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "book=" + book +
                ", borrower=" + emprunteur +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", borrowingDuration=" + borrowingDuration +
                '}';
    }
}
