package it.unifi.fattoria.orm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

// Persona C: test DAO. Usano un database in memoria, non toccano data/.
class ConnectionManagerTest {
    @BeforeAll
    static void usaDatabaseDiTest() {
        ConnectionManager.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }

    @Test
    void getInstanceRestituisceSempreLaStessaIstanza() {
        assertSame(ConnectionManager.getInstance(), ConnectionManager.getInstance());
    }

    @Test
    void laConnessioneSiApreEPreparaLoSchema() throws Exception {
        assertFalse(ConnectionManager.getInstance().getConnection().isClosed());
    }
}
