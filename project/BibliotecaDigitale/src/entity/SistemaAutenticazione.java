package entity;

import database.UtenteRegistratoDAO;

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

    public void registrazioneUtente(String nome, String cognome, String email, String password) throws Exception {
        // Verifica che mail non sia gia presente nel database
        if (verificaPresenzaCredenziali(email)) {
            throw new Exception("Utente con email " + email + " già registrato.");
        }

        // Crea un nuovo Cliente e lo salva nel database
        // Utilizza il DAO per interagire con il database
        UtenteRegistrato utente = new Cliente(nome, cognome, email, password);
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        int result = utenteDAO.salvaUtente(utente);
        
        // Controlla se la registrazione è andata a buon fine
        // Se il risultato è minore o uguale a 0, significa che c'è stato un errore
        // durante la registrazione, quindi lancia un'eccezione
        if (result <= 0) {
            throw new Exception("Registrazione fallita per l'utente: " + email);
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
