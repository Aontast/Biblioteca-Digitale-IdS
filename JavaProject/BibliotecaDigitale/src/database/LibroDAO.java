package database;

import entity.Libro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    /**
     * Costruttore della classe LibroDAO
     */
    public LibroDAO() {
        super();
    }

    /**
     * Metodo per salvare un libro nel database
     * @param libro Libro da salvare
     * @return 0 se il salvataggio è andato a buon fine, -1 in caso contrario
     */
    public int salvaLibro(Libro libro) throws SQLIntegrityConstraintViolationException {

        int result;
        String query = String.format("INSERT INTO libri VALUES(%d, '%s', '%s', %d, '%s', '%s', %d)",
                libro.getCodiceISBN(),
                libro.getTitolo(),
                libro.getAutore(),
                libro.getAnnoDiPubblicazione(),
                libro.getGenere(),
                libro.getDescrizione(),
                libro.getnumeroCopieTotali()
        );

        try {
            result = DBConnectionManager.updateQuery(query);
            System.out.println("[SalvaLibro] Libro Salvato con successo nel database");
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Un libro con lo stesso ISBN è già presente nel database.", e);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[SalvaLibro] Libro non salvato nel database: " + e.getMessage());
            result = -1;
        }

        return result;
    }

    /**
     * Metodo per recuperare tutti i libri dal database
     * @return Lista di libri presenti nel database
     */
    public List<Libro> getAllLibri() {

        List<Libro> listaLibri = new ArrayList<>();

        try {
            String query = "SELECT * FROM libri";
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {
                listaLibri.add(new Libro(
                        rs.getLong("ISBN"),
                        rs.getString("Titolo"),
                        rs.getString("Autore"),
                        rs.getInt("AnnoPubblicazione"),
                        rs.getString("Genere"),
                        rs.getString("Descrizione"),
                        rs.getInt("NumeroCopie")
                        )
                );
            }
            System.out.println("[getAllLibri] Libri del database recuperati");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getAllLibri] Libri del database non recuperati: " + e.getMessage());
        }

        return listaLibri;
    }

    public List<Libro> getAllLibriDisponibili() {

        List<Libro> listaLibri = new ArrayList<>();

        try {
            String query = "SELECT l.ISBN, l.Titolo, l.Autore, l.AnnoPubblicazione, l.Genere, l.Descrizione, l.NumeroCopie " +
                           "FROM libri AS l " +
                           "JOIN copie AS c ON l.ISBN = c.Libro " +
                           "WHERE c.Stato = 'disponibile';";
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {
                listaLibri.add(new Libro(
                        rs.getLong("ISBN"),
                        rs.getString("Titolo"),
                        rs.getString("Autore"),
                        rs.getInt("AnnoPubblicazione"),
                        rs.getString("Genere"),
                        rs.getString("Descrizione"),
                        rs.getInt("NumeroCopie")
                        )
                );
            }
            System.out.println("[getAllLibriDisponibili] Libri Disponibili del database recuperati");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getAllLibriDisponibili] Libri Disponibili del database non recuperati: " + e.getMessage());
        }

        return listaLibri;
    }

    /**
     * Metodo per cercare un libro nel database tramite il suo ISBN
     * @param isbn ISBN del libro da cercare
     * @return true se il libro è stato trovato, false altrimenti
     */
    public boolean hasLibroConISBN(long isbn) {

        boolean libroTrovato = false;

        try {
            String query = "SELECT * FROM libri WHERE ISBN = " + isbn;
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                libroTrovato = true;
            }

            System.out.println("[searchLibroByISBN] Libro dal database cercato");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[searchLibroByISBN] Libro dal database non cercato: " + e.getMessage());
        }

        return libroTrovato;
    }


    /**
     * Metodo per recuperare un libro dal database tramite il suo ISBN
     * @param isbn ISBN del libro da recuperare
     * @return Libro se trovato, null altrimenti
     */
    public Libro getLibroByISBN(long isbn) {

        Libro libroTrovato = null;

        try {
            String query = "SELECT * FROM libri WHERE ISBN = " + isbn;
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                libroTrovato = new Libro(
                        rs.getInt("ISBN"),
                        rs.getString("Titolo"),
                        rs.getString("Autore"),
                        rs.getInt("AnnoPubblicazione"),
                        rs.getString("Genere"),
                        rs.getString("Descrizione"),
                        rs.getInt("NumeroCopie")
                );
            }

            System.out.println("[getLibroByISBN] Libro dal database recuperato");
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("[getLibroByISBN] Libro dal database non recuperato: " + e.getMessage());
        }

        return libroTrovato;
    }

    /**
     * Metodo per aggiornare numero copie libro nel database
     * @param libro Libro da aggiornare
     * @return 0 se l'aggiornamento è andato a buon fine, -1 in caso contrario
     */
    public int updateNumeroCopieLibro(Libro libro) {

        int result;
        String query = String.format("UPDATE libri SET NumeroCopie = %d WHERE ISBN = %d",
                libro.getnumeroCopieTotali(),
                libro.getCodiceISBN()
        );

        try {
            result = DBConnectionManager.updateQuery(query);
            System.out.println("[aggiornaNumeroCopieLibro] Libro aggiornato con successo nel database");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[aggiornaNumeroCopieLibro] Libro non aggiornato nel database: " + e.getMessage());
            result = -1;
        }

        return result;
    }
}
