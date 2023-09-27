CREATE TABLE CUSTOM_USER
(
id uuid PRIMARY KEY,
email_address varchar(255) NOT NULL UNIQUE,
first_name varchar(255) NOT NULL,
last_name varchar(255) NOT NULL,
password varchar(255) NOT NULL
);

CREATE TABLE EMPLOYER
(
id uuid PRIMARY KEY,
user_id uuid,
FOREIGN KEY(user_id) REFERENCES CUSTOM_USER(id)
);

CREATE TABLE EMPLOYEE
(
id uuid PRIMARY KEY,
user_id uuid,
FOREIGN KEY(user_id) REFERENCES CUSTOM_USER(id)
);



CREATE TABLE COMPANY
(
id uuid PRIMARY KEY,
name varchar(255) NOT NULL,
description varchar(500) NOT NULL,
nip_number varchar(20) NOT NULL UNIQUE,
regon_number varchar(20) NOT NULL UNIQUE,
image_url varchar(255),
creation_date DATE,
employer_id uuid,
FOREIGN KEY(employer_id) REFERENCES EMPLOYER(id)
);






CREATE TABLE ADDRESS
(
id uuid PRIMARY KEY,
city varchar(255) NOT NULL,
street varchar(255) NOT NULL,
company_id uuid,
FOREIGN KEY(company_id) REFERENCES COMPANY(id)
);