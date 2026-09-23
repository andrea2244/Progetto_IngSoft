package it.unifi.fattoria.domainmodel;

import java.util.ArrayList;
import java.util.List;

// Persona B. Observer: il sensore è il Subject, la centralina l'Observer.
public class Sensore {
    private int id;
    private String tipo;
    private double valore;
    private final List<OsservatoreSensore> osservatori = new ArrayList<>();

    public Sensore(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getValore() { return valore; }

    public void aggiungiOsservatore(OsservatoreSensore o) { osservatori.add(o); }
    public void rimuoviOsservatore(OsservatoreSensore o) { osservatori.remove(o); }

    public void setValore(double valore) {
        this.valore = valore;
        for (OsservatoreSensore o : osservatori) {
            o.aggiorna(this);
        }
    }
}
