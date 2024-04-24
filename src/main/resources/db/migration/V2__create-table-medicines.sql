CREATE TABLE medicines (
    id SERIAL NOT NULL,
    user_id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    dosage VARCHAR(10) NOT NULL,
    pharmaceutical_form VARCHAR(10) NOT NULL,
    CONSTRAINT pk_medicines PRIMARY KEY(id)
);

ALTER TABLE medicines ADD CONSTRAINT FK_MEDICINES_ON_USER FOREIGN KEY (user_id) REFERENCES users(id);