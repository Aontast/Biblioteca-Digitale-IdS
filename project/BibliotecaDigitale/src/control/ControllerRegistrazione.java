package control;

import entity.SistemaAutenticazione;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ControllerRegistrazione {

    private static ControllerRegistrazione instance = null;

    private ControllerRegistrazione(){
        super();
    }

    // Costruttore Singleton Catalogo, non chiama costruttore chiama metodo che istanzia l'oggetto Catalogo
    // Se l'istanza non esiste, la crea, altrimenti restituisce l'istanza esistente
    // In questo modo si garantisce che ci sia una sola istanza di Catalogo in tutto il programma
    public static synchronized ControllerRegistrazione getInstance() {
        if (instance == null) {
            instance = new ControllerRegistrazione();
        }
        return instance;
    }

    public void registraUtente(String nome, String cognome, String email, String password) throws SQLIntegrityConstraintViolationException, SQLException {
        // Istanzia il sistema di autenticazione
        SistemaAutenticazione sistemaAut = SistemaAutenticazione.getInstance();
        
        //dati gia verificati di validità nel boundary
        //verificheremo la presenza di un utente con la stessa email nell'entity

        // Chiama il metodo di registrazione utente
        sistemaAut.registrazioneCliente(nome, cognome, email, password);
        //Questo può anche inoltrare una eccezione nel caso in cui l'utente sia già registrato
        //eccezione che viene propagata al boundary per poi mostrarla come messaggio.
    }
}
