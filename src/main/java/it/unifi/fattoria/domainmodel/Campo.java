package it.unifi.fattoria.domainmodel;

import java.util.ArrayList;
import java.util.List;

// Persona A
public class Campo {
    private int id;
    private String nome;
    private double superficie;
    private final List<Coltura> colture = new ArrayList<>();

    public Campo(int id, String nome, double superficie) {
        this.id = id;
        this.nome = nome;
        this.superficie = superficie;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getSuperficie() { return superficie; }
    public List<Coltura> getColture() { return colture; }

    public void aggiungiColtura(Coltura coltura) { colture.add(coltura); }
}
