package entity;

import database.LibroDAO;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


public class Catalogo {

    private static Catalogo instance = null;

    private int numeroLibriTotali;
    List<Libro> listaLibri;

    private Catalogo(){
        this.numeroLibriTotali = 0;
        this.listaLibri = new ArrayList<>();
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
        this.listaLibri = libroDAO.getAllLibri();
        for (Libro libro : this.listaLibri) {
            System.out.println(libro);
        }
        numeroLibriTotali = this.listaLibri.size(); //non so se serve ma per il momento lo metto
    }

    public void filtraCatalogo(){
        //Non implementato
    }

    public void aggiungiLibro(Libro libro) throws SQLIntegrityConstraintViolationException{
        LibroDAO libroDAO = new LibroDAO();
        if (!libroDAO.hasLibroConISBN(libro.getCodiceISBN())) {
            // Salva il libro tramite il DAO
            libroDAO.salvaLibro(libro);
            
            // Aggiungi il libro alla lista interna
            this.listaLibri.add(libro);
            this.numeroLibriTotali++;
            
        } else {
            System.out.println("Il libro con ISBN " + libro.getCodiceISBN() + " è già presente nel catalogo.");
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
