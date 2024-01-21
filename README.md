<h1 align="center">GestioneFile-Bagnoletti-5AINF</h1>

<p align="center" style="font-family: monospace">Made by <a href="https://github.com/matbagnoletti">@matbagnoletti</a></p>
<p align="center" style="font-family: monospace">Docenti: prof.ssa <a href="https://github.com/matbagnoletti">@mciuchetti</a> e prof.ssa Fioroni</p>
<p align="center" style="font-family: monospace">Corso TPSIT a.s. 2023/2024, <a href="https://www.avoltapg.edu.it/">ITTS A. Volta (PG)</a></p>
<p align="center">
    <img src="https://img.shields.io/github/last-commit/matbagnoletti/JavaFileManager?style=for-the-badge" alt="Ultimo commit">
    <img src="https://img.shields.io/github/languages/top/matbagnoletti/JavaFileManager?style=for-the-badge" alt="Linguaggio">
</p>

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
Questo progetto è stato realizzato a partire dal progetto [**GestioneFile**](https://github.com/mciuchetti/GestioneFile.git) della prof.ssa Monica Ciuchetti.

## Licenza d'uso
Questo progetto (e tutte le sue versioni) sono rilasciati sotto la [**MB General Copyleft License**](LICENSE).