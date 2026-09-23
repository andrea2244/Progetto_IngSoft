package it.unifi.fattoria.domainmodel;

// Persona A. State: ogni fase decide quando passare alla successiva.
public interface FaseCrescita {
    void avanza(Coltura coltura, double umidita);
    String getNome();
}
