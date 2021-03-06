
-- first execute the script creating role and user
-- TODO: change from Romanian locale to English locale
CREATE DATABASE caristuffdb
WITH OWNER = caristuffrole
ENCODING = 'UTF8'
TABLESPACE = pg_default
LC_COLLATE = 'English_United States.1252'
LC_CTYPE = 'English_United States.1252'
CONNECTION LIMIT = -1;

ALTER ROLE caristuff IN DATABASE caristuffdb
SET application_name = 'caristuffapp';
GRANT CONNECT, TEMPORARY ON DATABASE caristuffdb TO public;
GRANT ALL ON DATABASE caristuffdb TO caristuffrole;


CREATE SCHEMA caristuff
  AUTHORIZATION caristuffrole;

GRANT ALL ON SCHEMA caristuff TO caristuffrole;
COMMENT ON SCHEMA caristuff
IS 'schema for cariStuff app';
