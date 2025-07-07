package entity;

import database.LibroDAO;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Libro libro1 = new Libro(4, "IT4", "J.R.R. Tolkien", 1954, "Fantasy", "molto bello", 0);
        LibroDAO libroDAO = new LibroDAO();

        System.out.println(libroDAO.salvaLibro(libro1));

        List<Libro> listaLibriDB;

        listaLibriDB = libroDAO.getAllLibri();

        for (Libro libro : listaLibriDB) {
            System.out.println(libro);
        }

        System.out.println(libroDAO.searchLibroByISBN(3));
        

    }
}
