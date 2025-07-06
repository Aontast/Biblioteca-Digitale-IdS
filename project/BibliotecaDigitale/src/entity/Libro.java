package entity;

public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private int codiceISBN;
    private String descrizione;

    private int disponibilitaCopie;
    private CopiaLibro listaCopie[];

    public Libro(String titolo, String autore, int annoDiPubblicazione, String genere, int codiceISBN, String descrizione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.codiceISBN = codiceISBN;
        this.descrizione = descrizione;
        this.disponibilitaCopie = 0;
    }

    public void aggiungiCopia(Libro libro) {
        CopiaLibro copia = new CopiaLibro(libro);
        listaCopie[this.disponibilitaCopie] = copia;
        this.disponibilitaCopie++;
    }

    public int getDisponibilitaCopie() {
        return disponibilitaCopie;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getCodiceISBN() {
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

    public void incrementaDisponibilitaCopie() {
        this.disponibilitaCopie++;
    }

    public void decrementaDisponibilitaCopie() {
        this.disponibilitaCopie--;
    }
}
