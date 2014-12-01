-- --------------------------------------------------------------------------------
-- Note: Inserimento tabella permessi ( 1 tutti i permessi, 2 nessun permesso,
-- 3 Solo permesso per [TP]) 
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`Permissions` (`idPermissions`, `description`, `class`) VALUES ('1', 'Tutti i permessi', '1-1-1-1-1');
INSERT INTO `mydb`.`Permissions` (`idPermissions`, `description`, `class`) VALUES ('2', 'Permesso di visualizazione TP', '1-0-0-0-0');
INSERT INTO `mydb`.`Permissions` (`idPermissions`, `description`, `class`) VALUES ('3', 'Nessun permesso', '0-0-0-0-0');
-- Note: Inserimento claimStatus 
-- --------------------------------------------------------------------------------

INSERT INTO `mydb`.`ClaimStatus` (`idClaimStatus`, `description`) VALUES ('0', 'Iniziato');
INSERT INTO `mydb`.`ClaimStatus` (`idClaimStatus`, `description`) VALUES ('1', 'In attesa di compilazione questionario');
INSERT INTO `mydb`.`ClaimStatus` (`idClaimStatus`, `description`) VALUES ('3', ' Concluso e approvato');


-- --------------------------------------------------------------------------------
-- Note: Inserimento Department 
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`Department` (`idDepartment`, `description`) VALUES ('1', 'DISTRA-MIT');


-- --------------------------------------------------------------------------------
-- Note: Inserimento Student status 
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`StudentStatus` (`idStudentStatus`, `description`) VALUES ('0', 'Rifiutato');
INSERT INTO `mydb`.`StudentStatus` (`idStudentStatus`, `description`) VALUES ('1', 'Accettato');
INSERT INTO `mydb`.`StudentStatus` (`idStudentStatus`, `description`) VALUES ('2', 'In attesa');
INSERT INTO `mydb`.`StudentStatus` (`idStudentStatus`, `description`) VALUES ('3', 'Non inviato');



-- --------------------------------------------------------------------------------
-- Note: Inserimento account (username e password uguali) v.vivone, a.saulino, a.delucia, k.solomita (permesso 2)
-- s.staff (permesso 1), a.azienda (permesso 2), u.noPermission utente senza permesso
-- --------------------------------------------------------------------------------

INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('1', 'v.vivone', 'v.vivone', 'studente', '2');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('2', 'a.saulino', 'a.saulino', 'studente', '2');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('3', 'a.delucia', 'a.delucia', 'professore', '2');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES, 's.staff', 's.staff', 'staff', '1');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('5', 'u.noPermission', 'u.noPermission', 'studente', '3');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('6', 'azienda', 'azienda', 'azienda', '2');
INSERT INTO `mydb`.`Account` (`idAccount`, `userName`, `password`, `typeOfAccount`, `FK_permission`) VALUES ('7', 'k.solomita', 'k.solomita', 'studente', '2');




-- --------------------------------------------------------------------------------
-- Note: Insermento tabella FisicPerson
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`FisicPerson` (`idFisicPerson`, `name`, `lastName`, `phoneNum`, `city`, `address`, `CAP`, `sex`, `citizenship`, `CF`, `email`) VALUES ('1', 'Nello', 'Saulino', '33124123', 'Nola', 'Via A.gatto', '89040', 'M', 'Italy', 'ISDN31231JS', 'n.saulino@gmail.com');
INSERT INTO `mydb`.`FisicPerson` (`idFisicPerson`, `name`, `lastName`, `phoneNum`, `city`, `address`, `CAP`, `sex`, `citizenship`, `CF`, `email`) VALUES ('2', 'Valentino', 'Vivone', '2323143', 'Battipaglia', 'Strada statale 18', '89040', 'M', 'Italy', 'VAFDAj312js', 'v.vivone@gmail.com');
INSERT INTO `mydb`.`FisicPerson` (`idFisicPerson`, `name`, `lastName`, `phoneNum`, `city`, `address`, `CAP`, `sex`, `citizenship`, `CF`, `email`) VALUES ('3', 'Andrea', 'De Lucia', '2343432', 'Salerno', 'Via de Amicis', '89040', 'M', 'Italy', 'SFAk231JDA', 'a.delucia@gmail.com');
INSERT INTO `mydb`.`FisicPerson` (`idFisicPerson`, `name`, `lastName`, `phoneNum`, `city`) VALUES ('4', 'Pippo', 'paperino', '4325235', 'Salerno');
INSERT INTO `mydb`.`FisicPerson` (`idFisicPerson`, `name`, `lastName`, `phoneNum`, `city`, `address`, `CAP`, `sex`, `citizenship`, `CF`) VALUES ('5', 'Katia', 'Solomita', '2432853534', 'Gesualdo', 'Via M.D Gesualdo', '89234', 'F', 'Italy', 'KT42SJKED');





