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

        utenteDAO.salvaUtente(utente);
        // Questo potrebbe propagare un'eccezione SQLIntegrityConstraintViolationException
        // se l'utente con la stessa email esiste già nel database, noi lo propaghiamo al chiamante
        // in modo tale che si possa visualizzare un messaggio di errore
    }

    public void accessoProfiloUtente(){
        //Non impelementato
    }

    private boolean verificaPresenzaCredenziali(String email){
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        return utenteDAO.hasUtenteConEmail(email);
    }
}
