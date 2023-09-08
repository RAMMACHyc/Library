package implementation;
import Core.DatabaseConnection;
import classes.Book;
import classes.Emprunteur;
import interfaces.IEmprunteur;
import java.sql.Date;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmprunteurImpl implements IEmprunteur {
    private final String ADD_EMPRUNTEUR = "INSERT INTO borrowers (id, name, tel, cin, date_of_birth) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_EMPRUNTEUR = "UPDATE borrowers SET name = ?, tel = ?, cin = ?, date_of_birth = ? WHERE id = ?";
    private final String DELETE_EMPRUNTEUR = "DELETE FROM borrowers WHERE id = ?";
    private final String SELECT_EMPRUNTEUR = "SELECT * FROM borrowers";

    public int generateRandomRefernce() {
        Random rand = new Random();
        int id = rand.nextInt(900000000) + 100000000;
        return id;
    }


    @Override
    public void add(Emprunteur emprunteur) {
        int id = generateRandomRefernce();
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPRUNTEUR)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, emprunteur.getName());
            preparedStatement.setInt(3, emprunteur.getTel());
            preparedStatement.setInt(4, emprunteur.getCin());

            Date dateOfBirth = Date.valueOf(emprunteur.getDateOfBirth());

            preparedStatement.setDate(5, dateOfBirth);

            preparedStatement.executeUpdate();
            System.out.println("Emprunteur added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean update(Emprunteur emprunteur) {
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPRUNTEUR)) {
            preparedStatement.setInt(1, emprunteur.getId());
            preparedStatement.setString(2, emprunteur.getName());
            preparedStatement.setInt(3, emprunteur.getTel());
            preparedStatement.setInt(4, emprunteur.getCin());
            preparedStatement.setString(5,emprunteur.getDateOfBirth());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public  List<Emprunteur> showEmprunteur() {
        List<Emprunteur> emprunteurs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPRUNTEUR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int tel = resultSet.getInt("tel");
                int cin = resultSet.getInt("cin");
                String DateOfBirth = resultSet.getString("date_of_birth");

                Emprunteur emprunteur = new Emprunteur(id, name, tel, cin,DateOfBirth);
                emprunteurs.add(emprunteur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emprunteurs;
    }

    @Override
    public boolean deleteEmprunteur(int id) {
        try (Connection connection = DatabaseConnection.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPRUNTEUR)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