-- --------------------------------------------------------------------------------
-- Note: Insermento tabella Staff
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`Staff` (`idStaff`, `officePhoneNum`, `officeEmail`, `FK_Department`, `FK_Account`, `FK_FisicPerson`) VALUES ('1', '840', 'p.paperino@staff.unisa.it', '1', '4', '4');


-- --------------------------------------------------------------------------------
-- Note: Insermento tabella Professor
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`Professor` (`idProfessor`, `position`, `officePhoneNum`, `officeEmail`, `FK_Account`, `FK_FisicPerson`, `FK_Department`) VALUES ('1', 'Professore di ruolo', '450', 'a.delucia@professori.unisa.it', '3', '3', '1');



-- --------------------------------------------------------------------------------
-- Note: Insermento tabella Organization
-- --------------------------------------------------------------------------------

INSERT INTO `mydb`.`Organization` (`idOrganization`, `companyName`, `city`, `address`, `phone`, `email`, `FK_Account`, `FK_Professor`) VALUES ('1', 'Indra', 'Napoli', 'Via Italia', '08934235', 'indra@tirocinio.it', '6', '1');



-- --------------------------------------------------------------------------------
-- Note: Insermento tabella offerTraining
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`OfferTraining` (`idOfferTraining`, `description`, `FK_Organization`, `FK_Professor`, `FK_Department`) VALUES ('1', 'Tirocinio interfaccia app web', '1', '1', '1');
INSERT INTO `mydb`.`OfferTraining` (`idOfferTraining`, `description`, `FK_Professor`, `FK_Department`) VALUES ('2', 'Tirocinio in data warehaouse', '1', '1');
INSERT INTO `mydb`.`OfferTraining` (`idOfferTraining`, `description`, `FK_Organization`, `FK_Professor`, `FK_Department`) VALUES ('3', 'Tirocinio app android', '1', '1', '1');



-- --------------------------------------------------------------------------------
-- Note: Insermento Student
-- --------------------------------------------------------------------------------
INSERT INTO `mydb`.`Student` (`serialNumber`, `yearEnrollment`, `cycle`, `universityEmail`, `FK_Account`, `FK_FisicPerson`, `FK_Department`) VALUES ('051220011', '01-01-2014', '2', 'a.solomita@studenti.unisa.it', '7', '5', '1');
INSERT INTO `mydb`.`Student` (`serialNumber`, `yearEnrollment`, `cycle`, `universityEmail`, `FK_Account`, `FK_FisicPerson`, `FK_Department`) VALUES ('051220012', '01-01-2013', '2', 'a.saulino@studenti.unisa.it', '2', '1', '1');
INSERT INTO `mydb`.`Student` (`serialNumber`, `yearEnrollment`, `cycle`, `universityEmail`, `FK_Account`, `FK_FisicPerson`, `FK_Department`) VALUES ('051220014', '01-01-2013', '2', 'v.vivone@studenti.unisa.it', '1', '2', '1');
