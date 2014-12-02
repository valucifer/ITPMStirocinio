SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`permissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`permissions` ;

CREATE TABLE IF NOT EXISTS `mydb`.`permissions` (
  `id_permissions` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `class` VARCHAR(45) NULL,
  PRIMARY KEY (`id_permissions`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`account` ;

CREATE TABLE IF NOT EXISTS `mydb`.`account` (
  `id_account` BIGINT NOT NULL COMMENT 'Identificativo univoco per qualsiasi utente si voglia loggare al sistema',
  `usermame` VARCHAR(45) NOT NULL COMMENT 'Nome con il quale l\'utente viene riconosciuto da un',
  `password` VARCHAR(45) NOT NULL,
  `type_of_account` VARCHAR(45) NULL,
  `fk_permission` INT NOT NULL,
  PRIMARY KEY (`id_account`),
  INDEX `fk_Account_Permissions_idx` (`fk_permission` ASC),
  CONSTRAINT `fk_Account_Permissions`
    FOREIGN KEY (`fk_permission`)
    REFERENCES `mydb`.`permissions` (`id_permissions`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Tabella adibita alla gestione dei dati principali per l\'aces /* comment truncated */ /*so al sistema*/';


-- -----------------------------------------------------
-- Table `mydb`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`department` ;

CREATE TABLE IF NOT EXISTS `mydb`.`department` (
  `id_department` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_department`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`natural_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`natural_person` ;

CREATE TABLE IF NOT EXISTS `mydb`.`natural_person` (
  `id_natural_person` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `zip_code` VARCHAR(45) NULL,
  `gender` CHAR NULL,
  `citizenship` VARCHAR(45) NULL,
  `cf` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_natural_person`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`student_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`student_status` ;

CREATE TABLE IF NOT EXISTS `mydb`.`student_status` (
  `id_student_status` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_student_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`training_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`training_status` ;

