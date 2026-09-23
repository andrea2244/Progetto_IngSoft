package it.unifi.fattoria.domainmodel;

// Persona C. Raccolto presente in magazzino.
public class Prodotto {
    private int id;
    private String nome;
    private double quantita;

    public Prodotto(int id, String nome, double quantita) {
        this.id = id;
        this.nome = nome;
        this.quantita = quantita;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getQuantita() { return quantita; }
    public void setQuantita(double quantita) { this.quantita = quantita; }
}
