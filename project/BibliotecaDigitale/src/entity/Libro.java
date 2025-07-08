package entity;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private long codiceISBN;
    private String descrizione;

    private int numeroCopieTotali;
    List<CopiaLibro> listaCopie;

    public Libro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.descrizione = descrizione;
        this.numeroCopieTotali = 0;
        this.listaCopie = new ArrayList<>();
    }

    public Libro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione, int numeroCopieTotali) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.descrizione = descrizione;
        this.numeroCopieTotali = numeroCopieTotali;
        this.listaCopie = new ArrayList<>();
    }

    public void aggiungiCopia() {
        CopiaLibro copia = new CopiaLibro(this);
        listaCopie.add(copia);
        this.numeroCopieTotali++;
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

    public List<CopiaLibro> getListaCopie() {
        return listaCopie;
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

    /*
    public void incrementaDisponibilitaCopie() {
        this.disponibilitaCopie++;
    }

    public void decrementaDisponibilitaCopie() {
        this.disponibilitaCopie--;
    } */

    //Enhanched for per scorrere "tutto", o fino a quando trovo il primo disponibile. 
    //Questo metodo mi controlla la disponibilità alla prenotazione del libro

    public boolean verificaDisponibilita() {
        for (CopiaLibro copia: listaCopie) {
            if (copia.isDisponibile()) {
                return true;
            }
        }
        return false;
    }

    public int numeroCopieDisponibili(){
        int numeroCopieDisponibili = 0;

        for(CopiaLibro copia: listaCopie){
            if (copia.isDisponibile()) {
                numeroCopieDisponibili++;
            }
        }

        return numeroCopieDisponibili;
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
                ", listaCopie=" + listaCopie +
                '}';
    }
}
