package classes;

public class Emprunteur {
    private int id;
    private String name;
    private int tel;
    private int cin;
    private String dateOfBirth;



    public Emprunteur(int id, String name, int tel, int cin, String dateOfBirth) {
       setId(id);
       setName(name);
       setTel(tel);
       setCin(cin);
       setDateOfBirth(dateOfBirth);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
