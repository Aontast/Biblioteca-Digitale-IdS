package entity;

public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private int codiceISBN;
    private String descrizione;

    private static int disponibilitaCopie;
    private Copia copia[];

    public Libro(String titolo, String autore, int annoDiPubblicazione, String genere, int codiceISBN, String descrizione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.codiceISBN = codiceISBN;
        this.descrizione = descrizione;
    }

    public void aggiungiCopia() {
        Copia copia = new Copia();
        copia[disponibilitaCopie] = copia;
        disponibilitaCopie++;
    }
}
