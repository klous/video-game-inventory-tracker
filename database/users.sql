CREATE USER videogamedb_owner
WITH PASSWORD 'videogames';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO videogamedb_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO videogamedb_owner;

CREATE USER videogamedb_appuser
WITH PASSWORD 'videogames';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO videogamedb_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO videogamedb_appuser;
