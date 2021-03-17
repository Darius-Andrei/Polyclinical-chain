create database if not exists policlinica;
use policlinica;

create table if not exists Utilizator(
CNP bigint(13) primary key not null unique,
nume varchar(30),
prenume varchar (30),
adresa varchar(50),
nr_telefon int(13),
email varchar(30),
IBAN varchar(25),
nr_contract int(15),
data_angajare date,
functie varchar(40));

create table if not exists Administrator(
cnp bigint(13),
id_administrator int primary key not null unique);

create table if not exists Super_administrator(
cnp bigint(13),
id_super_administrator int primary key not null unique);

create table if not exists Unitate_medicala(
id_unitate int not null unique primary key,
denumire varchar(100),
adresa varchar(100),
descriere_servicii_oferite varchar(100),
venituri int,
cheltuieli int);

create table if not exists Angajat(
id_angajat int primary key not null unique,
nr_ore_specificate int,
nr_ore_realizate int,
salariu_luna float(7,2),
cnp bigint(13));

create table if not exists Asistent_medical(
id_asistent int primary key not null unique,
tip varchar(15),
grad varchar(15),
cnp bigint(13) );

create table if not exists Medic(
specialitati varchar(100),
grad varchar(15),
cod_parafa int primary key not null unique,
competente varchar(100),
titlu_stintific varchar(30),
postul_didactic varchar(20),
procent_servicii int,
cnp bigint(13));

create table if not exists Servicii_medicale(
competenta_necesara varchar(100),
pret float(6,2),
durata time,
nume_serviciu varchar(100),
id_serviciu int not null primary key unique);

create table if not exists Specialitati(
nume_specialitati_id int not null unique,
cod_parafa int not null unique,
Primary key (nume_specialitati_id,cod_parafa));

create table if not exists Competente(
id_competenta int not null ,
id_medic_competenta int not null ,
Primary key(id_competenta, id_medic_competenta));

CREATE TABLE IF NOT EXISTS orar (
  id_orar INT(13) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  luniOraInceput TIME ,
  luniOraFinal TIME ,
  martiOraInceput TIME ,
  martiOraFinal TIME ,
  miercuriOraInceput TIME ,
  miercuriOraFinal TIME ,
  joiOraInceput TIME,
  joiOraFinal TIME ,
  vineriOraInceput TIME ,
  vineriOraFinal TIME ,
  sambataOraInceput TIME,
  sambataOraFinal TIME,
  duminicaOraInceput TIME ,
  duminicaOraFinal TIME ,
  cnp bigint(13),
  locatie_id int
  );
 
 create table if not exists Pacient(
 nume varchar(30),
 prenume varchar(30),
 Id_pacient int primary key not null unique);

 create table if not exists Raport(
 id_raport int primary key not null unique,
 nume_pacient varchar(30),
 prenume_pacient varchar(30),
 nume_medic varchar(30),
 data_consultatiei date,
 simptome varchar(100),
 investigatii varchar(100),
 validare_rezultat boolean,
 valoare_rezulatat int,
 recomandare varchar(100),
 decizie_raport boolean);
 
 create table if not exists Introducere_in_istoric(
 id_raport int unique not null,
 id_asistent_medical int(13) unique not null,
 Primary key( id_raport, id_asistent_medical));
 
 create table if not exists  Istoricul_pacientului(
 id_raport int primary key not null unique,
 raport int );
 
 create table if not exists Programare(
 id_receptioner int,
 id_pacient int,
 medic varchar(30),
 data_calendaristica date,
 ora time,
 durata_consultatiei int,
 id_programare int primary key not null unique auto_increment);
 
 create table if not exists Inspector_Resurse_Umane(
 id_insp_res int primary key unique not null,
 cnp bigint(13));
 
 create table if not exists Expert_Financiar_Contabil(
 id_exp_finan int primary key unique not null,
  cnp bigint(13));
 
 create table if not exists Receptioner(
 id_receptioner int primary key unique not null,
  cnp bigint(13));
 
 Alter table Angajat
 Add foreign key (cnp) references Utilizator(CNP);
 
 Alter table Asistent_medical
 Add foreign key (cnp) references Utilizator(CNP);

 Alter table Medic
 Add foreign key (cnp) references Utilizator(CNP);

 Alter table Inspector_resurse_umane
 Add foreign key (cnp) references Utilizator(CNP);
 
  Alter table Expert_Financiar_Contabil
 Add foreign key (cnp) references Utilizator(CNP);
 
 Alter table Receptioner
 Add foreign key (cnp) references Utilizator(CNP);
 
 Alter table Orar
  Add foreign key (cnp) references Utilizator(CNP);
  
