


ALTER TABLE ADDRESS
DROP COLUMN company_id;



CREATE TABLE ADVERTISEMENT
(
id uuid PRIMARY KEY,
title varchar(255) NOT NULL,
description varchar(500) NOT NULL,
is_active BOOLEAN NOT NULL,
currency_type varchar(255),
money_amount DECIMAL(10,2),
company_id uuid,
FOREIGN KEY(company_id) REFERENCES COMPANY(id)
);


CREATE TABLE ADVERTISEMENT_EMPLOYMENT_TYPE
(
id uuid PRIMARY KEY,
employment_id uuid,
advertisement_id uuid,
FOREIGN KEY(employment_id) REFERENCES EMPLOYMENT(id),
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);


CREATE TABLE  ADVERTISEMENT_SENIORITY_LEVEL
(
id uuid PRIMARY KEY,
seniority_id uuid,
advertisement_id uuid,
FOREIGN KEY(seniority_id) REFERENCES SENIORITY(id),
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);


CREATE TABLE REQUIREMENT
(
id uuid PRIMARY KEY,
description varchar(500),
advertisement_id uuid,
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);


CREATE TABLE ADVERTISEMENT_LOCATION
(
id uuid PRIMARY KEY,
address_id uuid,
advertisement_id uuid,
FOREIGN KEY(address_id) REFERENCES ADDRESS(id),
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);


CREATE TABLE BENEFIT
(
id uuid PRIMARY KEY,
description varchar(500) NOT NULL,
advertisement_id uuid,
FOREIGN KEY(advertisement_id) REFERENCES ADVERTISEMENT(id)
);