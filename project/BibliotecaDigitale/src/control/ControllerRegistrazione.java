package control;

import entity.SistemaAutenticazione;

public class ControllerRegistrazione {

    public void registraUtente(String nome, String cognome, String email, String password) throws Exception {
        // Istanzia il sistema di autenticazione
        SistemaAutenticazione sistemaAut = SistemaAutenticazione.getInstance();
        
        //dati gia verificati di validità nel boundary
        //verificheremo la presenza di un utente con la stessa email nell'entity

        // Chiama il metodo di registrazione utente
        sistemaAut.registrazioneUtente(nome, cognome, email, password);
        //uesto può anche inoltrare una eccezione nel caso in cui l'utente sia già registrato
        //eccezione che viene propagata al boundary per poi mostrarla come messaggio.
    }
}
