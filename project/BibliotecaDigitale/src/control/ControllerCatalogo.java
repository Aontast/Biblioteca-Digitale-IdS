package control;

import entity.Catalogo;
import entity.Libro;
import java.util.List;

public class ControllerCatalogo {

    public List<Libro> getLibriDisponibili() {

        // Istanzia un oggetto Catalogo per recuperare la lista dei libri
        Catalogo catalogo = Catalogo.getInstance();
        return catalogo.mostraCatalogo();
    }

    public void aggiungiLibro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione) throws Exception {
        // Istanzia un oggetto Catalogo per aggiungere un libro
        Catalogo catalogo = Catalogo.getInstance();
        //aggiungilibro potrebbe alzare un eccezione se il libro con lo stesso ISBN esiste già
        // o se il salvataggio nel database fallisce
        //in ogni caso l'eccezione viene propagata al chiamante
        //in modo tale che si possa visualizzare un messaggio di errore
        catalogo.aggiungiLibro(codiceISBN, titolo, autore, annoDiPubblicazione, genere, descrizione);
    }
}
