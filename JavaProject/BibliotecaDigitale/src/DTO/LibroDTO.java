package DTO;

public class LibroDTO {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private long codiceISBN;
    private String descrizione;

    public LibroDTO(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public String getGenere() {
        return genere;
    }

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return titolo + " | " + autore + " | "  + codiceISBN + " | " + annoDiPubblicazione;
    }
}