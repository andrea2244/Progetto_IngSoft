package it.unifi.fattoria.domainmodel;

// Persona A. TODO: aggiungere le altre fasi (Germoglio, Matura, ...).
public class FaseSeme implements FaseCrescita {
    @Override
    public void avanza(Coltura coltura, double umidita) {
        // TODO: usare coltura.getStrategia() per decidere se passare alla fase successiva
    }

    @Override
    public String getNome() { return "SEME"; }
}