Alter table Orar
Add foreign key(locatie_id) references Unitate_Medicala(id_unitate);



 Alter table Administrator
  Add foreign key (cnp) references Utilizator(CNP);
  
   Alter table Super_administrator
  Add foreign key (cnp) references Utilizator(CNP);
  
  Alter table Competente
  ADD foreign key (id_competenta) references Servicii_medicale(id_serviciu);
  
  Alter table Competente
  ADD foreign key(id_medic_competenta) references Medic(cod_parafa);
  
  Alter table Specialitati
  ADD foreign key(nume_specialitati_id) references Servicii_medicale(id_serviciu);
  
  Alter table Specialitati
  ADD foreign key(cod_parafa) references Medic(cod_parafa);
  
  Alter table Introducere_in_istoric
  Add foreign key(id_raport) references Raport(id_raport);
  
    Alter table Introducere_in_istoric
  Add foreign key(id_asistent_medical) references Asistent_medical(id_asistent);
  
  ALter table Programare
  Add foreign key(id_pacient) references Pacient(id_pacient);
  
  Alter table Programare
  Add foreign key(id_receptioner) references Receptioner(id_receptioner);
  
  Alter table Istoricul_pacientului
  Add foreign key(raport) references Raport(id_raport);
  
  
Insert into Utilizator(CNP,nume,prenume,adresa ,nr_telefon,email ,IBAN ,nr_contract ,data_angajare ,functie) VALUES 
(1990726124424,'Matiesi','Darius','Str Ion Andreescu nr 23',0732029094,'dariusandrei26@yahoo.com','RO07UGBI0000132012234686',845903,'2000-01-01','asistent medical'),
(1940120464946,'Untdelemn','Elena','Str Constantin Brancusi nr 20',0712345678,'EleneNasty2000@yahoo.com','RO07UGBI0000132012234687',845904,'2000-01-01','asistent medical'),
(2920925217223,'Smirghel','Dorin','Str Vasile Alecsandri nr 201',0787654321,'Smirghel_Dorin@yahoo.com','RO07UGBI0000132012234688',845905,'2000-01-01','medic'),
(2920425253219,'Goroc','Silviu','Str Valceaua de Sus nr 3',0732029096,'Silllllviu@yahoo.com','RO07UGBI0000132012234689',845906,'2000-01-01','medic'),
(1990420393548,'Fustos','Denisza','Str Ungureanu nr 14',0732029890,'Sub_Fustos@yahoo.com','RO07UGBI0000132012234690',845907,'2000-01-01','medic'),
(1861225112502,'Boc','Anca','Str Ingusta nr 2',0744444444,'BocAnca2626@yahoo.com','RO07UGBI0000132012234691',845908,'2000-01-01','medic'),
(1991112244119,'Rasha','Primolla','Str Racului nr 21',0732094029,'Primolla_R@yahoo.com','RO07UGBI0000132012234692',845909,'2000-01-01','medic'),
(1921008283693,'Man','Ana','Str Berzei nr 41',0733579123,'ManAnaBanana@yahoo.com','RO07UGBI0000132012234693',845910,'2000-01-01','medic'),
(2980117035997,'Pintican','Beniamin','Str Rozelor nr 2',0745630190,'Pintican_Beniamin@yahoo.com','RO07UGBI0000132012234694',845911,'2000-01-01','medic'),
(1940120464947,'Chindris','Camelia','Str Principala nr 51',0725545678,'Magdas_Camelia26@yahoo.com','RO07UGBI0000132012234695',845912,'2000-01-01','inspector resurse umane'),
(2920925217224,'Handaric','Cosmin','Str Ardealu nr 4',0745989898,'CosminHandaric22@yahoo.com','RO07UGBI0000132012234696',845913,'2000-01-01','expert financiar contabil'),
(2920425253210,'Coroian','Florentin','Str Ecaterina Teodoroiu nr 17',0711111333,'tuddy_follow_punct@yahoo.com','RO07UGBI0000132012234697',845914,'2000-01-01','receptioner');
  
  
insert into Angajat(id_angajat, nr_ore_specificate, nr_ore_realizate, salariu_luna,cnp) values
(1, 160 , 0, 0, 1990726124424),
(2, 160 , 0, 0, 1940120464946),
(3, 160 , 0, 0, 2920925217223),
(4, 160 , 0, 0, 2920425253219),
(5, 160 , 0, 0, 1990420393548),
(6, 160 , 0, 0, 1861225112502),
(7, 160 , 0, 0, 1991112244119),
(8, 160 , 0, 0, 1921008283693),
(9, 160 , 0, 0, 2980117035997),
(10, 160 , 0, 0, 1940120464947),
(11, 160 , 0, 0, 2920925217224),
(12, 160 , 0, 0, 2920425253210);




