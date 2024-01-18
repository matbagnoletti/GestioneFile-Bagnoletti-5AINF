package gestionefile;

import java.io.*;
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
    /**
     * Elementi da scrivere nel file CSV
     */
    String[] elementiCSV;

    public Scrittore(String nomeFile, String testo) {
        this.nomeFile = nomeFile;
        this.testo = testo;
    }
    public Scrittore(String nomeFile, String[] elementiCSV) {
        this.nomeFile = nomeFile;
        this.elementiCSV = elementiCSV;
    }
    
    @Override
    public void run() {
        if (this.nomeFile.contains("user.csv"))
            scriviCSV(this.elementiCSV);
        else
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
    public void scriviCSV(String[] elementi){
        /* utilizzando la classe DataOutputStream */
        try (DataOutputStream scrittore = new DataOutputStream(new FileOutputStream(nomeFile, true))) {
            for (String elemento : elementi) {
                scrittore.writeUTF(elemento);
                scrittore.writeUTF(";");
            }
            scrittore.writeUTF("\n\r");
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
