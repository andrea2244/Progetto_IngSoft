package it.unifi.fattoria.domainmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Persona A: unit test sulla crescita
class ColturaTest {
    @Test
    void unaNuovaColturaParteDalSeme() {
        Coltura coltura = new Coltura(1, "Pomodoro", (giorni, umidita) -> false);
        assertEquals("SEME", coltura.getFase().getNome());
    }
}
