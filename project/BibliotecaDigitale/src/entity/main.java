package entity;

import database.CopiaLibroDAO;
import database.LibroDAO;
import database.PrenotazioneDAO;
import database.UtenteRegistratoDAO;

import java.sql.SQLIntegrityConstraintViolationException;

public class main {
    public static void main(String[] args) {

        Libro libro = new Libro(1111111111111L, "Il Grande Gatsby", "F. Scott Fitzgerald", 1925, "Romanzo", "Un classico della letteratura americana che esplora temi di decadimento, idealismo e resistenza al cambiamento sociale.");

        CopiaLibro copia = new CopiaLibro(libro);
        CopiaLibroDAO copiaDAO = new CopiaLibroDAO();

        UtenteRegistrato utente = new Cliente("Mario", "Rossi", "email@", "password");
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        try {
            utenteDAO.salvaUtente(utente);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Utente già presente");
        }

        copia.setID(2);
        Prenotazione prenotazione = new Prenotazione("10/12", 32.3, copia, utente);
        System.out.println(copia.getID() + utente.getEmail());
        System.out.println("ciao");

        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
        try {
            prenotazioneDAO.salvaPrenotazione(prenotazione);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Prenotazione già esistente");
        }



    }
}
