package interfaces;
import classes.Book;
import classes.Emprunteur;
import java.util.List;


public interface IEmprunteur  {
    void add(Emprunteur emprunteur);
    boolean update(Emprunteur emprunteur);
    List<Emprunteur> showEmprunteur();
    boolean deleteEmprunteur(int id);

}