insert into Pacient(Id_pacient,nume,prenume) values 
(1,'Munteanu','Oana'),
(2,'Schiop','Vlad'),
(3,'Moldovan','Stefan'),
(4,'Cuc','Alexandru'),
(5,'Munteanu','Horia'),
(6,'Pop','Emilia');



  insert into Raport( id_raport,nume_pacient,prenume_pacient,nume_medic,data_consultatiei,
 simptome,investigatii,validare_rezultat,valoare_rezulatat ,recomandare,decizie_raport) values 
 (1,'Munteanu','Oana','Popescu','2013/02/07','tuse','verificare_in_gat',true,12,'repaus_verbal',true),
 (2,'Schiop','Vlad','Marinescu','2014/02/01','durere_burta','masaj_in_zona_abdominala',true,140,'spitalizare',true),
 (3,'Moldovan','Stefan','Traian','2014/02/03','greata','consult',false,110,'regim_strict',true),
 (4,'Cuc','Alexandru','Stefan','2014/02/04','ameteala','calmant',true,130,'repaus',true),
 (5,'Munteanu','Horia','Pop','2014/02/09','durere_masea','consult_ortodont',true,15,'realizare_carie',true),
 (6,'Pop','Emilia','Stan','2014/02/08','tuse_groasa','recomandare_medicament',true,120,'medicamente',true);
 
 insert into Receptioner(id_receptioner, cnp ) values 
(1,2920425253210);
 
insert into Programare( id_receptioner,id_programare,id_pacient, medic, data_calendaristica,ora,durata_consultatiei) values
(1,1,1,'Popescu','2013/02/07','11:00',17),
(1,2,2,'Marinescu','2014/02/01','12:20',50),
(1,3,3,'Traian','2014/02/03','14:20',16),
(1,4,4,'Stefan','2014/02/04','17:20',11),
(1,5,5,'Pop','2014/02/09','13:21',25),
(1,6,6,'Stan','2014/02/08','11:30',30);


insert into Inspector_Resurse_Umane(id_insp_res,cnp ) values 
(1,1940120464947);


insert into Expert_Financiar_Contabil(id_exp_finan ,cnp ) values
(1,2920925217224);





