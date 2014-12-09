SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `db_distra` DEFAULT CHARACTER SET utf8 ;
USE `db_distra` ;

-- -----------------------------------------------------
-- Table `db_distra`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`account` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`account` (
  `email` VARCHAR(100) NOT NULL COMMENT 'Nome con il quale l\'utente viene riconosciuto da un',
  `password` VARCHAR(45) NOT NULL,
  `typeOfAccount` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabella adibita alla gestione dei dati principali per l\'aces /* comment truncated */ /* /* comment truncated */ /*so al sistema*/*/';


-- -----------------------------------------------------
-- Table `db_distra`.`cycle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`cycle` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`cycle` (
  `cycle_number` INT(11) NOT NULL,
  `title` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cycle_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`department` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`department` (
  `abbreviation` VARCHAR(50) NOT NULL,
  `title` VARCHAR(500) NULL DEFAULT NULL,
  `url_moodle` VARCHAR(1000) NULL DEFAULT NULL,
  `token` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`abbreviation`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`person` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`person` (
  `SSN` VARCHAR(16) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `zip_code` VARCHAR(45) NULL DEFAULT NULL,
  `gender` CHAR(1) NULL DEFAULT NULL,
  `citizenship` VARCHAR(45) NULL DEFAULT NULL,
  `Account_email` VARCHAR(100) NOT NULL,
  `Department_abbreviation` VARCHAR(50) NOT NULL,
  `web_page` VARCHAR(300) NULL DEFAULT NULL,
  `university` VARCHAR(200) NULL DEFAULT NULL,
  `matricula` VARCHAR(10) NULL DEFAULT NULL,
  `position` VARCHAR(50) NOT NULL,
  `cycle` INT(11) NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE INDEX `fk_cycle` (`cycle` ASC),
  INDEX `fk_Person_Account_idx` (`Account_email` ASC),
  INDEX `fk_Person_Department1_idx` (`Department_abbreviation` ASC),
  CONSTRAINT `person_ibfk_1`
    FOREIGN KEY (`cycle`)
    REFERENCES `db_distra`.`cycle` (`cycle_number`),
  CONSTRAINT `fk_Person_Account`
    FOREIGN KEY (`Account_email`)
    REFERENCES `db_distra`.`account` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_Department1`
    FOREIGN KEY (`Department_abbreviation`)
    REFERENCES `db_distra`.`department` (`abbreviation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`tesi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`tesi` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`tesi` (
  `ID` INT(11) NOT NULL,
  `Data_Inizio` DATE NOT NULL,
  `Data_Fine` DATE NOT NULL,
  `Data_Fine_Prevista` DATE NOT NULL,
  `Titolo` VARCHAR(255) NOT NULL,
  `Abstract` VARCHAR(45) NOT NULL,
  `Descrizione` VARCHAR(255) NOT NULL,
  `ID_Studente` VARCHAR(16) NOT NULL,
  `Stato_Tesi` ENUM('0','1','2','3') NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `fk_person` (`ID_Studente` ASC),
  CONSTRAINT `tesi_ibfk_1`
    FOREIGN KEY (`ID_Studente`)
    REFERENCES `db_distra`.`person` (`SSN`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`allegato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`allegato` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`allegato` (
  `ID` INT(11) NOT NULL,
  `Oggetto` VARCHAR(255) NOT NULL,
  `ID_Tesi` INT(11) NOT NULL,
  `Stato` ENUM('0','1') NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ID_Tesi` (`ID_Tesi` ASC),
  CONSTRAINT `allegato_ibfk_1`
    FOREIGN KEY (`ID_Tesi`)
    REFERENCES `db_distra`.`tesi` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`annuncio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`annuncio` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`annuncio` (
  `ID` INT(11) NOT NULL,
  `Testo` TEXT NOT NULL,
  `ID_Docente` VARCHAR(16) NOT NULL,
  `Data_Annuncio` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  INDEX `ID_Docente` (`ID_Docente` ASC),
  CONSTRAINT `annuncio_ibfk_1`
    FOREIGN KEY (`ID_Docente`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`teaching`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`teaching` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`teaching` (
  `matricula` VARCHAR(10) NOT NULL,
  `title` VARCHAR(500) NOT NULL,
  `abbreviation` VARCHAR(10) NOT NULL,
  `link` VARCHAR(500) NOT NULL,
  `year` INT(11) NOT NULL,
  `semester` INT(11) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`class` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`class` (
  `title` VARCHAR(50) NOT NULL,
  `teaching_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`title`, `teaching_matricula`),
  INDEX `title` (`title` ASC),
  INDEX `teaching_matricula` (`teaching_matricula` ASC),
  CONSTRAINT `fk_class_teaching1`
    FOREIGN KEY (`teaching_matricula`)
    REFERENCES `db_distra`.`teaching` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`phdcurriculum`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`phdcurriculum` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`phdcurriculum` (
  `idPhdCurriculum` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `FK_Professor` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idPhdCurriculum`),
  INDEX `FK_Professor` (`FK_Professor` ASC),
  CONSTRAINT `phdcurriculum_ibfk_1`
    FOREIGN KEY (`FK_Professor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`phdcycle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`phdcycle` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`phdcycle` (
  `idPhdCycle` INT(11) NOT NULL,
  `description` TEXT NOT NULL,
  `year` YEAR NOT NULL,
  `FK_Professor` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idPhdCycle`),
  INDEX `FK_Professor` (`FK_Professor` ASC),
  CONSTRAINT `phdcycle_ibfk_1`
    FOREIGN KEY (`FK_Professor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`phdclass`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`phdclass` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`phdclass` (
  `idClass` INT(20) NOT NULL,
  `FK_PhdCycle` INT(11) NOT NULL,
  `FK_PhdCurriculum` INT(11) NOT NULL,
  PRIMARY KEY (`idClass`),
  UNIQUE INDEX `FK_cycle` (`FK_PhdCycle` ASC),
  INDEX `FK_PhdCurriculum` (`FK_PhdCurriculum` ASC),
  CONSTRAINT `phdclass_ibfk_2`
    FOREIGN KEY (`FK_PhdCurriculum`)
    REFERENCES `db_distra`.`phdcurriculum` (`idPhdCurriculum`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `phdclass_ibfk_1`
    FOREIGN KEY (`FK_PhdCycle`)
    REFERENCES `db_distra`.`phdcycle` (`idPhdCycle`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`event` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`event` (
  `idEvent` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `hours` INT(1) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idEvent`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`class_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`class_event` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`class_event` (
  `FK_Class` INT(11) NOT NULL,
  `FK_Event` INT(11) NOT NULL,
  PRIMARY KEY (`FK_Class`, `FK_Event`),
  INDEX `FK_Event` (`FK_Event` ASC),
  INDEX `FK_Class` (`FK_Class` ASC),
  CONSTRAINT `class_event_ibfk_1`
    FOREIGN KEY (`FK_Class`)
    REFERENCES `db_distra`.`phdclass` (`idClass`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `class_event_ibfk_2`
    FOREIGN KEY (`FK_Event`)
    REFERENCES `db_distra`.`event` (`idEvent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`class_notice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`class_notice` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`class_notice` (
  `FK_Class` INT(11) NOT NULL,
  `FK_Event` INT(11) NOT NULL,
  PRIMARY KEY (`FK_Class`, `FK_Event`),
  INDEX `FK_Event` (`FK_Event` ASC),
  INDEX `FK_Class` (`FK_Class` ASC),
  CONSTRAINT `class_notice_ibfk_2`
    FOREIGN KEY (`FK_Class`)
    REFERENCES `db_distra`.`phdclass` (`idClass`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `class_notice_ibfk_1`
    FOREIGN KEY (`FK_Event`)
    REFERENCES `db_distra`.`event` (`idEvent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`collaboration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`collaboration` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`collaboration` (
  `idCollaboration` INT(20) NOT NULL,
  `istitution` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `FK_Student` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idCollaboration`),
  INDEX `FK_Student` (`FK_Student` ASC),
  CONSTRAINT `collaboration_ibfk_1`
    FOREIGN KEY (`FK_Student`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`cronologia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`cronologia` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`cronologia` (
  `ID` INT(11) NOT NULL,
  `Testo` VARCHAR(255) NOT NULL,
  `ID_Docente` VARCHAR(16) NOT NULL,
  `ID_Studente` VARCHAR(16) NOT NULL,
  `Data_Notifica` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `fk_person1` (`ID_Studente` ASC),
  UNIQUE INDEX `fk_person2` (`ID_Docente` ASC),
  CONSTRAINT `cronologia_ibfk_2`
    FOREIGN KEY (`ID_Studente`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cronologia_ibfk_1`
    FOREIGN KEY (`ID_Docente`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`degree`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`degree` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`degree` (
  `title` VARCHAR(500) NOT NULL,
  `matricula` VARCHAR(5) NOT NULL,
  `link` VARCHAR(500) NULL DEFAULT NULL,
  `department_abbreviation` VARCHAR(100) NOT NULL,
  `cycle_number` INT(11) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_degree_department1_idx` (`department_abbreviation` ASC),
  INDEX `fk_degree_cycle1_idx` (`cycle_number` ASC),
  CONSTRAINT `fk_degree_cycle1`
    FOREIGN KEY (`cycle_number`)
    REFERENCES `db_distra`.`cycle` (`cycle_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_degree_department1`
    FOREIGN KEY (`department_abbreviation`)
    REFERENCES `db_distra`.`department` (`abbreviation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`curriculum`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`curriculum` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`curriculum` (
  `title` VARCHAR(100) NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `degree_matricula` VARCHAR(5) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_curriculum_degree1_idx` (`degree_matricula` ASC),
  CONSTRAINT `fk_curriculum_degree1`
    FOREIGN KEY (`degree_matricula`)
    REFERENCES `db_distra`.`degree` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`curriculum_teaching`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`curriculum_teaching` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`curriculum_teaching` (
  `curriculum_matricula` VARCHAR(45) NOT NULL,
  `teaching_matricula` VARCHAR(10) NOT NULL,
  INDEX `curriculum_matricula` (`curriculum_matricula` ASC),
  INDEX `teaching_matricula` (`teaching_matricula` ASC),
  CONSTRAINT `curriculum_teaching_ibfk_2`
    FOREIGN KEY (`teaching_matricula`)
    REFERENCES `db_distra`.`teaching` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `curriculum_teaching_ibfk_1`
    FOREIGN KEY (`curriculum_matricula`)
    REFERENCES `db_distra`.`curriculum` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`event_professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`event_professor` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`event_professor` (
  `FK_Event` INT(11) NOT NULL,
  `FK_Professor` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`FK_Event`, `FK_Professor`),
  INDEX `FK_Professor` (`FK_Professor` ASC),
  INDEX `FK_Event` (`FK_Event` ASC),
  CONSTRAINT `event_professor_ibfk_2`
    FOREIGN KEY (`FK_Professor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `event_professor_ibfk_1`
    FOREIGN KEY (`FK_Event`)
    REFERENCES `db_distra`.`event` (`idEvent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`lesson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`lesson` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`lesson` (
  `idLesson` INT(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `speaker` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `startTime` TIME NOT NULL,
  `endTime` TIME NOT NULL,
  `place` VARCHAR(45) NOT NULL,
  `FK_Event` INT(11) NOT NULL,
  PRIMARY KEY (`idLesson`),
  INDEX `FK_Event` (`FK_Event` ASC),
  CONSTRAINT `lesson_ibfk_1`
    FOREIGN KEY (`FK_Event`)
    REFERENCES `db_distra`.`event` (`idEvent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`lesson_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`lesson_student` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`lesson_student` (
  `FK_Lesson` INT(20) NOT NULL,
  `FK_Student` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`FK_Lesson`, `FK_Student`),
  INDEX `FK_Student` (`FK_Student` ASC),
  INDEX `FK_Lesson` (`FK_Lesson` ASC),
  CONSTRAINT `lesson_student_ibfk_2`
    FOREIGN KEY (`FK_Lesson`)
    REFERENCES `db_distra`.`lesson` (`idLesson`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `lesson_student_ibfk_1`
    FOREIGN KEY (`FK_Student`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`mission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`mission` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`mission` (
  `idMission` INT(20) NOT NULL,
  `place` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `FK_Student` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idMission`),
  INDEX `FK_Student` (`FK_Student` ASC),
  CONSTRAINT `mission_ibfk_1`
    FOREIGN KEY (`FK_Student`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`module`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`module` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`module` (
  `title` VARCHAR(50) NOT NULL,
  `teaching_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`title`, `teaching_matricula`),
  INDEX `fk_module_teaching1_idx` (`teaching_matricula` ASC),
  CONSTRAINT `fk_module_teaching1`
    FOREIGN KEY (`teaching_matricula`)
    REFERENCES `db_distra`.`teaching` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`notice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`notice` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`notice` (
  `idNotice` INT(11) NOT NULL,
  `object` VARCHAR(45) NOT NULL,
  `text` TEXT NOT NULL,
  PRIMARY KEY (`idNotice`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`organization` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`organization` (
  `id_organization` INT(11) NOT NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `fk_account` VARCHAR(100) NOT NULL,
  `fk_externaltutor` VARCHAR(16) NULL DEFAULT NULL,
  `fk_professor` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id_organization`),
  INDEX `fk_acc` (`fk_account` ASC),
  INDEX `fk_tutor` (`fk_externaltutor` ASC),
  INDEX `fk_prof` (`fk_professor` ASC),
  CONSTRAINT `fk_acc`
    FOREIGN KEY (`fk_account`)
    REFERENCES `db_distra`.`account` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tutor`
    FOREIGN KEY (`fk_externaltutor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prof`
    FOREIGN KEY (`fk_professor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`offer_training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`offer_training` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`offer_training` (
  `id_offer_training` INT(11) NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL DEFAULT NULL,
  `fk_organization` INT(11) NULL DEFAULT NULL,
  `fk_person` VARCHAR(16) NOT NULL,
  `fk_department` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_offer_training`),
  INDEX `fk_OfferTraining_Organization1_idx` (`fk_organization` ASC),
  INDEX `fk_OfferTraining_Professor1_idx` (`fk_person` ASC),
  INDEX `fk_OfferTraining_Department1_idx` (`fk_department` ASC),
  CONSTRAINT `fk_OfferTraining_Organization1`
    FOREIGN KEY (`fk_organization`)
    REFERENCES `db_distra`.`organization` (`id_organization`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Professor1`
    FOREIGN KEY (`fk_person`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Department1`
    FOREIGN KEY (`fk_department`)
    REFERENCES `db_distra`.`department` (`abbreviation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`pending_acceptance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`pending_acceptance` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`pending_acceptance` (
  `id_pending_acceptance` INT(11) NOT NULL AUTO_INCREMENT,
  `date_request` DATE NULL DEFAULT NULL,
  `fk_person` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id_pending_acceptance`),
  INDEX `fk_StudentAttendence_Student1_idx` (`fk_person` ASC),
  CONSTRAINT `fk_StudentAttendence_Student1`
    FOREIGN KEY (`fk_person`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`professor_phdcycle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`professor_phdcycle` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`professor_phdcycle` (
  `FK_Professor` VARCHAR(16) NOT NULL,
  `FK_PhdCycle` INT(11) NOT NULL,
  PRIMARY KEY (`FK_Professor`, `FK_PhdCycle`),
  INDEX `FK_PhdCycle` (`FK_PhdCycle` ASC),
  INDEX `FK_Professor` (`FK_Professor` ASC),
  CONSTRAINT `professor_phdcycle_ibfk_2`
    FOREIGN KEY (`FK_PhdCycle`)
    REFERENCES `db_distra`.`phdcycle` (`idPhdCycle`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `professor_phdcycle_ibfk_1`
    FOREIGN KEY (`FK_Professor`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`prof_module_class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`prof_module_class` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`prof_module_class` (
  `ID` INT(11) NOT NULL,
  `class_title` VARCHAR(50) NOT NULL,
  `teaching_matricula` VARCHAR(10) NOT NULL,
  `module_title` VARCHAR(50) NOT NULL,
  `email_account` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `class_title` (`class_title` ASC),
  INDEX `module_teaching_matricula` (`teaching_matricula` ASC),
  INDEX `module_title` (`module_title` ASC),
  INDEX `email_account` (`email_account` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`publication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`publication` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`publication` (
  `idPublication` INT(20) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `authors` VARCHAR(45) NOT NULL,
  `abstract` TEXT NOT NULL,
  `file` LONGBLOB NOT NULL,
  `year` YEAR NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `publicationIssue` VARCHAR(45) NOT NULL,
  `numberPages` INT(11) NOT NULL,
  `FK_Student` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idPublication`),
  INDEX `FK_Student` (`FK_Student` ASC),
  INDEX `FK_Student_2` (`FK_Student` ASC),
  INDEX `FK_Student_3` (`FK_Student` ASC),
  CONSTRAINT `publication_ibfk_1`
    FOREIGN KEY (`FK_Student`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`rejected_training_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`rejected_training_message` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`rejected_training_message` (
  `id_rejected_training_message` INT(11) NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL DEFAULT NULL,
  `fk_person` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id_rejected_training_message`),
  INDEX `fk_RejectedTrainingMessage_Student1_idx` (`fk_person` ASC),
  CONSTRAINT `rejected_training_message_ibfk_1`
    FOREIGN KEY (`fk_person`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`relatori_tesi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`relatori_tesi` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`relatori_tesi` (
  `ID_Tesi` INT(11) NOT NULL,
  `ID_Docente` VARCHAR(16) NOT NULL,
  INDEX `ID_Tesi` (`ID_Tesi` ASC),
  INDEX `ID_Docente` (`ID_Docente` ASC),
  CONSTRAINT `relatori_tesi_ibfk_2`
    FOREIGN KEY (`ID_Docente`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `relatori_tesi_ibfk_1`
    FOREIGN KEY (`ID_Tesi`)
    REFERENCES `db_distra`.`tesi` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`student_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`student_status` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`student_status` (
  `id_student_status` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_student_status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`student_information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`student_information` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`student_information` (
  `curriculum_vitae_path` VARCHAR(200) NULL DEFAULT NULL,
  `accademic_transcript_path` VARCHAR(200) NULL DEFAULT NULL,
  `SSN` VARCHAR(16) NOT NULL,
  `fk_student_status` INT(11) NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE INDEX `fk_status` (`fk_student_status` ASC),
  CONSTRAINT `student_information_ibfk_2`
    FOREIGN KEY (`fk_student_status`)
    REFERENCES `db_distra`.`student_status` (`id_student_status`)
    ON UPDATE CASCADE,
  CONSTRAINT `student_information_ibfk_1`
    FOREIGN KEY (`SSN`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`tag` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`tag` (
  `ID` INT(11) NOT NULL,
  `Nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`tag_tesi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`tag_tesi` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`tag_tesi` (
  `ID_tesi` INT(11) NOT NULL,
  `ID_tag` INT(11) NOT NULL,
  `ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `fk_tesi` (`ID_tesi` ASC),
  UNIQUE INDEX `fk_tag` (`ID_tag` ASC),
  CONSTRAINT `tag_tesi_ibfk_2`
    FOREIGN KEY (`ID_tag`)
    REFERENCES `db_distra`.`tag` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `tag_tesi_ibfk_1`
    FOREIGN KEY (`ID_tesi`)
    REFERENCES `db_distra`.`tesi` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`training_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`training_status` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`training_status` (
  `id_training_status` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_training_status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_distra`.`training_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_distra`.`training_request` ;

CREATE TABLE IF NOT EXISTS `db_distra`.`training_request` (
  `id_training_request` INT(11) NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `fk_training_status` INT(11) NOT NULL,
  `fk_person` VARCHAR(16) NOT NULL,
  `fk_organization` INT(11) NULL DEFAULT NULL,
  `student_information_SSN` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id_training_request`, `student_information_SSN`),
  INDEX `fk_ClaimTraining_ClaimStatus1_idx` (`fk_training_status` ASC),
  INDEX `fk_ClaimTraining_Professor1_idx` (`fk_person` ASC),
  INDEX `fk_ClaimTraining_Organization1_idx` (`fk_organization` ASC),
  INDEX `fk_training_request_student_information1_idx` (`student_information_SSN` ASC),
  CONSTRAINT `training_request_ibfk_2`
    FOREIGN KEY (`fk_organization`)
    REFERENCES `db_distra`.`organization` (`id_organization`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ClaimTraining_ClaimStatus1`
    FOREIGN KEY (`fk_training_status`)
    REFERENCES `db_distra`.`training_status` (`id_training_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `training_request_ibfk_1`
    FOREIGN KEY (`fk_person`)
    REFERENCES `db_distra`.`person` (`SSN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_training_request_student_information1`
    FOREIGN KEY (`student_information_SSN`)
    REFERENCES `db_distra`.`student_information` (`SSN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
