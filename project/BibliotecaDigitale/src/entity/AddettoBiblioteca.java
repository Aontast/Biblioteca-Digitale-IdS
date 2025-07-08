package entity;

public class AddettoBiblioteca extends UtenteRegistrato {

    public AddettoBiblioteca(String nome, String cognome, String email, String password) {
        super(nome, cognome, email, password);
        this.livelloPermesso = 1;
    }
}
