-- Schema del database. Ognuno aggiunge le proprie tabelle nella sua sezione.

-- ===== Persona A: campi e colture =====
CREATE TABLE IF NOT EXISTS campo (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    superficie DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS coltura (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    campo_id INT NOT NULL REFERENCES campo(id),
    tipo     VARCHAR(50) NOT NULL,
    fase     VARCHAR(30) NOT NULL
);

-- ===== Persona B: simulazione e sensori =====
CREATE TABLE IF NOT EXISTS sensore (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    campo_id INT NOT NULL REFERENCES campo(id),
    tipo     VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS operazione (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    campo_id  INT NOT NULL REFERENCES campo(id),
    tipo      VARCHAR(30) NOT NULL,
    giorno    INT NOT NULL
);

-- ===== Persona C: utenti, magazzino, vendite =====
CREATE TABLE IF NOT EXISTS utente (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    ruolo    VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS prodotto (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    quantita DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS ordine (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    utente_id   INT NOT NULL REFERENCES utente(id),
    prodotto_id INT NOT NULL REFERENCES prodotto(id),
    quantita    DOUBLE NOT NULL
);
