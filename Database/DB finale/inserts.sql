INSERT INTO `db_distra`.`student_status` (`id_student_status`, `description`) VALUES ('1', 'Rifiutato');
INSERT INTO `db_distra`.`student_status` (`id_student_status`, `description`) VALUES ('2', 'Accettato');
INSERT INTO `db_distra`.`student_status` (`id_student_status`, `description`) VALUES ('3', 'In attesa');
INSERT INTO `db_distra`.`student_status` (`id_student_status`, `description`) VALUES ('4', 'Non inviato');


-- account--

INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('c.borges1@studenti.unisa.it', 'c.borges', 'student');
INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('v.vivone@studenti.unisa.it', 'v.vivone', 'student');
INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('a.saulino@studenti.unisa.it', 'a.saulino', 'student');
INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('moderna@azienda.unisa.it', 'moderna', 'organization');
INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('a.deluica@professori.unisa.it', 'a.delucia', 'professor');
INSERT INTO `db_distra`.`account` (`email`, `password`, `typeOfAccount`) VALUES ('staff@staff.unisa.it', 'staff', 'staff');

-- cicle-- 
INSERT INTO `db_distra`.`cycle` (`cycle_number`, `title`) VALUES ('1', 'Triennale');
INSERT INTO `db_distra`.`cycle` (`cycle_number`, `title`) VALUES ('2', 'Magistale');


--department--
INSERT INTO `db_distra`.`department` (`abbreviation`) VALUES ('MIT');

--TRAINING STATUS--
INSERT INTO `db_distra`.`training_status` (`description`) VALUES ('iniziato');
INSERT INTO `db_distra`.`training_status` (`description`) VALUES ('pre-completamento');
INSERT INTO `db_distra`.`training_status` (`description`) VALUES ('completo');

--person--
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('CB89', 'Carlos', 'Borges', 'M', 'c.borges1@studenti.unisa.it', 'MIT', 'Università di Salerno', '0512200011', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('VV89', 'Valentino', 'Vivone', 'M', 'v.vivone@studenti.unisa.it', 'MIT', 'Università di Salerno', '0512200012', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('AS', 'Aniello', 'Saulino', 'M', 'a.saulino@studenti.unisa.it', 'MIT', 'Università di Salerno', '0512200013', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('ADL', 'Andera', 'De Lucia', 'M', 'a.deluica@professori.unisa.it', 'MIT', 'Università di Salerno', '0512200014', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `cycle`) VALUES ('PP', 'Pippo', 'Paperino', 'M', 'staff@staff.unisa.it', 'MIT', 'Università di Salerno', '2');

--Organization--
INSERT INTO `db_distra`.`organization` (`vat_number`, `company_name`, `email`, `fk_account`, `fk_professor`) VALUES ('14saa', 'moderna2000', 'moderna@gmail.com', 'moderna@azienda.unisa.it', 'ADL');

--Update database--
ALTER TABLE `db_distra`.`organization` 
DROP FOREIGN KEY `fk_tutor`;
ALTER TABLE `db_distra`.`organization` 
CHANGE COLUMN `fk_externaltutor` `fk_externaltutor` VARCHAR(16) NULL ;
ALTER TABLE `db_distra`.`organization` 
ADD CONSTRAINT `fk_tutor`
  FOREIGN KEY (`fk_externaltutor`)
  REFERENCES `db_distra`.`person` (`SSN`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `db_distra`.`organization` 
DROP FOREIGN KEY `fk_tutor`;
ALTER TABLE `db_distra`.`organization` 
CHANGE COLUMN `fk_externaltutor` `fk_external_tutor` VARCHAR(16) NULL DEFAULT NULL ;
ALTER TABLE `db_distra`.`organization` 
ADD CONSTRAINT `fk_tutor`
  FOREIGN KEY (`fk_external_tutor`)
  REFERENCES `db_distra`.`person` (`SSN`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `activetraining` AS
    select 
        `student_information`.`SSN` AS `SSN`
    from
        (`student_information`
        join `training_request`)
    where
        ((`training_request`.`fk_training_status` = 1)
            and (`training_request`.`fk_training_status` = 2))
        
        
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `studentstartedtraining` AS
    select 
        `student_information`.`SSN` AS `SSN`
    from
        (`student_information`
        join `training_status`)
    where
        (`training_status`.`id_training_status` = 1)

