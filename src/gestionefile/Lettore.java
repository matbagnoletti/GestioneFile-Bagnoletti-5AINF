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
    String nomeFile;
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
        FileReader fr;
        int i; 
        try { 
            //1) apro il file
            fr = new FileReader(nomeFile);
            //2) leggo carattere per carattere e lo stampo 
            while ((i=fr.read()) != -1)
                System.out.print((char) i);
            
            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Errore in lettura!");
        }
    }

    public void copia(){
        FileReader fr;
        StringBuilder contenuto = new StringBuilder();
        int i;
        try {
            //1) apro il file
            fr = new FileReader(nomeFile);
            //2) leggo carattere per carattere e lo stampo
            while ((i=fr.read()) != -1)
                contenuto.append((char) i);

            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
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
