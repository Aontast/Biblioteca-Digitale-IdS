package entity;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;
    private String genere;
    private int codiceISBN;
    private String descrizione;

    private int disponibilitaCopie;
    List<CopiaLibro> listaCopie;

    public Libro(String titolo, String autore, int annoDiPubblicazione, String genere, int codiceISBN, String descrizione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.genere = genere;
        this.codiceISBN = codiceISBN;
        this.descrizione = descrizione;
        this.disponibilitaCopie = 0;
        this.listaCopie = new ArrayList<>();
    }

    public void aggiungiCopia() {
        CopiaLibro copia = new CopiaLibro(this);
        listaCopie.add(copia);
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

    public List<CopiaLibro> getListaCopie() {
        return listaCopie;
    }

    public void incrementaDisponibilitaCopie() {
        this.disponibilitaCopie++;
    }

    public void decrementaDisponibilitaCopie() {
        this.disponibilitaCopie--;
    }

    public boolean verificaDisponibilita() {
        for (CopiaLibro copia: listaCopie) {
            if (copia.isDisponibile()) {
                return true;
            }
        }
        return false;
    }
}
