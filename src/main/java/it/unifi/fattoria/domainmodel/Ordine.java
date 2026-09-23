package it.unifi.fattoria.domainmodel;

// Persona C
public class Ordine {
    private int id;
    private Utente utente;
    private Prodotto prodotto;
    private double quantita;

    public Ordine(int id, Utente utente, Prodotto prodotto, double quantita) {
        this.id = id;
        this.utente = utente;
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public int getId() { return id; }
    public Utente getUtente() { return utente; }
    public Prodotto getProdotto() { return prodotto; }
    public double getQuantita() { return quantita; }
}
