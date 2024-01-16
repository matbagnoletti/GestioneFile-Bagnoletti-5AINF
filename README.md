# GestioneFile-Bagnoletti-5AINF

> [!NOTE]
>
> Autore: [**Matteo Bagnoletti Tini**](https://github.com/matbagnoletti)
>
> Docente: [**prof.ssa Monica Ciuchetti**](https://github.com/mciuchetti)
>
> Docente di laboratorio: prof.ssa Ilaria Fioroni
>
> Corso: TPSIT 5AINF a.s. 2023/2024
>
> Istituto: [**ITTS A. Volta**](https://www.avoltapg.edu.it/), Perugia (PG), Italia
>
> Tipologia: `Java Project` (originato in NetBeans e gestito in IntelliJ IDEA)

## Descrizione
Questo progetto è un'applicazione Java che permette di gestire in lettura e scrittura diversi file di testo utilizzando stream di byte e di caratteri.

## Struttura
Il progetto è composto da 6 classi:
- [**GestioneFile**](src/gestionefile/GestioneFile.java): classe principale che contiene il metodo `main`.
- [**Lettore**](src/gestionefile/Lettore.java): classe che contiene i metodi per leggere un file di testo e stamparne il contenuto sulla console o copiarlo in un altro file.
- [**Scrittore**](src/gestionefile/Scrittore.java): classe che contiene i metodi per scrivere un file di testo.
- [**Cifrario**](src/gestionefile/Cifrario.java): classe che contiene i metodi per cifrare e decifrare un messaggio di testo (in questo caso la password).
- [**Vigenere**](src/gestionefile/Vigenere.java): classe utilizzata da [**Cifrario**](src/gestionefile/Cifrario.java).
- [**Matrice**](src/gestionefile/Matrice.java): classe utilizzata da [**Vigenere**](src/gestionefile/Vigenere.java).

## Crediti
Il presente progetto è stato realizzato a partire dal progetto [**GestioneFile**](https://github.com/mciuchetti/GestioneFile.git) della prof.ssa Monica Ciuchetti.

## Licenza d'uso
La seguente repository (e tutte le sue versioni) sono rilasciate sotto la [**MB General Copyleft License**](LICENSE).