package entity;

public class Amministratore extends UtenteRegistrato{

    public Amministratore(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
        this.livelloPermesso = 0;
    }
}
