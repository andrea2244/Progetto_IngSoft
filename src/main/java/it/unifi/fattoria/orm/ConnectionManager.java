package it.unifi.fattoria.orm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Persona C. Singleton: una sola connessione al database per tutta l'applicazione.
public class ConnectionManager {
    private static ConnectionManager instance;
    private static String url = "jdbc:h2:./data/fattoria";

    private Connection connection;

    private ConnectionManager() {}

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    // Nei test si usa un database in memoria, es. "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
    public static synchronized void setUrl(String nuovoUrl) {
        url = nuovoUrl;
        instance = null;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, "sa", "");
            creaSchema();
        }
        return connection;
    }

    private void creaSchema() throws SQLException {
        try (InputStream in = getClass().getResourceAsStream("/schema.sql");
             Statement st = connection.createStatement()) {
            String sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            for (String comando : sql.split(";")) {
                if (!comando.isBlank()) {
                    st.execute(comando);
                }
            }
        } catch (IOException e) {
            throw new SQLException("Impossibile leggere schema.sql", e);
        }
    }
}
