package it.unifi.fattoria.businesslogic;

import it.unifi.fattoria.domainmodel.OrologioSimulato;

// Persona B. Casi d'uso: avanzamento del tempo, meteo, irrigazione automatica.
public class SimulazioneController {
    private final OrologioSimulato orologio = new OrologioSimulato();

    public void avanzaGiorno() {
        orologio.avanza();
        // TODO: aggiornare meteo, sensori e colture
    }

    public int getGiorno() { return orologio.getGiorno(); }
}