CREATE TABLE IF NOT EXISTS `mydb`.`training_status` (
  `id_training_status` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_training_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`professor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`professor` (
  `id_professor` INT NOT NULL,
  `position` VARCHAR(45) NULL,
  `office_phone` VARCHAR(45) NULL,
  `office_hours` VARCHAR(45) NULL,
  `office_email` VARCHAR(45) NULL,
  `fk_account` BIGINT NOT NULL,
  `fk_natural_person` INT NOT NULL,
  `fk_department` INT NOT NULL,
  PRIMARY KEY (`id_professor`),
  INDEX `fk_Professor_Account1_idx` (`fk_account` ASC),
  INDEX `fk_Professor_FisicPerson1_idx` (`fk_natural_person` ASC),
  INDEX `fk_Professor_Department1_idx` (`fk_department` ASC),
  CONSTRAINT `fk_Professor_Account1`
    FOREIGN KEY (`fk_account`)
    REFERENCES `mydb`.`account` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_FisicPerson1`
    FOREIGN KEY (`fk_natural_person`)
    REFERENCES `mydb`.`natural_person` (`id_natural_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_Department1`
    FOREIGN KEY (`fk_department`)
    REFERENCES `mydb`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`organization` ;

CREATE TABLE IF NOT EXISTS `mydb`.`organization` (
  `id_organization` INT NOT NULL AUTO_INCREMENT,
  `companyName` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `fk_account` BIGINT NOT NULL,
  `fk_natural_person` INT NULL,
  `fk_professor` INT NOT NULL,
  PRIMARY KEY (`id_organization`),
  INDEX `fk_Organization_Account1_idx` (`fk_account` ASC),
  INDEX `fk_Organization_FisicPerson1_idx` (`fk_natural_person` ASC),
  INDEX `fk_Organization_Professor1_idx` (`fk_professor` ASC),
  CONSTRAINT `fk_Organization_Account1`
    FOREIGN KEY (`fk_account`)
    REFERENCES `mydb`.`account` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Organization_FisicPerson1`
    FOREIGN KEY (`fk_natural_person`)
    REFERENCES `mydb`.`natural_person` (`id_natural_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Organization_Professor1`
    FOREIGN KEY (`fk_professor`)
    REFERENCES `mydb`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`training_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`training_request` ;

CREATE TABLE IF NOT EXISTS `mydb`.`training_request` (
  `id_training_request` INT NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL,
  `title` VARCHAR(45) NULL,
  `fk_training_status` INT NOT NULL,
  `fk_professor` INT NOT NULL,
  `fk_organization` INT NULL,
  PRIMARY KEY (`id_training_request`),
  INDEX `fk_ClaimTraining_ClaimStatus1_idx` (`fk_training_status` ASC),
  INDEX `fk_ClaimTraining_Professor1_idx` (`fk_professor` ASC),
  INDEX `fk_ClaimTraining_Organization1_idx` (`fk_organization` ASC),
  CONSTRAINT `fk_ClaimTraining_ClaimStatus1`
    FOREIGN KEY (`fk_training_status`)
    REFERENCES `mydb`.`training_status` (`id_training_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClaimTraining_Professor1`
    FOREIGN KEY (`fk_professor`)
    REFERENCES `mydb`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClaimTraining_Organization1`
    FOREIGN KEY (`fk_organization`)
    REFERENCES `mydb`.`organization` (`id_organization`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`student_information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`student_information` ;

CREATE TABLE IF NOT EXISTS `mydb`.`student_information` (
  `id_student_information` INT NULL AUTO_INCREMENT,
  `curriculum_vitae_path` VARCHAR(200) NULL,
  `accademic_transcript_path` VARCHAR(200) NULL,
  PRIMARY KEY (`id_student_information`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`student` ;

CREATE TABLE IF NOT EXISTS `mydb`.`student` (
  `student_number` VARCHAR(45) NOT NULL,
  `cover_letter` LONGTEXT NULL,
  `year_enrollment` DATE NULL,
  `cycle` INT NULL,
  `university_email` VARCHAR(45) NULL,
  `fk_account` BIGINT NOT NULL,
  `fk_natural_person` INT NOT NULL,
  `fk_department` INT NOT NULL,
  `fk_student_status` INT NULL,
  `fk_training_request` INT NULL,
  `fk_student_information` INT NULL,
  PRIMARY KEY (`student_number`),
  INDEX `fk_Student_Account1_idx` (`fk_account` ASC),
  INDEX `fk_Student_Department1_idx` (`fk_department` ASC),
  INDEX `fk_Student_FisicPerson1_idx` (`fk_natural_person` ASC),
  INDEX `fk_Student_StudentStatus1_idx` (`fk_student_status` ASC),
  INDEX `fk_student_training_request1_idx` (`fk_training_request` ASC),
  INDEX `fk_student_student_information1_idx` (`fk_student_information` ASC),
  CONSTRAINT `fk_Student_Account1`
    FOREIGN KEY (`fk_account`)
    REFERENCES `mydb`.`account` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Department1`
    FOREIGN KEY (`fk_department`)
    REFERENCES `mydb`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_FisicPerson1`
    FOREIGN KEY (`fk_natural_person`)
    REFERENCES `mydb`.`natural_person` (`id_natural_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_StudentStatus1`
    FOREIGN KEY (`fk_student_status`)
    REFERENCES `mydb`.`student_status` (`id_student_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_training_request1`
    FOREIGN KEY (`fk_training_request`)
    REFERENCES `mydb`.`training_request` (`id_training_request`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_student_information1`
    FOREIGN KEY (`fk_student_information`)
    REFERENCES `mydb`.`student_information` (`id_student_information`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`staff` ;

CREATE TABLE IF NOT EXISTS `mydb`.`staff` (
  `id_staff` INT NOT NULL,
  `office_phone` VARCHAR(45) NULL,
  `office_email` VARCHAR(45) NULL,
  `fk_department` INT NOT NULL,
  `fk_account` BIGINT NOT NULL,
  `fk_natural_person` INT NOT NULL,
  PRIMARY KEY (`id_staff`),
  INDEX `fk_Staff_Department1_idx` (`fk_department` ASC),
  INDEX `fk_Staff_Account1_idx` (`fk_account` ASC),
  INDEX `fk_Staff_FisicPerson1_idx` (`fk_natural_person` ASC),
  CONSTRAINT `fk_Staff_Department1`
    FOREIGN KEY (`fk_department`)
    REFERENCES `mydb`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Staff_Account1`
    FOREIGN KEY (`fk_account`)
    REFERENCES `mydb`.`account` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Staff_FisicPerson1`
    FOREIGN KEY (`fk_natural_person`)
    REFERENCES `mydb`.`natural_person` (`id_natural_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pending_acceptance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pending_acceptance` ;

CREATE TABLE IF NOT EXISTS `mydb`.`pending_acceptance` (
  `id_pending_acceptance` INT NOT NULL AUTO_INCREMENT,
  `date_request` DATE NULL,
  `fk_student` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pending_acceptance`),
  INDEX `fk_StudentAttendence_Student1_idx` (`fk_student` ASC),
  CONSTRAINT `fk_StudentAttendence_Student1`
    FOREIGN KEY (`fk_student`)
    REFERENCES `mydb`.`student` (`student_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`offer_training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`offer_training` ;

CREATE TABLE IF NOT EXISTS `mydb`.`offer_training` (
  `id_offer_training` INT NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL,
  `fk_organization` INT NULL,
  `fk_professor` INT NOT NULL,
  `fk_department` INT NULL,
  PRIMARY KEY (`id_offer_training`),
  INDEX `fk_OfferTraining_Organization1_idx` (`fk_organization` ASC),
  INDEX `fk_OfferTraining_Professor1_idx` (`fk_professor` ASC),
  INDEX `fk_OfferTraining_Department1_idx` (`fk_department` ASC),
  CONSTRAINT `fk_OfferTraining_Organization1`
    FOREIGN KEY (`fk_organization`)
    REFERENCES `mydb`.`organization` (`id_organization`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Professor1`
    FOREIGN KEY (`fk_professor`)
    REFERENCES `mydb`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Department1`
    FOREIGN KEY (`fk_department`)
    REFERENCES `mydb`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rejected_training_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`rejected_training_message` ;

CREATE TABLE IF NOT EXISTS `mydb`.`rejected_training_message` (
  `id_rejected_training_message` INT NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL,
  `fk_student` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_rejected_training_message`),
  INDEX `fk_RejectedTrainingMessage_Student1_idx` (`fk_student` ASC),
  CONSTRAINT `fk_RejectedTrainingMessage_Student1`
    FOREIGN KEY (`fk_student`)
    REFERENCES `mydb`.`student` (`student_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
