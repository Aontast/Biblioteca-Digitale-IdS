package entity;

import java.util.List;

public class Cliente extends UtenteRegistrato {

    private List<Prenotazione> prenotazioniCliente;

    public Cliente(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
        this.livelloPermesso = 2;
    }
}
