package gestionefile;

import java.io.*;

/**
 * @author Matteo Bagnoletti Tini
 */
public class User implements Serializable {
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
    public User(String nomeFileObject){
        /* legge un oggetto da un file */
        try (ObjectInputStream lettore = new ObjectInputStream(new FileInputStream(nomeFileObject))) {
            User user = (User) lettore.readObject();
            this.id = user.id;
            this.name = user.name;
            this.surname = user.surname;
            this.role = user.role;
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Errore in lettura!");
        }
    }
    public void scriviOggettoSuFile(String nomeFileObject){
        /* salva questo oggetto su un file */
        try (ObjectOutputStream scrittore = new ObjectOutputStream(new FileOutputStream(nomeFileObject))) {
            scrittore.writeObject(this);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Errore in scrittura!");
        }
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + "; name=" + name + "; surname=" + surname + "; role=" + role + '}';
    }
}
