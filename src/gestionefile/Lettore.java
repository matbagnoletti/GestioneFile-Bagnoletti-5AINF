package gestionefile;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MC
 * @author (fork) Matteo Bagnoletti Tini
 * @version 16/01/23
 */

public class Lettore extends Thread{
    /**
     * Nome del file da leggere
     */
    String nomeFile;
    /**
     * Se true, legge il file e lo mostra in output, altrimenti lo copia nel file copia.csv
     */
    boolean console;

    public Lettore(boolean console, String nomeFile){
        this.nomeFile = nomeFile;
        this.console = console;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */
    public void leggi(){
        int i;
        //1) apro il file
        try (FileReader fr = new FileReader(nomeFile)) {
            //2) leggo carattere per carattere e lo stampo 
            while((i = fr.read()) != -1)
                System.out.print((char) i);

            System.out.print("\n\r");
            //3) la chiusura del file è automatica
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Errore in lettura!");
        }
    }

    public void copia(){
        StringBuilder contenuto = new StringBuilder();
        int i;
        //1) apro il file
        try (FileReader fr = new FileReader(nomeFile)){
            //2) leggo carattere per carattere e lo stampo
            while ((i=fr.read()) != -1)
                contenuto.append((char) i);

            System.out.print("\n\r");
            //3) la chiusura del file è automatica
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Errore in lettura!");
        }

        Scrittore scrittore = new Scrittore("src/gestionefile/copia.csv", contenuto.toString());
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }
    }
    

    public void run(){
        if(this.console){
            leggi();
        }
        else{
            copia();
        }
    }
}
