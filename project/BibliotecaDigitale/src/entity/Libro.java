package entity;

import java.util.ArrayList;
import java.util.List;

import database.CopiaLibroDAO;

public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private long codiceISBN;
    private String descrizione;

    private int numeroCopieTotali;

    public Libro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.descrizione = descrizione;
        this.numeroCopieTotali = 0;
    }

    //costruttore per quando viene prelevato un libro da database
    //in questo caso il numero di copie totali è già stato inserito nel database
    public Libro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione, int numeroCopieTotali) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.descrizione = descrizione;
        this.numeroCopieTotali = numeroCopieTotali;
    }

    public boolean verificaDisponibilitaLibro() {
        CopiaLibroDAO copiaLibroDAO = new CopiaLibroDAO();
        List<CopiaLibro> copieDisponibili = copiaLibroDAO.getCopieDisponibili();

        for (CopiaLibro copia : copieDisponibili) {
            if (copia.getLibro().getCodiceISBN() == this.codiceISBN) {
                return true; // Se trova una copia disponibile, ritorna true
            }
        }
        return false; // Se non trova nessuna copia disponibile, ritorna false
    }

    public void aggiungiCopia() {
        // aggiunge una nuova copia
    }

    public int getnumeroCopieTotali() {
        return numeroCopieTotali;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getGenere() {
        return genere;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", genere='" + genere + '\'' +
                ", codiceISBN=" + codiceISBN +
                ", descrizione='" + descrizione + '\'' +
                ", numeroCopieTotali=" + numeroCopieTotali +
                '}';
    }
}
