-- Run this as the postgres superuser to transfer table ownership to statline_user.
-- This allows Hibernate (ddl-auto=update) to ALTER the tables it needs to migrate.
--
-- Usage: psql -U postgres -f fix_ownership.sql

\c statlineguessr

ALTER TABLE player   OWNER TO statline_user;
ALTER TABLE statline OWNER TO statline_user;
ALTER TABLE guess    OWNER TO statline_user;

ALTER SEQUENCE player_id_seq   OWNER TO statline_user;
ALTER SEQUENCE statline_id_seq OWNER TO statline_user;
ALTER SEQUENCE guess_id_seq    OWNER TO statline_user;
