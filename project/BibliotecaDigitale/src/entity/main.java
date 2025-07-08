package entity;

import database.UtenteRegistratoDAO;

import java.sql.SQLIntegrityConstraintViolationException;

public class main {
    public static void main(String[] args) {

        UtenteRegistrato utente = new Cliente("Antonio", "Di Giorgio", "antodg@", "password");

        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        try {
            utenteDAO.salvaUtente(utente);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Utente già registrato");
        }
    }
}
