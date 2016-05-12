/* using serial for id since it auto-adds seq*/

CREATE TABLE caristuff.drivertable
(
  id            SERIAL PRIMARY KEY,
  user_id       INTEGER REFERENCES caristuff.usertable (id),
  version       INTEGER     NOT NULL DEFAULT 1,
  activated     BOOLEAN     NOT NULL DEFAULT FALSE,
  base_town     VARCHAR(30) NOT NULL,
  action_radius INTEGER
);

INSERT INTO caristuff.drivertable
VALUES (default, 1, default, FALSE, 'Bucuresti', 15);



