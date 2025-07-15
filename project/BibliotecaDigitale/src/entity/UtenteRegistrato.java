package entity;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import database.UtenteRegistratoDAO;

public abstract class UtenteRegistrato {
    protected String nome;
    protected String cognome;
    protected String email;
    protected String password;
    protected int livelloPermesso;

    private List<Prenotazione> prenotazioniUtente;

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


    public void salvaUtenteRegistrato() throws SQLIntegrityConstraintViolationException, SQLException {
        UtenteRegistratoDAO utenteDAO = new UtenteRegistratoDAO();
        int result = 0;
        try {
            result = utenteDAO.salvaUtente(this);
            if(result == -1) {
                throw new SQLException("Connessione al database non riuscita");
            }
            System.out.println("[salvaUtenteRegistrato] Utente salvato con successo nel database");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("[salvaUtenteRegistrato] L'utente con la stessa email " + this.email + " esiste già nel database.");
            throw e;
        } catch (SQLException e) {
            System.out.println("[salvaUtenteRegistrato] Errore connessione al database");
            throw e;
        }
    }
}
