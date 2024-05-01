CREATE TABLE caregivers(
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT pk_caregiver_on_id PRIMARY KEY(id)
);



