/* using serial for id since it auto-adds seq*/

CREATE TABLE caristuff.vehicle
(
  id                   SERIAL PRIMARY KEY,
  driver_id            INTEGER REFERENCES caristuff.drivertable (id),
  make                 VARCHAR(30) NOT NULL,
  model                VARCHAR(30) NOT NULL,
  plate_number         VARCHAR(10) NOT NULL,
  registration_id      VARCHAR(10) NOT NULL,
  first_registration   INTEGER     NOT NULL,
  volume_capacity      INTEGER,
  transport_properties VARCHAR(50),
  maximum_mass         INTEGER     NOT NULL,
  fragile_compatible   BOOLEAN     NOT NULL DEFAULT FALSE,
  registration_picture BYTEA,
  version              INTEGER     NOT NULL DEFAULT 1

);

INSERT INTO caristuff.vehicle
VALUES (DEFAULT, 1, 'Ford', 'Focus', 'B123ABC', 'H123456', 2014, 1500, 'Some properties', 1800, FALSE, NULL, DEFAULT);

