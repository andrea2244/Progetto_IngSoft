package it.unifi.fattoria.domainmodel;

// Persona C
public class Utente {
    private int id;
    private String username;
    private Ruolo ruolo;

    public Utente(int id, String username, Ruolo ruolo) {
        this.id = id;
        this.username = username;
        this.ruolo = ruolo;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public Ruolo getRuolo() { return ruolo; }
}
