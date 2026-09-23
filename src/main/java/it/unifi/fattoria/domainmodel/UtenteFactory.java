package it.unifi.fattoria.domainmodel;

// Persona C. Factory per i tipi di utente.
public class UtenteFactory {
    public static Utente crea(int id, String username, Ruolo ruolo) {
        // TODO: se servono sottoclassi (Agricoltore, Cliente, ...), crearle qui
        return new Utente(id, username, ruolo);
    }
}
