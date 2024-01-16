package gestionefile;

/**
 *
 * @author MC
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore("GestioneFile-master/src/gestionefile/user.json");
        lettore.start();
        //2)ELABORAZIONE
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("GestioneFile-master/src/gestionefile/output.csv/output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
