CREATE TABLE users (
  id SERIAL NOT NULL,
   cpf VARCHAR(11),
   password VARCHAR(255),
   name VARCHAR(255),
   birth_date date,
   sex VARCHAR(1) CHECK(sex IN ('M','F')),
   email VARCHAR(255),
   ddi VARCHAR(4),
   ddd VARCHAR(3),
   phone_number VARCHAR(9),
   role VARCHAR(255),
   enable BOOLEAN NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id),
   CONSTRAINT uc_number UNIQUE(ddi, ddd, phone_number)
);

ALTER TABLE users ADD CONSTRAINT uc_users_cpf UNIQUE (cpf);