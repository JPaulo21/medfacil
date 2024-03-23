CREATE TABLE users (
  id INTEGER SERIAL NOT NULL,
   cpf VARCHAR(11),
   name VARCHAR(255),
   birth_date date,
   sex VARCHAR(1),
   email VARCHAR(255),
   ddi VARCHAR(4),
   ddd VARCHAR(3),
   phone_number VARCHAR(9),
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_cpf UNIQUE (cpf);