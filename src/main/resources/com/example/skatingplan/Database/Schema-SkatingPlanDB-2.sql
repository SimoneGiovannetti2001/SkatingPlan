SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

/*
Distruzione schema se esistenze
*/

DROP SCHEMA IF EXISTS `SkatingPlanDB`;

/*
Creazione schema
*/
CREATE SCHEMA IF NOT EXISTS `SkatingPlanDB`;
USE `SkatingPlanDB`;

/*
Schema Tabella Utenti
*/

DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
    `id_utente` INT UNSIGNED AUTO_INCREMENT,
    `nome` VARCHAR(30) NOT NULL,
    `cognome` VARCHAR(35) NOT NULL,
    `email` VARCHAR(40) NOT NULL UNIQUE,
    `ruolo` INT NOT NULL ,
    `password` CHAR(32) NOT NULL,
    PRIMARY KEY (`id_utente`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

/*
Schema Tabella atleta
*/

DROP TABLE IF EXISTS `allenatore`;
CREATE TABLE IF NOT EXISTS `allenatore`(
	`id_allenatore` INT UNSIGNED AUTO_INCREMENT,
    `qualifica` ENUM('FIRS1', 'FISR2', 'FISR3'),
    `tariffa_oraria` INT NOT NULL,
    `id_utente`INT UNSIGNED,
    PRIMARY KEY (`id_allenatore`),
    FOREIGN KEY (`id_utente`) REFERENCES `Utente`(`id_utente`) ON DELETE CASCADE
)ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

/*
Schema Tabella allenatore
*/

DROP TABLE IF EXISTS `atleta`;
CREATE TABLE IF NOT EXISTS `atleta`(
	`id_atleta` INT UNSIGNED AUTO_INCREMENT,
    `livello` ENUM('PRIMI_PASSI', 'PREAGONISMO', 'AGONISMO'),
    `id_utente`INT UNSIGNED,
    PRIMARY KEY (`id_atleta`),
    FOREIGN KEY (`id_utente`) REFERENCES `Utente`(`id_utente`) ON DELETE CASCADE
)ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

/*
Schema Tabella Lezione
*/

DROP TABLE IF EXISTS `lezione`;
CREATE TABLE IF NOT EXISTS `lezione`(
	`id_lezione` INT UNSIGNED AUTO_INCREMENT,
    `data` DATE NOT NULL,
    `ora_inizio` TIME NOT NULL,
    `durata` INT NOT NULL,
    `stato_lezione` ENUM('DISPONIBILE', 'RICHIESTA', 'CONFERMATA', 'CANCELLATA') NOT NULL DEFAULT 'DISPONIBILE',
    `atleta` INT UNSIGNED DEFAULT NULL,
    `allenatore` INT UNSIGNED NOT NULL,
    `pista` INT UNSIGNED NOT NULL,
	CHECK (durata IN (60, 90, 120, 150, 180)),
    PRIMARY KEY (`id_lezione`),
    FOREIGN KEY (`atleta`) REFERENCES `atleta`(`id_atleta`) ON DELETE CASCADE,
    FOREIGN KEY (`allenatore`) REFERENCES `allenatore`(`id_allenatore`) ON DELETE CASCADE,
	FOREIGN KEY (`pista`) REFERENCES `pistadipattinaggio`(`id_pista`) ON DELETE CASCADE
)ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

/*
Schema Tabella PistaDiPattinaggio
*/

DROP TABLE IF EXISTS `pistadipattinaggio`;
CREATE TABLE IF NOT EXISTS `pistadipattinaggio`(
	`id_pista` INT UNSIGNED AUTO_INCREMENT,
	`nome_pista` VARCHAR(40) NOT NULL,
	`via` VARCHAR(30) NOT NULL,
    `civico` VARCHAR(10) NOT NULL,
    `regione` VARCHAR(30) NOT NULL,
    `tipo_pavimento` ENUM('CEMENTO', 'PARQUET', 'RESINA') NOT NULL,
    PRIMARY KEY (`id_pista`),
	CHECK (regione IN (
        'ABRUZZO',
        'BASILICATA',
        'CALABRIA',
        'CAMPANIA',
        'EMILIA_ROMAGNA',
        'FRIULI_VENEZIA_GIULIA',
        'LAZIO',
        'LIGURIA',
        'LOMBARDIA',
        'MARCHE',
        'MOLISE',
        'PIEMONTE',
        'PUGLIA',
        'SARDEGNA',
        'SICILIA',
        'TOSCANA',
        'TRENTINO_ALTO_ADIGE',
        'UMBRIA',
        'VALLE_D_AOSTA',
        'VENETO'
    ))
)ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

/*
Schema Tabella Pagamento
*/

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE IF NOT EXISTS `pagamento`(
	`id_pagamento` INT UNSIGNED AUTO_INCREMENT,
    `tipologia` ENUM('ONLINE', 'LEZIONE') NOT NULL,
    `data` DATE NOT NULL,
    `importo` INT UNSIGNED NOT NULL,
    `id_lezione` INT UNSIGNED UNIQUE,
    `stato_pagamento` ENUM('IN_ATTESA', 'COMPLETATO', 'FALLITO') NOT NULL DEFAULT 'IN_ATTESA',
    PRIMARY KEY (`id_pagamento`),
    FOREIGN KEY (`id_lezione`) REFERENCES `lezione`(`id_lezione`) ON DELETE CASCADE
)ENGINE=innoDB DEFAULT CHARSET=utf8mb4;


/*
Creazione stored procedure
*/

-- seleziona_prenotazioni
DROP PROCEDURE IF EXISTS `seleziona_prenotazioni`;
DELIMITER $$
CREATE PROCEDURE `seleziona_prenotazioni`(IN p_idAtleta INT)
BEGIN
	SELECT id_lezione, data, ora_inizio, durata, stato_lezione, atleta, allenatore, pista
    FROM lezione
    WHERE atleta = p_idAtleta;
END$$

DELIMITER ;

-- cambia_stato
DROP PROCEDURE IF EXISTS `cambia_stato`;
DELIMITER $$
CREATE PROCEDURE `cambia_stato`(IN p_Idlezione INT, IN p_nuovo_stato ENUM('DISPONIBILE', 'RICHIESTA', 'CONFERMATA', 'CANCELLATA'))
BEGIN
	UPDATE lezione
    SET stato_lezione = p_nuovo_stato
    WHERE id_lezione = p_Idlezione;
END$$

DELIMITER ;

-- associa_atleta
DROP PROCEDURE IF EXISTS `associa_atleta`;
DELIMITER $$
CREATE PROCEDURE `associa_atleta`(IN p_Idlezione INT, IN p_idAtleta INT)
BEGIN
	UPDATE lezione
    SET atleta = p_idAtleta
    WHERE id_lezione = p_Idlezione;
END$$

DELIMITER ;  

-- seleziona_lezioni
DROP PROCEDURE IF EXISTS `seleziona_lezioni`;
DELIMITER $$
CREATE PROCEDURE `seleziona_lezioni`(IN p_data_lezione DATE, IN p_ora_lezione TIME, IN p_regione VARCHAR(30))
BEGIN
	SELECT l.id_lezione, l.data, l.ora_inizio, l.durata, u.nome, u.cognome, a.qualifica, a.tariffa_oraria, p.nome_pista, 
           p.via, p.civico, p.regione, p.tipo_pavimento, a.tariffa_oraria*l.durata/60 as costo
    FROM lezione l JOIN allenatore a
    ON l.allenatore = a.id_allenatore
    JOIN pistadipattinaggio p ON p.id_pista = l.pista
    JOIN utente u ON u.id_utente = a.id_utente
    WHERE l.data = p_data_lezione 
    AND l.ora_inizio BETWEEN p_ora_lezione
	AND DATE_ADD(p_ora_lezione, INTERVAL 2 HOUR)
    AND p.regione = p_regione
    AND l.stato_lezione = 'DISPONIBILE';
END$$

DELIMITER ; 

-- recupera_profilo_atleta
DROP PROCEDURE IF EXISTS `recupera_profilo_atleta`;
DELIMITER $$
CREATE PROCEDURE `recupera_profilo_atleta`(IN p_idUtente INT)
BEGIN
	SELECT a.livello
    FROM utente u JOIN atleta a
    ON u.id_utente = a.id_utente
    WHERE u.id_utente = p_id_utente;
END$$

DELIMITER ; 

-- recupera_profilo_allenatore
DROP PROCEDURE IF EXISTS `recupera_profilo_allenatore`;
DELIMITER $$
CREATE PROCEDURE `recupera_profilo_allenatore`(IN p_idUtente INT)
BEGIN
	SELECT a.qualifica, tariffa_oraria
    FROM utente u JOIN allenatore a
    ON u.id_utente = a.id_utente
    WHERE u.id_utente = p_id_utente;
END$$

DELIMITER ; 



-- seleziona_richieste_allenatore
DROP PROCEDURE IF EXISTS `seleziona_richieste_allenatore`;
DELIMITER $$
CREATE PROCEDURE `seleziona_richieste_allenatore`(IN p_allenatore INT)
BEGIN
	SELECT l.id_lezione, l.data, l.ora_inizio, l.durata, al.tariffa_oraria*l.durata/60 as costo, p.nome_pista, p.via, p.civico, p.regione, p.tipo_pavimento, a.livello, u.nome, u.cognome
    FROM lezione l 
    JOIN atleta a ON l.atleta = a.id_atleta
    JOIN utente u ON a.id_utente = u.id_utente
    JOIN pistadipattinaggio p ON l.pista = p.id_pista
    JOIN allenatore al ON al.id_allenatore = l.allenatore
    JOIN utente u2 ON u2.id_utente = al.id_utente
    WHERE l.stato_lezione = 'RICHIESTA' AND u2.id_utente = p_allenatore;

END$$

DELIMITER ;


-- inserisci pagamento
DROP PROCEDURE IF EXISTS `inserisci_pagamento`;
DELIMITER $$
CREATE PROCEDURE `inserisci_pagamento`(IN p_tipologia ENUM('ONLINE','LEZIONE'), IN p_data DATE, IN p_importo INT, p_idLezione INT,IN p_stato ENUM('IN_ATTESA', 'COMPLETATO', 'FALLITO'))
BEGIN
	INSERT INTO `pagamento` (tipologia, data, importo, id_lezione, stato_pagamento)
    VALUES (p_tipologia, p_data, p_importo, p_idLezione, p_stato);
END$$


-- aggiorna pagamento
DROP PROCEDURE IF EXISTS `aggiorna_pagamento`;
DELIMITER $$
CREATE PROCEDURE `aggiorna_pagamento`(IN p_idLezione INT, IN p_nuovo_stato ENUM('IN_ATTESA', 'COMPLETATO', 'FALLITO'))
BEGIN
	UPDATE pagamento
    SET stato_pagamento = p_nuovo_stato
    WHERE id_lezione = p_Idlezione;
END$$

DELIMITER ;

-- annulla pagamento
DROP PROCEDURE IF EXISTS `annulla_pagamento`;
DELIMITER $$
CREATE PROCEDURE `annulla_pagamento`(IN p_idLezione INT)
BEGIN
	DELETE FROM pagamento
    WHERE id_lezione = p_Idlezione;
END$$

DELIMITER ;

-- login
DROP PROCEDURE IF EXISTS `login`;
DELIMITER $$
CREATE PROCEDURE `login`(IN nome_utente VARCHAR(30), IN password_utente CHAR(16))
BEGIN
	-- Vedo il ruolo dell' utente
    SELECT nome, cognome, email, ruolo, id_utente, password
	FROM utente 
	WHERE nome = nome_utente
    AND password = md5(password_utente);
    
END$$

DELIMITER ;
    
/*
creazioni trigger
*/
DROP TRIGGER IF EXISTS check_aggiornamento_lezione;
DELIMITER $$
CREATE TRIGGER check_aggiornamento_lezione
BEFORE UPDATE ON lezione
FOR EACH ROW
BEGIN
    -- eseguo i controlli SOLO se cambia lo stato
    IF OLD.stato_lezione <> NEW.stato_lezione THEN
        IF OLD.stato_lezione = 'DISPONIBILE'
           AND NEW.stato_lezione <> 'RICHIESTA' THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Errore: Cambio stato non valido 1';
        END IF;
        IF OLD.stato_lezione = 'RICHIESTA'
           AND NEW.stato_lezione NOT IN ('CONFERMATA', 'CANCELLATA', 'RICHIESTA') THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Errore: Cambio stato non valido 2';
        END IF;
        IF OLD.stato_lezione = 'PAGATA' THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Errore: Stato PAGATA non può essere modificato';
        END IF;
    END IF;
END$$

DELIMITER ;

-- utenti

-- login
DROP USER IF EXISTS `login`;
CREATE USER `login` IDENTIFIED BY 'login';
GRANT EXECUTE ON PROCEDURE `login` TO `login`;

-- atleta
DROP USER IF EXISTS `atleta`;
CREATE USER `atleta` IDENTIFIED BY 'atleta';
GRANT EXECUTE ON PROCEDURE `seleziona_lezioni` TO `atleta`;
GRANT EXECUTE ON PROCEDURE `cambia_stato` TO `atleta`;
GRANT EXECUTE ON PROCEDURE `inserisci_pagamento` TO `atleta`;
GRANT EXECUTE ON PROCEDURE `associa_atleta` TO `atleta`;
GRANT EXECUTE ON PROCEDURE `recupera_profilo_atleta` TO `atleta`;
GRANT EXECUTE ON PROCEDURE `aggiorna_pagamento` TO `atleta`;


-- allenatore
DROP USER IF EXISTS `allenatore`;
CREATE USER `allenatore` IDENTIFIED BY 'allenatore';
GRANT EXECUTE ON PROCEDURE `seleziona_richieste_allenatore` TO `allenatore`;
GRANT EXECUTE ON PROCEDURE `cambia_stato` TO `allenatore`;
GRANT EXECUTE ON PROCEDURE `annulla_pagamento` TO `allenatore`;


-- manager
DROP USER IF EXISTS `manager`;
CREATE USER `manager` IDENTIFIED BY 'manager';
GRANT EXECUTE ON PROCEDURE `recupera_profilo_allenatore` TO `manager`;


-- popolamento tabelle

-- utente
INSERT INTO `utente` (nome,cognome,email,ruolo,password)
VALUES ('Simone', 'Giovannetti', 'simo.giova@gmail.com', 1, md5('simone')),
	   ('Federico', 'Filipponi', 'fede.filippo@gmail.com', 2, md5('federico')),
       ('Max', 'Quirini', 'max.quiri@gmail.com', 3, md5('max'));

-- allenatore
INSERT INTO `allenatore` (qualifica, tariffa_oraria, id_utente)
VALUES ('FISR2',  35, 2);

-- atleta
INSERT INTO `atleta` (livello, id_utente)
VALUES ('AGONISMO', 1);

-- lezione
INSERT INTO `lezione` (data, ora_inizio, durata, allenatore, pista)
VALUES ('2026-06-20', '14:30:00', 60, 1, 1),
	   ('2026-06-20', '15:30:00', 60, 1, 1),
	   ('2026-06-21', '14:00:00', 120, 1, 1);

-- pista di pattinaggio
INSERT INTO `pistadipattinaggio` (nome_pista, via, civico, regione, tipo_pavimento)
VALUES ('Palaghiaccio Mezzaluna', 'via dello sport', '12', 'LAZIO', 'RESINA');

    
select * from lezione;

select * from pagamento;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
