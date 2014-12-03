-- MySQL Script generated by MySQL Workbench
-- mer 03 dic 2014 11:21:39 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_integrazione
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_integrazione` ;

-- -----------------------------------------------------
-- Schema db_integrazione
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_integrazione` DEFAULT CHARACTER SET utf8 ;
USE `db_integrazione` ;

-- -----------------------------------------------------
-- Table `db_integrazione`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_integrazione`.`Account` ;

CREATE TABLE IF NOT EXISTS `db_integrazione`.`Account` (
  `email` VARCHAR(100) NOT NULL COMMENT 'Nome con il quale l\'utente viene riconosciuto da un',
  `password` VARCHAR(45) NOT NULL,
  `typeOfAccount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
COMMENT = 'Tabella adibita alla gestione dei dati principali per l\'acesso al sistema';


-- -----------------------------------------------------
-- Table `db_integrazione`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_integrazione`.`Department` ;

CREATE TABLE IF NOT EXISTS `db_integrazione`.`Department` (
  `abbreviation` VARCHAR(50) NOT NULL,
  `title` VARCHAR(50) NULL DEFAULT NULL,
  `url_moodle` VARCHAR(1000) NULL,
  `token` VARCHAR(200) NULL,
  PRIMARY KEY (`abbreviation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_integrazione`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_integrazione`.`Person` ;

CREATE TABLE IF NOT EXISTS `db_integrazione`.`Person` (
  `fiscal_code` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `zip_code` VARCHAR(45) NULL DEFAULT NULL,
  `gender` CHAR NULL DEFAULT NULL,
  `citizenship` VARCHAR(45) NULL DEFAULT NULL,
  `Account_email` VARCHAR(100) NOT NULL,
  `Department_abbreviation` VARCHAR(50) NOT NULL,
  `web_page` VARCHAR(300) NULL,
  `university` VARCHAR(200) NULL,
  `role` VARCHAR(100) NULL,
  `matricula` VARCHAR(10) NULL,
  PRIMARY KEY (`fiscal_code`),
  INDEX `fk_Person_Account_idx` (`Account_email` ASC),
  INDEX `fk_Person_Department1_idx` (`Department_abbreviation` ASC),
  CONSTRAINT `fk_Person_Account`
    FOREIGN KEY (`Account_email`)
    REFERENCES `db_integrazione`.`Account` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_Department1`
    FOREIGN KEY (`Department_abbreviation`)
    REFERENCES `db_integrazione`.`Department` (`abbreviation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;