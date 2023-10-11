insert into Unit (id,title,semester,ects) values ('INT1', 'Introduction à linformatique',1,10);
insert into Unit (id,title,semester,ects) values ('MAT1', 'Mathématique contextualisée',1,6);
insert into Unit (id,title,semester,ects) values ('CAI1', 'Communication anglophone contextualisée I',1,2);
insert into Unit_Sections (unit_id, sections) values ('INT1', 'G');
insert into Unit_Sections (unit_id, sections) values ('MAT1', 'G');
insert into Unit_Sections (unit_id, sections) values ('CAI1', 'G');
insert into Unit_Sections (unit_id, sections) values ('INT1', 'I');
insert into Unit_Sections (unit_id, sections) values ('MAT1', 'I');
insert into Unit_Sections (unit_id, sections) values ('CAI1', 'I');
insert into Unit_Sections (unit_id, sections) values ('INT1', 'R');
insert into Unit_Sections (unit_id, sections) values ('MAT1', 'R');
insert into Unit_Sections (unit_id, sections) values ('CAI1', 'R');
INSERT INTO Student (number,name,bloc,section) VALUES (40001,'Baker Gates',2,'G');
INSERT INTO Student (number,name,bloc,section) VALUES (40002,'Lillith Meyers',2,'G');
INSERT INTO Student (number,name,bloc,section) VALUES (40003,'Nevada Cline',3,'G');
INSERT INTO Student (number,name,bloc,section) VALUES (40004,'Kasper Mccormick',3,'I');
INSERT INTO Student (number,name,bloc,section) VALUES (40005,'Kasper eazeaea',1,'I');
INSERT INTO Student (number,name,bloc,section) VALUES (40006,'Kasper aaaaa',2,'I');
INSERT INTO Student (number,name,bloc,section) VALUES (40007,'Kasper ccccc',3,'R');
INSERT INTO Student (number,name,bloc,section) VALUES (40008,'Kasper bbbbbb',3,'R');
INSERT INTO Student (number,name,bloc,section) VALUES (40009,'Kasper Mccorefzefzefmick',3,'R');
INSERT INTO Student (number,name,bloc,section) VALUES (40010,'Kasper Mccorefzefzefmick',1,'G');
-- ALTER SEQUENCE student_seq restart 40100;
INSERT INTO Annual_Program (id,student_number) VALUES (1,40001);
INSERT INTO Annual_Program (id,student_number) VALUES (2,40002);
INSERT INTO Annual_Program (id,student_number) VALUES (3,40003);
INSERT INTO Registration (id,mandatory,annual_program_id,unit_id) VALUES (101,true,1,'INT1');
INSERT INTO Registration (id,mandatory,annual_program_id,unit_id) VALUES (102,true,2,'INT1');
INSERT INTO Registration (id,mandatory,annual_program_id,unit_id) VALUES (103,true,3,'INT1');
-- ALTER SEQUENCE hibernate_sequence restart 1000;

INSERT INTO USERS (username,password,enabled) VALUES ('admin','{bcrypt}$2a$10$0CuPj8hqbpk.g28M7aD6z.i3lZ.Cp2x30/Lrn2umQbfBFHHIDUCFy',true);
INSERT INTO AUTHORITIES(username,authority) VALUES ('admin','ROLE_ADMIN');

INSERT INTO USERS (username,password,enabled) VALUES ('40001','{bcrypt}$2a$10$mH6NDD2zmkB36GQHgpyDs.gDfJf6pXKBXtF2hrtQGRjPMooWvJl/y',true);
INSERT INTO AUTHORITIES(username,authority) VALUES ('40001','ROLE_STUDENT');

INSERT INTO USERS (username,password,enabled) VALUES ('student','{bcrypt}$2a$10$mH6NDD2zmkB36GQHgpyDs.gDfJf6pXKBXtF2hrtQGRjPMooWvJl/y',true);
INSERT INTO AUTHORITIES(username,authority) VALUES ('student','ROLE_STUDENT');