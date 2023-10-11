
insert into Course (id,title,credits) values ('INT1',  'Introduction a linformatique',10);
insert into Course (id,title,credits) values ('MAT1',  'Mathématique contextualisée',6);
insert into Course (id,title,credits) values ('CAI1',  'Communication anglophone contextualisée I',2);
insert into Course (id,title,credits) values ('CPT1',  'Comptabilité contextualisée I',2);
insert into Course (id,title,credits) values ('DEV1',  'Développement I',10);
insert into Course (id,title,credits) values ('STA2',  'Statistique contextualisée',3);
insert into Course (id,title,credits) values ('CAI2',  'Communication anglophone contextualisée II',2);
insert into Course (id,title,credits) values ('DEV2',  'Développement II',10);
insert into Course (id,title,credits) values ('DON2',  'Persistance des données I',5);
insert into Course (id,title,credits) values ('SYS2',  'Systèmes d''exploitation I',5);
insert into Course (id,title,credits) values ('WEBG2', 'Développement Web I',5);
insert into Course (id,title,credits) values ('PHYIR2', 'Physique I',3);
insert into Course (id,title,credits) values ('RESIR2', 'Réseau II',2);

INSERT INTO Student(name,genre,section) VALUES ('Bulbizarre','MASCULIN','GESTION');
INSERT INTO Student(name,genre,section) VALUES ('Roucool','FEMININ','GESTION');
INSERT INTO Student(name,genre,section) VALUES ('Pikachu','FEMININ','GESTION');
INSERT INTO Student(name,genre,section) VALUES ('Miaouss','MASCULIN','RESEAU');
INSERT INTO Student(name,genre,section) VALUES ('Saquedeneu','MASCULIN','RESEAU');
INSERT INTO Student(name,genre,section) VALUES ('Tauros','MASCULIN','INDUSTRIELLE');
INSERT INTO Student(name,genre,section) VALUES ('Ronflex','MASCULIN','GESTION');

-- Creation login et password et authority
INSERT INTO Users (username,password,enabled) VALUES ('secretary','{bcrypt}$2a$10$NzxN7HeQARShJf587F9juOxFht8M2nE/iKOAUSWEA8UdQmdndsMva',true);
INSERT INTO Users (username,password,enabled) VALUES ('prof','{bcrypt}$2a$10$5JmtCQbSPs.HMqtzflCI/OUkGUa1i.IXfFT4X/r8JHia6/0fw/VVa',true);
INSERT INTO Users (username,password,enabled) VALUES ('student','{bcrypt}$2a$10$4JFH6WnGQ/hd3q2Zv36z4.h5RfJCwozG4y/2dGoJw3ZClJbibY78K',true);

INSERT INTO AUTHORITIES(username,authority) VALUES ('secretary','SECRETARY');
INSERT INTO AUTHORITIES(username,authority) VALUES ('prof','PROF');
INSERT INTO AUTHORITIES(username,authority) VALUES ('student','STUDENT');
