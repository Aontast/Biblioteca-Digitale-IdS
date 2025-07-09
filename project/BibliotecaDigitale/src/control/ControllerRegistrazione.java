package control;

import entity.SistemaAutenticazione;

import java.sql.SQLIntegrityConstraintViolationException;

public class ControllerRegistrazione {

    public void registraUtente(String nome, String cognome, String email, String password) throws SQLIntegrityConstraintViolationException {
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
