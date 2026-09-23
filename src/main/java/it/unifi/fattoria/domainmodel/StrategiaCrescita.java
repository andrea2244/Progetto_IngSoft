package it.unifi.fattoria.domainmodel;

// Persona A. Strategy: regole di crescita diverse per tipo di pianta.
public interface StrategiaCrescita {
    boolean puoAvanzare(int giorniNellaFase, double umidita);
}
