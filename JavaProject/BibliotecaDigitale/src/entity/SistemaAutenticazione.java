package entity;

import database.UtenteRegistratoDAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class SistemaAutenticazione {

    // Singleton pattern
    private static SistemaAutenticazione instance = null;
    private List<UtenteRegistrato> utentiRegistrati;

    private SistemaAutenticazione() {
        super();
        utentiRegistrati = new ArrayList<>();
    }

    public static synchronized SistemaAutenticazione getInstance() {
        if (instance == null) {
            instance = new SistemaAutenticazione();
        }
        return instance;
    }

    public void registrazioneCliente(String nome, String cognome, String email, String password) throws SQLIntegrityConstraintViolationException, SQLException {
        // Crea un nuovo Cliente e lo salva nel database
        // Utilizza il DAO per interagire con il database
        UtenteRegistrato utente = new Cliente(nome, cognome, email, password);
        utente.salvaUtenteRegistrato();
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
