package database;

import entity.Prenotazione;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class PrenotazioneDAO {

    public PrenotazioneDAO() {
        super();
    }

    public int salvaPrenotazione(Prenotazione prenotazione) throws SQLIntegrityConstraintViolationException {

        int result;
        /*String query = "INSERT INTO prenotazione (DataConsegna, Costo, Copia, Utente) VALUES('%s', %d)".formatted(
                prenotazione.getDataConsegna(),
                prenotazione.getCostoPrestito()
                prenotazione.getCopia(),
                prenotazione.getUtente()
        );

        try {
            result = DBConnectionManager.updateQuery(query);
            System.out.println("[salvaCopiaLibro] Copia salvata con successo nel database");
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[salvaCopiaLibro] Copia non salvata nel database: " + e.getMessage());
            result = -1;
        }
        */
        return 0;
    }
}
