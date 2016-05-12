/* using serial for id since it auto-adds seq*/

CREATE TABLE caristuff.user
(
  ID           SERIAL PRIMARY KEY,
  FIRST_NAME    VARCHAR(30) NOT NULL,
  LAST_NAME    VARCHAR(30) NOT NULL,
  Identifier   VARCHAR(13) UNIQUE NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  card_number  VARCHAR(16) UNIQUE ,
  birth_date   DATE NOT NULL,
  rating       INTEGER NOT NULL DEFAULT 0
);

INSERT INTO caristuff.user
VALUES (DEFAULT, 'George', 'Fisher', '123456789', '0760112233', '1234123412341234', '1985-12-12', 5),
  (DEFAULT, 'Maria', 'Romario', '2345678901', '0760223344', '4321432143214321', '1986-10-10', DEFAULT);

