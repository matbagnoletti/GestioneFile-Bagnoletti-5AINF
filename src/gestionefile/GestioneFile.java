package gestionefile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author MC
 * @author (fork) Matteo Bagnoletti Tini
 * @version 16/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore(true, "src/gestionefile/user.json");
        lettore.start();
        try {
            lettore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }
        //2)ELABORAZIONE
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci uno username: ");
        String username = null;
        String password = null;
        try {
            username = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera dello username");
        }
        System.out.print("Inserisci una password: ");
        try {
            password = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera della password");
        }

        /* valore di default */
        String verme = "TPSIT";
        System.out.print("Inserisci una chiave di cifratura: ");
        try {
            verme = reader.readLine();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da tastiera del verme");
        }
        Cifrario cifrario = new Cifrario(verme);
        password = cifrario.cifra(password);

        try {
            reader.close();
        } catch (IOException ex) {
            System.err.println("Errore nella chiusura del buffer di lettura");
        }

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("src/gestionefile/output.csv", username + ";" + password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();

        try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }

        //4) COPIA
        Lettore lettore_copia = new Lettore(false, "src/gestionefile/output.csv");
        lettore_copia.start();
        try {
            lettore_copia.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }
    }
    
}
