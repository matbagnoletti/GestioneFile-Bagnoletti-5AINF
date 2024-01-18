package gestionefile;

/**
 * @author Matteo Bagnoletti Tini
 */
public class User {
    public int id;
    public String name;
    public String surname;
    public String role;
    public User(int id, String name, String surname, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}
