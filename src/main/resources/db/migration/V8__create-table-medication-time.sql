CREATE TABLE medication_time (
  id SERIAL NOT NULL,
   medicine_id INTEGER NOT NULL,
   hour TIME NOT NULL,
   CONSTRAINT pk_medication_time PRIMARY KEY (id)
);

ALTER TABLE medication_time ADD CONSTRAINT fk_medication_time_on_medicine FOREIGN KEY (medicine_id) REFERENCES medicines (id);