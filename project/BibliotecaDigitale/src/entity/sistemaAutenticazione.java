package entity;

import java.util.ArrayList;
import java.util.List;

public class sistemaAutenticazione {
    
    private int numeroUtentiRegistrati;
    private List<UtenteRegistrato> listaUtentiRegistrati;

    // Singleton pattern
    private static sistemaAutenticazione instance = null;
    private sistemaAutenticazione() {
        this.numeroUtentiRegistrati = 0;
        this.listaUtentiRegistrati = new ArrayList<>();
    }
    public static synchronized sistemaAutenticazione getInstance() {
        if (instance == null) {
            instance = new sistemaAutenticazione();
        }
        return instance;
    }

    public void registrazioneUtente(){

    }

    public void accessoProfiloUtente(){

    }

    private void verificaFormattazioneCredenziali(){

    }

    private void verificaPresenzaCredenziali(){

    }
}
