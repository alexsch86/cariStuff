
CREATE SEQUENCE caristuff.dummytable_id_seq;

CREATE TABLE caristuff.dummytable
(
  ID INTEGER PRIMARY KEY DEFAULT nextval('caristuff.dummytable_id_seq'),
  DESCRIPTION varchar(100) NOT NULL,
  SOME_INTEGER INTEGER NOT NULL,
  SOME_NUMBER NUMERIC(11,2) NOT NULL,
  SOME_DATE DATE
);
