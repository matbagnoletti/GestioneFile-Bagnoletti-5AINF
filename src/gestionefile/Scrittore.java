package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MC
 * @author (fork) Matteo Bagnoletti Tini
 * @version 16/01/23
 */

public class Scrittore implements Runnable{
    /**
     * Nome del file da scrivere
     */
    String nomeFile;
    /**
     * Testo da scrivere nel file
     */
    String testo;

    public Scrittore(String nomeFile, String testo) {
        this.nomeFile = nomeFile;
        this.testo = testo;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        //1) apro il file
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            //2) scrivo nel buffer
            br.write(this.testo);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        //4) il finally non è necessario perché il try-with-resources chiude automaticamente il file
    }
}
