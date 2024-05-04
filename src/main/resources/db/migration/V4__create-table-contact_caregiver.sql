CREATE TABLE contact_caregiver (
  id SERIAL NOT NULL,
   ddi VARCHAR(4),
   ddd VARCHAR(3),
   phone_number VARCHAR(9),
   caregiver_id INTEGER NOT NULL,
   CONSTRAINT pk_contact_caregiver PRIMARY KEY (id)
);

ALTER TABLE contact_caregiver ADD CONSTRAINT fk_contact_caregiver_on_caregiver FOREIGN KEY (caregiver_id) REFERENCES caregivers (id);