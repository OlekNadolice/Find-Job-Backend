
CREATE TABLE ROLE
(
    id   uuid PRIMARY KEY ,
    name varchar(255) NOT NULL UNIQUE
);




INSERT INTO ROLE(id, name) VALUES
    ('e37063dc-5c92-11ee-8c99-0242ac120002',
        'ADMIN'),
       ('e8441980-5c92-11ee-8c99-0242ac120002',
        'EMPLOYEE'),
       ('ec3506b2-5c92-11ee-8c99-0242ac120002',
        'EMPLOYER');