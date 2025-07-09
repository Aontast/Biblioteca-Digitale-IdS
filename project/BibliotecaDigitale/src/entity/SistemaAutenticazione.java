package entity;

import database.UtenteRegistratoDAO;

import java.sql.SQLIntegrityConstraintViolationException;

public class SistemaAutenticazione {

    // Singleton pattern
    private static SistemaAutenticazione instance = null;
    private SistemaAutenticazione() {
        super();
    }

    public static synchronized SistemaAutenticazione getInstance() {
        if (instance == null) {
            instance = new SistemaAutenticazione();
        }
        return instance;
    }

    public void registrazioneCliente(String nome, String cognome, String email, String password) throws SQLIntegrityConstraintViolationException {
        // Crea un nuovo Cliente e lo salva nel database
        // Utilizza il DAO per interagire con il database
        UtenteRegistrato utente = new Cliente(nome, cognome, email, password);
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();

        try {
            utenteDAO.salvaUtente(utente);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Account con email "+ email+ " già presente");
            throw e;
        }
    }

    public void accessoProfiloUtente(){
        //Non impelementato
    }

    private boolean verificaPresenzaCredenziali(String email){
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        return utenteDAO.hasUtenteConEmail(email);
    }
}
