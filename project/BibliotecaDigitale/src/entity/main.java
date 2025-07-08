package entity;

import database.CopiaLibroDAO;
import database.LibroDAO;
import database.UtenteRegistratoDAO;

import java.sql.SQLIntegrityConstraintViolationException;

public class main {
    public static void main(String[] args) {

        Libro libro = new Libro(1111111111111L, "Il Grande Gatsby", "F. Scott Fitzgerald", 1925, "Romanzo", "Un classico della letteratura americana che esplora temi di decadimento, idealismo e resistenza al cambiamento sociale.");

        CopiaLibro copia = new CopiaLibro(libro);
        CopiaLibroDAO copiaDAO = new CopiaLibroDAO();


        for (CopiaLibro copiaDisponibile: copiaDAO.getCopieDisponibili()) {
            System.out.println(copiaDisponibile);
        }


    }
}
