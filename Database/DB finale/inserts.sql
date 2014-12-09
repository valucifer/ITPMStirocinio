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

--person--
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('CB89', 'Carlos', 'Borges', 'M', 'c.borges1@studenti.unisa.it', 'MIT', 'Università di Salerno', '05122200011', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('VV89', 'Valentino', 'Vivone', 'M', 'v.vivone@studenti.unisa.it', 'MIT', 'Università di Salerno', '05122200012', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('AS', 'Aniello', 'Saulino', 'M', 'a.saulino@studenti.unisa.it', 'MIT', 'Università di Salerno', '05122200013', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `matricula`, `cycle`) VALUES ('ADL', 'Andera', 'De Lucia', 'M', 'a.deluica@professori.unisa.it', 'MIT', 'Università di Salerno', '05122200014', '2');
INSERT INTO `db_distra`.`person` (`SSN`, `name`, `surname`, `gender`, `Account_email`, `Department_abbreviation`, `university`, `cycle`) VALUES ('PP', 'Pippo', 'Paperino', 'M', 'staff@staff.unisa.it', 'MIT', 'Università di Salerno', '2');

