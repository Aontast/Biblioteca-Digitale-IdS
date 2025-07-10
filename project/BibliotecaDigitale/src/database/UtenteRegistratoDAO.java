package database;

import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UtenteRegistratoDAO {

    public UtenteRegistratoDAO() { super();}

    /**
     * Salva un utente registrato nel database.
     *
     * @param utente L'utente da salvare.
     * @return Il numero di righe interessate dall'operazione.
     * @throws SQLIntegrityConstraintViolationException Se si verifica una violazione di vincoli di integrità.
     */
    public int salvaUtente(UtenteRegistrato utente) throws SQLIntegrityConstraintViolationException {

        int result;
        String query = String.format("INSERT INTO utenti (email, nome, cognome, password, livelloPermesso) VALUES('%s', '%s', '%s', '%s', %d)",
                utente.getEmail(),
                utente.getNome(),
                utente.getCognome(),
                utente.getPassword(),
                utente.getLivelloPermesso()
        );

        try {
            result = DBConnectionManager.updateQuery(query);
            System.out.println("[salvaUtente] Utente Salvato con successo nel database");

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Questa mail è gia registrata nel database.", e);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[salvaUtente] Utente non salvato nel database: " + e.getMessage());
            result = -1;
        }

        return result;
    }

    /**
     * Recupera un utente registrato dal database in base all'email.
     *
     * @param email L'email dell'utente da recuperare.
     * @return L'utente registrato trovato, o null se non esiste.
     */
    public UtenteRegistrato getUtenteByEmail(String email) {

        UtenteRegistrato utenteTrovato = null;

        try {
            String query = "SELECT * FROM utenti WHERE Email = '" + email + "'";
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                utenteTrovato = getUtenteRegistrato(rs, nome, cognome, email);
            }

            System.out.println("[getUtenteByEmail] Utente dal database recuperato");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getUtenteByEmail] Utente dal database non recuperato: " + e.getMessage());
        }

        return utenteTrovato;
    }


    /**
     * Verifica se esiste un utente registrato con l'email specificata.
     *
     * @param email L'email da verificare.
     * @return true se l'utente esiste, false altrimenti.
     */
    public boolean hasUtenteConEmail(String email) {

        boolean utenteTrovato = false;

        try {
            String query = "SELECT * FROM utenti WHERE Email = '" + email + "'";
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                utenteTrovato = true;
            }

            System.out.println("[getUtenteByEmail] Utente dal database recuperato");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getUtenteByEmail] Utente dal database non recuperato: " + e.getMessage());
        }

        return utenteTrovato;
    }

    static UtenteRegistrato getUtenteRegistrato(ResultSet rs, String nome, String cognome, String email) throws SQLException {
        String password = rs.getString("password");
        UtenteRegistrato utente = null;

        if (rs.getInt("livelloPermesso") == 0) {
            utente = new Amministratore(nome, cognome, email, password);
        } else if (rs.getInt("livelloPermesso") == 1) {
            utente = new AddettoBiblioteca(nome, cognome, email, password);
        } else if  (rs.getInt("livelloPermesso") == 2) {
            utente = new Cliente(nome, cognome, email, password);
        }
        else {
            System.out.println("Livello permesso non definito");
        }
        return utente;
    }

}
