package it.unifi.fattoria.domainmodel;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// Persona B: unit test sulla simulazione
class SensoreTest {
    @Test
    void ilSensoreNotificaGliOsservatori() {
        Sensore sensore = new Sensore(1, "UMIDITA");
        OsservatoreSensore osservatore = mock(OsservatoreSensore.class);
        sensore.aggiungiOsservatore(osservatore);

        sensore.setValore(30.0);

        verify(osservatore).aggiorna(sensore);
    }
}
