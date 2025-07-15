package entity;

import database.LibroDAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


public class Catalogo {

    private static Catalogo instance = null;
    private List<Libro> libri;

    private Catalogo(){
        super();
    }

    // Costruttore Singleton Catalogo, non chiama costruttore chiama metodo che istanzia l'oggetto Catalogo
    // Se l'istanza non esiste, la crea, altrimenti restituisce l'istanza esistente
    // In questo modo si garantisce che ci sia una sola istanza di Catalogo in tutto il programma
    public static synchronized Catalogo getInstance() {
        if (instance == null) {
            instance = new Catalogo();
        }
        return instance;
    }

    public List<Libro> mostraCatalogo(){

        // Istanzia un oggetto LibroDAO per interagire con il database
        // e recuperare la lista dei libri
        LibroDAO libroDAO = new LibroDAO();
        libri = libroDAO.getAllLibri();
        return libri;
    }

    public void filtraCatalogo(){
        //Non implementato
    }

    public void aggiungiLibro(long codiceISBN, String titolo, String autore, int annoDiPubblicazione, String genere, String descrizione) throws SQLIntegrityConstraintViolationException, SQLException {
        // Crea un nuovo oggetto Libro con i dati forniti
        Libro libro = new Libro(codiceISBN, titolo, autore, annoDiPubblicazione, genere, descrizione);
        libro.salvaLibro();

    }

    public void eliminaLibro(){
        //Non implementato
    }

    private Libro trovaLibro(long isbn){
        LibroDAO libroDAO = new LibroDAO();
        if(libroDAO.hasLibroConISBN(isbn)){
            return libroDAO.getLibroByISBN(isbn);
        }else{
            System.out.println("Il libro con ISBN " + isbn + " non è presente nel catalogo.");
            return null;
        }
    }

    public List<Libro> mostraLibriDisponibili(){
        
        LibroDAO libroDAO = new LibroDAO();
        List<Libro> libriDisponibili = libroDAO.getAllLibriDisponibili();

        return libriDisponibili;
    }
}
