package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnectionManager {

    // Parametri di connessione al database
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "biblioteca";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    //metodo apertura connessione
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(DRIVER);

        conn = DriverManager.getConnection(URL+DBNAME, USERNAME, PASSWORD);
        System.out.println("Connessione al database stabilita con successo.");
        return conn;
    }

    //metodo chiusura connessione
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connessione al database chiusa correttamente");
            } catch (SQLException e) {
                System.err.println("Errore nella chiusura della connessione: " + e.getMessage());
            }
        }
    }

    //metodi per eseguire query    
    public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        return rs;
    }

    public static int updateQuery(String query) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        int result = stmt.executeUpdate(query);
        conn.close();
        return result;
    }

    public static Integer updateQueryReturnGeneratedKey(String query) throws ClassNotFoundException, SQLException {
        Integer ret = null;

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            ret = rs.getInt(1);
        }

        conn.close();

        return ret;
    }

}
