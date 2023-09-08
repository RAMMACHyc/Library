package implementation;
import Core.DatabaseConnection;
import classes.Book;
import classes.Emprunt;
import classes.Emprunteur;
import interfaces.IEmprunt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmpruntImpl implements IEmprunt {
    private static final String ADD_BORROWING = "INSERT INTO borrowings (borrowing_date, return_date, borrowing_duration, borrower_id, book_isbn) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_RETURN_DATE = "UPDATE borrowings SET return_date = ? WHERE borrower_id = ? AND book_isbn = ?";
    @Override
    public Emprunt borrow(Book book, Emprunteur borrower) {
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_BORROWING)) {
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setDate(2, null);
            preparedStatement.setInt(3, 0);
            preparedStatement.setInt(4, borrower.getId());
            preparedStatement.setInt(5, book.getIsbn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public Emprunt returnBook(Book book, Emprunteur emprunteur) {
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RETURN_DATE)) {
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setInt(2, emprunteur.getId());
            preparedStatement.setInt(3, book.getIsbn());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return new Emprunt(book, emprunteur, new Date(System.currentTimeMillis()), null, 0);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}