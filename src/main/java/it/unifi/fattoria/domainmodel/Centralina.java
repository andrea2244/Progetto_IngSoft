package it.unifi.fattoria.domainmodel;

// Persona B. Riceve le letture dei sensori e comanda gli attuatori.
public class Centralina implements OsservatoreSensore {
    @Override
    public void aggiorna(Sensore sensore) {
        // TODO: es. se l'umidità è bassa, accendere l'irrigatore
    }
}
