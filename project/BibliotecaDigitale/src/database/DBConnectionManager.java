package database;

import java.sql.*;

public class DBConnectionManager {

    // Parametri di connessione al database
    private static final String url = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String dbName = "biblioteca";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "admin";

    //metodo apertura connessione
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(driver);

        conn = DriverManager.getConnection(url+dbName, username, password);
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

    //query result
    public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        return stmt.executeQuery(query);
    }

    public static int updateQuery(String query) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        int result = stmt.executeUpdate(query);
        conn.close();
        return result;
    }


}
