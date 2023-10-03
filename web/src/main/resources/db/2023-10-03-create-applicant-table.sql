CREATE TABLE APPLICANT
(
id uuid PRIMARY KEY,
status varchar(255) NOT NULL,
employee_id uuid,
advertisement_id uuid,
application_date DATE,
FOREIGN KEY(employee_id) REFERENCES EMPLOYEE(id),
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);



CREATE TABLE COMPANY_LOCATION
(
id uuid PRIMARY KEY,
address_id uuid,
company_id uuid,
FOREIGN KEY(address_id) REFERENCES ADDRESS(id),
FOREIGN KEY(company_id) REFERENCES COMPANY(id)
);



CREATE TABLE COMPANY_CATEGORIES
(
id uuid PRIMARY KEY,
category_id uuid,
company_id uuid,
FOREIGN KEY (category_id) REFERENCES CATEGORY(id),
FOREIGN KEY (company_id) REFERENCES COMPANY(id)
);


CREATE TABLE USER_ROLES
(
id uuid PRIMARY KEY,
user_id uuid,
role_id uuid,
FOREIGN KEY(user_id) REFERENCES CUSTOM_USER(id),
FOREIGN KEY(role_id) REFERENCES ROLE(id)
);