insert into  Medic(cod_parafa,specialitati,grad,competente,titlu_stintific,
postul_didactic,procent_servicii,cnp ) values
(111,'Interne','primar','Medic primar','Doctor','Profesor univerista',20,2920925217223),
(112,'Stomatologie','primar', 'Medic primar','NULL','NULL',20,2920425253219),
(113,'Pediatrie','secundar','Medic copii','Medic primar','Profesor universitar',20,1990420393548),
(114,'Chirurgie','primar','Chirurgie generala','Medic','NULL',20,1861225112502),
(115,'Interne','primar','Anestezist ','Medic','Profesor univeristar',20,1991112244119),
(116,'Ortopedie','secundar','Ortopedia artrozelor','Medic','NULL',20, 1921008283693),
(117,'ORL','primar','Acupunctura', 'Asistent','Profesor univeristar',20,2980117035997);
 
 
  INSERT INTO Servicii_medicale(competenta_necesara,pret,durata,nume_serviciu,id_serviciu) values
 ('Medicina primara',120.0, 30,'Consultatie medic primar',1 ),
 ('Medicina de specialitate',120.0, 30,'Consultatie medic specialist',2),
 ('Medicina generala',125.0, 35,'Consultatie medicina generala/medicina de familie',3),
 ('Stomatologie',30, 300.0,'Albire endodontica', 5),
 ('Stomatologie',30, 650.0, 'Albire profesionala', 6),
 ('Cosmetica dentara', 30, 150.0, 'Bijuterii cosmetice dentare simple', 7),
 ('Anestezie generala',650.0,30,'A.G.I.O.T.- anestezie generala balansata cu pivot inhalator Sevoflurane',8),
 ('Medicina generala',150.0,30,'MAC - monitorizare de specialitate + perfuzie / ora',9),
 ('Anestezie generala',400.0,30, 'TIVA - anestezie generala iv',10),
 ('Anestezie generala',500.0,30, 'V.I.M.A. - anestezie generala cu IOT si pivot inhalator',11),
 ('Studii de specialitate',130.0,30, 'Atitudine primara in arsuri',12),
 ('Chirurgie generala',25.0,30, 'Injectie intradermica',13),
 ('Chirurgie generala'',Studii de specialitate',20.0,30, 'Injectie intramusculara',14),
 ('Chirurgie generala',30.0,30, 'Injectie intramusculara',15),
 ('Chirurgie generala',25.0,30, 'Injectie subcutanata',16),
 ('Chirurgie generala',65.0,30,'Montare cateter venos periferic',17);

insert into Competente(id_medic_competenta,id_competenta) values
 (111,1),
 (111,12),
 (112,5),
 (112,6),
 (112,7),
 (115,8),
 (115,10),
 (115,11),
 (114,13),
 (114,14),
 (114,15),
 (114,16),
 (114,17),
 (113,2),
 (113,3),
 (115,9),
 (116,15),
 (117,2);
 
 
 INSERT INTO Unitate_medicala(id_unitate,denumire,adresa,descriere_servicii_oferite) VALUES
 (12,'Spital Universitar de urgenta','Splaiul Independentei nr. 169, Sector 5 ','Anestezie generala'),
(15, 'Spitalul Clinic de Urgenţă "Sf.Pantelimon" ','Sos. Pantelimon nr. 340, sector 2 ','Chirugie generala'),
(05,'Sanys Medical S.R.L. ','Calea Dudeşti nr.104-122, Sector 3','Cabinet stomatologic'),
(25,'Bio-Medica Internaţional SRL ','Calea Floreasca nr. 111-113, Sector 1 ','Medicina primara'),
(75,'Clinica Medicală "Hipocrat 2000" S.R.L. ','Bd. Chisinau nr. 16, Sector 3','Medicina generala'),
(40,'Cabinete Medicale Grupate "Policlinica Regie" ','B-dul Regiei nr.8, Sector 6 ','Cabinet medical'),
(28,'CENTRUL MEDICAL DE DIAGNOSTIC ŞI TRATAMENT AMBULATORIU DR. NICOLAE KRETZULESCU ','Str. Mihai vodă nr. 17, sector 5','Medicina primara');

insert into Orar(id_orar, luniOraInceput,luniOraFinal,martiOraInceput,martiOraFinal,miercuriOraInceput, miercuriOraFinal, joiOraInceput,joiOraFinal,vineriOraInceput,vineriOraFinal,sambataOraInceput,sambataOraFinal,duminicaOraInceput, duminicaOraFinal,cnp, locatie_id) values
(1,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,12), 
(2,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,15),
(3,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,05),
(4,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,25),
(5,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,75),
(6,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,40),
(7,'08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00','08:00','20:00',NULL,NULL, NULL,28),
(8,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1990726124424,null),
(9,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1940120464946,null),
(10,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,2920925217223,null),
(11,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,2920425253219,null),
(12,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1990420393548,null),
(13,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1861225112502,null),
(14,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1991112244119,null),
(15,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1921008283693,null),
(16,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,2980117035997,null),
(17,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,1940120464947,null),
(18,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,2920925217224,null),
(19,'08:00','18:00','12:00','22:00',Null, null, '08:00','18:00','12:00','22:00','22:00','06:00',null, null,2920425253210,null);

 



