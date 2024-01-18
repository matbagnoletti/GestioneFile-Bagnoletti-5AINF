package gestionefile;

import java.io.*;

/**
 *
 * @author MC
 * @author (fork) Matteo Bagnoletti Tini
 * @version 16/01/23
 */
public class GestioneFile {

    /**
     * @param args parametri da linea di comando
     */
    public static void main(String[] args) {

        //1)LETTURA
        Lettore lettore = new Lettore(true, "src/gestionefile/user.json");
        lettore.start();
        try {
            lettore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join() - riga 24");
        }
        //2)ELABORAZIONE
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci uno username: ");
        String username = null;
        String password = null;
        try {
            username = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera dello username - riga 34");
        }
        System.out.print("Inserisci una password: ");
        try {
            password = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera della password - riga 40");
        }

        /* valore di default */
        String verme = "TPSIT";
        System.out.print("Inserisci una chiave di cifratura: ");
        try {
            verme = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera del verme - riga 49");
        }
        Cifrario cifrario = new Cifrario(verme);
        password = cifrario.cifra(password);

        try {
            reader.close();
        } catch (IOException ex) {
            System.err.println("Errore nella chiusura del buffer di lettura - riga 57");
        }

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("src/gestionefile/output.csv", username + ";" + password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();

        try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join() - riga 68");
        }

        //4) COPIA
        Lettore lettore_copia = new Lettore(false, "src/gestionefile/output.csv");
        lettore_copia.start();
        try {
            lettore_copia.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }

        //ISSUE #3
        try (DataInputStream input = new DataInputStream(new FileInputStream("src/gestionefile/user.csv"))) {
            String line;
            while ((line = input.readLine()) != null) {

            }
        } catch (IOException ex) {
            System.err.println("Errore nella lettura del file - riga 88");
        }
    }
    
}
