package database;

import java.util.Locale;
import entity.CopiaLibro;
import entity.Libro;
import entity.Prenotazione;
import entity.UtenteRegistrato;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDAO {

    public PrenotazioneDAO() {
        super();
    }

    /**
     * Salva una prenotazione nel database.
     *
     * @param prenotazione La prenotazione da salvare.
     * @return Risultato della query.
     * @throws SQLIntegrityConstraintViolationException Se si verifica una violazione di vincoli di integrità.
     */
    public int salvaPrenotazione(Prenotazione prenotazione) {

        int result;
        String query = String.format(Locale.US, // Specifica la locale US qui
                "INSERT INTO prenotazioni (DataConsegna, Costo, Copia, Utente) VALUES('%s', %f, %d, '%s')",
                prenotazione.getDataConsegna(), // Assicurati che questo sia già una stringa formattata correttamente per il DB (es. "yyyy-MM-dd HH:mm:ss")
                prenotazione.getCostoPrestito(),
                prenotazione.getIDCopia(),
                prenotazione.getEmailUtente()
        );

        try {
            result = DBConnectionManager.updateQueryReturnGeneratedKey(query);
            System.out.println("[salvaPrenotazione] Prenotazione salvata con successo nel database");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[salvaPrenotazione] Prenotazione non salvata nel database: " + e.getMessage());
            result = -1;
        }

        return result;
    }

    /**
     * Recupera tutte le prenotazioni dal database.
     *
     * @return Una lista di prenotazioni.
     */
    public List<Prenotazione> getAllPrenotazioni() {

        List<Prenotazione> listaPrenotazioni = new ArrayList<>();

        try {
            String query = 
                "SELECT * " +
                "FROM prenotazioni p " +
                "JOIN copie c ON p.Copia = c.IDCopia " +
                "JOIN libri l ON c.Libro = l.ISBN " +
                "JOIN utenti u ON p.Utente = u.IDUtente ";
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {

                Libro libro = new Libro(
                    rs.getLong("ISBN"),
                    rs.getString("Titolo"),
                    rs.getString("Autore"),
                    rs.getInt("AnnoPubblicazione"),
                    rs.getString("Genere"),
                    rs.getString("Descrizione"),
                    rs.getInt("NumeroCopie")
                );

                CopiaLibro copia = new CopiaLibro(
                    rs.getInt("IDCopia"),
                    rs.getString("Stato"),
                    libro
                );
                
                UtenteRegistrato utente = UtenteRegistratoDAO.getUtenteRegistrato(
                        rs,
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email")
                );

                listaPrenotazioni.add(new Prenotazione(
                    rs.getInt("IDPrenotazione"),
                    rs.getDate("DataConsegna"),
                    rs.getDouble("Costo"),
                    copia,
                    utente
                ));
            }

            System.out.println("[getAllPrenotazioni] Prenotazioni del database recuperati");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getAllPrenotazioni] Prenotazioni del database non recuperati: " + e.getMessage());
        }

        return listaPrenotazioni;
    }

}
