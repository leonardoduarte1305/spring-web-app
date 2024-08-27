-- docker run -d --name postgres-local -e POSTGRES_DB=datasourcePostgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres:latest
-- PostgreSQL Datasource

-- Conectar ao banco de dados padrão
\c postgres;
-- Deletar conexões ativas no banco 'datasourcePostgres' antes de deletá-lo
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'datasourcePostgres'
  AND pid <> pg_backend_pid();

DROP DATABASE IF EXISTS datasourcepostgres;
CREATE DATABASE datasourcepostgres;

CREATE USER "postgres-user" WITH ENCRYPTED PASSWORD 'password';
CREATE USER "postgres-admin" WITH ENCRYPTED PASSWORD 'password';

-- Conectar ao banco de dados datasourcepostgres
\c datasourcepostgres;

CREATE SCHEMA IF NOT EXISTS public;
ALTER DATABASE datasourcepostgres OWNER TO "postgres-admin";
GRANT USAGE, CREATE ON SCHEMA public TO "postgres-admin";

GRANT CONNECT ON DATABASE datasourcepostgres TO "postgres-user";
GRANT USAGE ON SCHEMA public TO "postgres-user";
GRANT INSERT, UPDATE, DELETE, SELECT ON ALL TABLES IN SCHEMA public TO "postgres-admin";
