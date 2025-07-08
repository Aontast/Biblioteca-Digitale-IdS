package database;

import entity.UtenteRegistrato;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UtenteRegistratoDAO {

    public UtenteRegistratoDAO() { super();}

    public int salvaUtente(UtenteRegistrato utente) throws SQLIntegrityConstraintViolationException {

        int result;
        String query = "INSERT INTO utenti (email, nome, cognome, password, livelloPermesso) VALUES('%s', '%s', '%s', '%s', %d)".formatted(
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
            throw e;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[salvaUtente] Utente non salvato nel database: " + e.getMessage());
            result = -1;
        }

        return result;
    }

}
