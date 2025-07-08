package entity;

import database.LibroDAO;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Libro libro1 = new Libro(3, "dew", "J.R.R. Tolkien", 1954, "Fantasy", "molto bello", 0);
        LibroDAO libroDAO = new LibroDAO();

        System.out.println(libroDAO.salvaLibro(libro1));

        List<Libro> listaLibriDB;

        listaLibriDB = libroDAO.getAllLibri();

        for (Libro libro : listaLibriDB) {
            System.out.println(libro);
        }

        System.out.println(libroDAO.hasLibroConISBN(3));
        System.out.println(libroDAO.getLibroByISBN(3));
        

    }
}
