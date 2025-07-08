package entity;

public abstract class UtenteRegistrato {
    protected String nome;
    protected String cognome;
    protected String email;
    protected String password;
    protected int livelloPermesso;

    /*
    livelloPermesso = 0 => Amministratore
    livelloPermesso = 1 => Addetto Alla Biblioteca
    livelloPermesso = 3 => Cliente
     */

    public UtenteRegistrato(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getLivelloPermesso() {
        return livelloPermesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLivelloPermesso(int livelloPermesso) {
        this.livelloPermesso = livelloPermesso;
    }

    @Override
    public String toString() {
        return "UtenteRegistrato{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", livelloPermesso=" + livelloPermesso +
                '}';
    }
}
