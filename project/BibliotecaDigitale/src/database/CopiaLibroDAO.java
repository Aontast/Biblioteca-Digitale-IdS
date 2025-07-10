package database;

import entity.CopiaLibro;
import entity.Libro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class CopiaLibroDAO {

    /**
     * Costruttore della classe CopiaLibroDAO.
     */
    public CopiaLibroDAO(){ super();}

    /**
     * Salva una copia di un libro nel database.
     *
     * @param copia La copia del libro da salvare.
     * @return Risultato della query.
     * @throws SQLIntegrityConstraintViolationException Se si verifica una violazione di vincoli di integrità.
     */
    public int salvaCopiaLibro(CopiaLibro copia) throws SQLIntegrityConstraintViolationException {

        int result;
        String query = "INSERT INTO copie (Stato, Libro) VALUES('%s', %d)".formatted(
                copia.getStato().toString(),
                copia.getLibro().getCodiceISBN()
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

        return result;
    }

    /**
     * Recupera tutte le copie disponibili di libri dal database.
     *
     * @return Una lista di copie di libri disponibili.
     */
    public List<CopiaLibro> getCopieDisponibili() {
        List<CopiaLibro> listaCopie = new ArrayList<>();

        try {
            String query = "SELECT * FROM copie c JOIN libri l ON c.Libro = l.ISBN WHERE c.Stato = 'disponibile'";
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

                listaCopie.add(new CopiaLibro(
                        rs.getInt("IDCopia"),
                        rs.getString("Stato"),
                        libro
                        )
                );
            }
            System.out.println("[getCopieDisponibili] Libri del database recuperati");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getCopieDisponibili] Libri del database non recuperati: " + e.getMessage());
        }

        return listaCopie;
    }

    public void updateStato(CopiaLibro copia) throws SQLException, ClassNotFoundException {
    String query = String.format("UPDATE copie SET Stato = '%s' WHERE IDCopia = %d",
            copia.getStato().toString(),
            copia.getID()
    );

    try {
        DBConnectionManager.updateQuery(query);
        System.out.println("[updateStato] Stato della copia " + copia.getID() + " aggiornato a " + copia.getStato());
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println("[updateStato] Errore nell'aggiornare lo stato della copia: " + e.getMessage());
        throw e;
    }
}

}
