# Simulatore Fattoria

Progetto d'esame di Software Engineering, A.A. 25/26 (Prof. Enrico Vicario), modalità #2.

Autori: _Nome Cognome_, _Nome Cognome_, _Nome Cognome_

## Requisiti

- Java 21 o superiore
- Maven 3.9 o superiore
- Git

## Comandi

| Cosa | Comando |
|---|---|
| Compilare | `mvn compile` |
| Eseguire i test | `mvn test` |
| Avviare il programma | `mvn compile exec:java` |

Il database è H2 in modalità embedded: non va installato nulla. Il file viene creato
in `data/`, che non finisce su GitHub, quindi ognuno ha la propria copia locale.
Lo schema delle tabelle sta in `src/main/resources/schema.sql`.

## Struttura

```
src/main/java/it/unifi/fattoria/
├── domainmodel/     entità del dominio (Campo, Coltura, Sensore, Utente, ...)
├── orm/             accesso al database: ConnectionManager e DAO
├── businesslogic/   controller, uno per gruppo di casi d'uso
└── main/            punto di avvio
src/test/java/...    test JUnit 5 + Mockito, stessi package
docs/
├── uml/             diagrammi (use case, classi, package, ER, sequence)
├── mockup/          mockup e diagramma di navigazione
└── relazione/       relazione finale in PDF
```

## Divisione del lavoro

| | Persona A: campi e colture | Persona B: simulazione e sensori | Persona C: utenti, magazzino, vendite |
|---|---|---|---|
| Casi d'uso | piantare, gestire appezzamenti, raccogliere | avanzamento del tempo, meteo, irrigazione automatica | login/registrazione, magazzino, ordini e vendite |
| Domain model | Campo, Coltura, fasi di crescita | Sensore, Centralina, OrologioSimulato | Utente, Ruolo, Prodotto, Ordine |
| Design pattern | State (fasi), Strategy (crescita) | Observer (sensori → centralina) | Factory (utenti), Singleton (ConnectionManager) |
| DAO | CampoDAO, ColturaDAO | SensoreDAO, OperazioneDAO | UtenteDAO, ProdottoDAO, OrdineDAO |
| Controller | ColtivazioneController | SimulazioneController | LoginController, MagazzinoController |
| Test | funzionali sui propri casi d'uso, unit sulla crescita | unit sulla simulazione | funzionali login/ordini, test DAO |

Ognuno lavora soprattutto sui propri file: così i conflitti su Git sono rari.
I file condivisi (`schema.sql`, `pom.xml`, `README.md`) vanno modificati con attenzione,
e conviene avvisare gli altri nel gruppo.

## Come lavorare con Git

**Prima volta** (ognuno sul proprio computer):

```bash
git clone https://github.com/andrea2244/Progetto_IngSoft.git
cd Progetto_IngSoft
mvn test
```

**Ogni volta che si lavora:**

1. Scarica le modifiche degli altri **prima** di iniziare:
   ```bash
   git pull
   ```
2. Lavora e verifica che tutto compili e che i test passino:
   ```bash
   mvn test
   ```
3. Salva e carica le modifiche:
   ```bash
   git add .
   git commit -m "Breve descrizione di cosa hai fatto"
   git pull
   git push
   ```

Regole:
- Non fare push di codice che non compila: blocca anche gli altri.
- Fai commit piccoli e frequenti, con messaggi chiari.
- Se `git pull` segnala un **conflitto**, apri i file indicati, scegli la versione giusta
  tra i segni `<<<<<<<` e `>>>>>>>`, poi `git add .`, `git commit` e `git push`.

## Uso dell'AI generativa

Il disciplinare chiede di documentare ogni uso dell'AI: per quali parti, con quali strumenti
e come è stato integrato nel lavoro. Annotate qui man mano, così la relazione sarà facile da scrivere.

| Data | Chi | Strumento | Per cosa |
|---|---|---|---|
| 23/09/2026 | | Claude Code | Generazione dello scheletro del progetto (pom.xml, package, classi vuote, README) |
