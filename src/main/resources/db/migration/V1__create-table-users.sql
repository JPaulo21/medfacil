CREATE TABLE users (
  id SERIAL NOT NULL,
   cpf VARCHAR(11),
   password VARCHAR(255),
   name VARCHAR(255),
   birth_date date,
   sex VARCHAR(1),
   email VARCHAR(255),
   ddi VARCHAR(4),
   ddd VARCHAR(2),
   phone_number VARCHAR(9),
   role VARCHAR(255),
   enable BOOLEAN NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uk_users_on_cpf UNIQUE (cpf);
ALTER TABLE users ADD CONSTRAINT uk_users_on_full_number UNIQUE (ddi, ddd, phone_number);
ALTER TABLE users ADD CONSTRAINT ck_users_on_sex CHECK (sex IN ('M','F'));
