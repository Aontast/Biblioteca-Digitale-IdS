package entity;

import database.LibroDAO;
import java.util.List;


public class Catalogo {

    private static Catalogo instance = null;

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

    public void mostraCatalogo(){

        // Istanzia un oggetto LibroDAO per interagire con il database
        // e recuperare la lista dei libri
        LibroDAO libroDAO = new LibroDAO();
        List<Libro> listaLibri = libroDAO.getAllLibri();
        for(Libro libro : listaLibri) {
            System.out.println(libro);
        }
    }

    public void filtraCatalogo(){
        //Non implementato
    }

    public void aggiungiLibro(Libro libro) throws Exception {
        LibroDAO libroDAO = new LibroDAO();
        if (libroDAO.hasLibroConISBN(libro.getCodiceISBN())) {
            throw new Exception("Il libro con ISBN " + libro.getCodiceISBN() + " è già presente nel catalogo.");
        }
        int result = libroDAO.salvaLibro(libro);
        if (result <= 0) {
            throw new Exception("Salvataggio del libro fallito per ISBN: " + libro.getCodiceISBN());
        }
    }

    public void eliminaLibro(){
        //Non implementato
    }

    private Libro trovaLibro(int isbn){
        LibroDAO libroDAO = new LibroDAO();
        if(libroDAO.hasLibroConISBN(isbn)){
            return libroDAO.getLibroByISBN(isbn);
        }else{
            System.out.println("Il libro con ISBN " + isbn + " non è presente nel catalogo.");
            return null;
        }
    }
}
