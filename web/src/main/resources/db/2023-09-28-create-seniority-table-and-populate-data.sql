CREATE TABLE SENIORITY
(
id uuid PRIMARY KEY,
title varchar(255) NOT NULL UNIQUE
);



INSERT INTO SENIORITY(id, title) VALUES
('f7cfd1ae-0add-4d0c-9db0-7d2b2e2795b1','INTERN'),
('6010de3a-5dfb-11ee-8c99-0242ac120002','ASSOCIATE'),
('66ca812c-5dfb-11ee-8c99-0242ac120002','JUNIOR'),
('6ba5d070-5dfb-11ee-8c99-0242ac120002','REGULAR'),
('706d8ba2-5dfb-11ee-8c99-0242ac120002','SENIOR'),
('741f4038-5dfb-11ee-8c99-0242ac120002','TEAM LEADER'),
('78944410-5dfb-11ee-8c99-0242ac120002','PRINCIPAL'),
('7c9ee394-5dfb-11ee-8c99-0242ac120002','DIRECTOR')
;