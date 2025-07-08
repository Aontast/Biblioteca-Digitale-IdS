package entity;

public class Cliente extends UtenteRegistrato {

    public Cliente(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
        this.livelloPermesso = 2;
    }
}
