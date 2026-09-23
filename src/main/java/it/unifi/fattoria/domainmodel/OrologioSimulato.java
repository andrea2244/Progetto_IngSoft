package it.unifi.fattoria.domainmodel;

// Persona B. Tiene il tempo della simulazione (un tick = un giorno).
public class OrologioSimulato {
    private int giorno = 0;

    public int getGiorno() { return giorno; }

    public void avanza() { giorno++; }
}
