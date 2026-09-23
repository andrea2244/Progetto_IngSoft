package it.unifi.fattoria.domainmodel;

// Persona A. Contesto del pattern State (fase) e Strategy (regole di crescita).
public class Coltura {
    private int id;
    private String tipo;
    private FaseCrescita fase;
    private StrategiaCrescita strategia;

    public Coltura(int id, String tipo, StrategiaCrescita strategia) {
        this.id = id;
        this.tipo = tipo;
        this.strategia = strategia;
        this.fase = new FaseSeme();
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public FaseCrescita getFase() { return fase; }
    public void setFase(FaseCrescita fase) { this.fase = fase; }
    public StrategiaCrescita getStrategia() { return strategia; }

    // Chiamato dalla simulazione a ogni giorno che passa
    public void cresci(double umidita) {
        fase.avanza(this, umidita);
    }
}
