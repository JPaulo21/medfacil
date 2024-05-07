ALTER TABLE medicines ADD COLUMN routes_of_administration VARCHAR;
ALTER TABLE medicines ADD COLUMN frequency INTEGER;
ALTER TABLE medicines ADD COLUMN type_frequency VARCHAR;
ALTER TABLE medicines ADD COLUMN start_date TIMESTAMP;
ALTER TABLE medicines ADD COLUMN duration VARCHAR;
ALTER TABLE medicines ADD COLUMN observation VARCHAR;
ALTER TABLE medicines ADD COLUMN enabled BOOLEAN;