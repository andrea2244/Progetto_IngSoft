# Class diagram: piante e meteo (bozza)

Aree: Emma (piante, appezzamenti, coltivazione) e Liam (fattoria, meteo, simulazione).
Pattern: **State** (fasi della pianta), **Observer** (eventi della pianta), **Strategy** (effetti del meteo).

> Bozza rivista con l'aiuto di Claude Code, da discutere e approvare insieme prima di scrivere il codice.

```mermaid
classDiagram
  direction TB

  %% ===== Enumerazioni =====
  class TipoPianta {
    <<enumeration>>
    POMODORO
    GRANO
    LATTUGA
    ZUCCHINA
  }
  class LivelloAcqua {
    <<enumeration>>
    SECCO
    OK
    TROPPA_ACQUA
  }
  class TipoMeteo {
    <<enumeration>>
    SOLE
    NUVOLOSO
    PIOGGIA
  }
  class IntensitaMeteo {
    <<enumeration>>
    NEUTRA
    FORTE
    MOLTO_FORTE
  }
  class TipoEvento {
    <<enumeration>>
    CAMBIO_FASE
    PIANTA_MORTA
    INFESTAZIONE
  }

  %% ===== Piante (Emma) =====
  class ConfigurazioneSpecie {
    <<record>>
    TipoPianta tipo
    String nome
    int giorniNeonata
    int giorniAdulta
    int giorniAnziana
    int maxGiorniStress
    double resaKg
  }
  class CatalogoSpecie {
    +get(TipoPianta tipo) ConfigurazioneSpecie
  }
  class Pianta {
    -ConfigurazioneSpecie specie
    -FasePianta fase
    -LivelloAcqua acqua
    -boolean infestata
    -int giorniNellaFase
    -int giorniStress
    -List~OsservatorePianta~ osservatori
    +Pianta(ConfigurazioneSpecie specie)
    +passaGiorno() void
    +cambiaFase(FasePianta nuova) void
    +setAcqua(LivelloAcqua livello) void
    +infesta() void
    +curaInfestazione() void
    +isRaccoglibile() boolean
    +aggiungiOsservatore(OsservatorePianta o) void
    -notifica(TipoEvento e) void
  }
  class FasePianta {
    <<interface>>
    +passaGiorno(Pianta p) void
    +isRaccoglibile() boolean
    +getNome() String
  }
  class FaseNeonata
  class FaseAdulta
  class FaseAnziana
  class FaseMorta
  class Appezzamento {
    -int id
    -TipoPianta ultimoTipoPiantato
    -Pianta pianta
    -boolean irrigazioneAutomatica
    +semina(ConfigurazioneSpecie specie) Pianta
    +rimuoviPianta() void
    +annaffia() void
    +trattaInfestazione() void
    +setIrrigazioneAutomatica(boolean attiva) void
    +controllaIrrigazione() void
    +hasPianta() boolean
    +getPianta() Pianta
  }
  class ColtivazioneController {
    -Fattoria fattoria
    -CatalogoSpecie catalogo
    -OsservatorePianta osservatore
    -MagazzinoController magazzino
    +semina(int appezzamentoId, TipoPianta tipo) Pianta
    +annaffia(int appezzamentoId) void
    +trattaInfestazione(int appezzamentoId) void
    +raccogli(int appezzamentoId) double
  }

  %% ===== Simulazione e meteo (Liam) =====
  class Fattoria {
    -int giornoCorrente
    -List~Appezzamento~ appezzamenti
    +Fattoria(int numeroAppezzamenti)
    +getAppezzamento(int id) Appezzamento
    +getAppezzamenti() List~Appezzamento~
    +avanzaCalendario() void
    +getGiornoCorrente() int
  }
  class Meteo {
    -TipoMeteo tipo
    -IntensitaMeteo intensita
    -EffettoMeteo effetto
    -Random random
    +Meteo(Random random)
    +generaCasuale() void
    +imposta(TipoMeteo tipo, IntensitaMeteo intensita) void
    +applicaA(Appezzamento a) void
  }
  class EffettoMeteo {
    <<interface>>
    +applica(Appezzamento a, IntensitaMeteo intensita) void
  }
  class EffettoSole
  class EffettoNuvoloso
  class EffettoPioggia
  class OsservatorePianta {
    <<interface>>
    +onEvento(Pianta p, TipoEvento tipo) void
  }
  class Evento {
    <<record>>
    int giorno
    Pianta pianta
    TipoEvento tipo
  }
  class SimulazioneController {
    -Fattoria fattoria
    -Meteo meteo
    -Random random
    -List~Evento~ eventiDelGiorno
    +avanzaGiorno() List~Evento~
    +avanzaFinoAEvento(int maxGiorni) List~Evento~
    +onEvento(Pianta p, TipoEvento tipo) void
  }

  %% ===== Andrea =====
  class MagazzinoController {
    <<Andrea>>
    +aggiungiRaccolto(TipoPianta tipo, double kg) void
  }

  %% ===== Relazioni =====
  Fattoria "1" *-- "1..*" Appezzamento : contiene
  Appezzamento "1" *-- "0..1" Pianta : ospita
  Pianta --> "1" ConfigurazioneSpecie : specie
  CatalogoSpecie --> "*" ConfigurazioneSpecie

  Pianta --> "1" FasePianta : fase corrente
  FaseNeonata ..|> FasePianta
  FaseAdulta ..|> FasePianta
  FaseAnziana ..|> FasePianta
  FaseMorta ..|> FasePianta

  Pianta --> "0..*" OsservatorePianta : notifica
  SimulazioneController ..|> OsservatorePianta
  SimulazioneController ..> Evento : registra

  Meteo --> "1" EffettoMeteo : effetto corrente
  EffettoSole ..|> EffettoMeteo
  EffettoNuvoloso ..|> EffettoMeteo
  EffettoPioggia ..|> EffettoMeteo
  EffettoMeteo ..> Appezzamento : modifica acqua

  SimulazioneController --> Fattoria
  SimulazioneController --> Meteo
  ColtivazioneController --> Fattoria
  ColtivazioneController --> CatalogoSpecie
  ColtivazioneController ..> OsservatorePianta : registra
  ColtivazioneController ..> MagazzinoController : raccolto
```

## Da decidere insieme

- [ ] Di quanto cambia l'acqua con sole / pioggia per ogni intensità
- [ ] Si può raccogliere anche in `FaseAnziana`?
- [ ] Probabilità di infestazione al giorno
- [ ] `CatalogoSpecie`: dati scritti nel codice o letti dal database?
