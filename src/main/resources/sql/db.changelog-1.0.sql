--liquibase formatted sql

--changeset aziz:1
CREATE TABLE vehicle (
    id BIGSERIAL PRIMARY KEY,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    production_year INTEGER NOT NULL,
    kilometres DOUBLE PRECISION NOT NULL,
    city TEXT NOT NULL,
    price NUMERIC(10, 3) NOT NULL,
    created_date TIMESTAMPTZ,
    last_modified_date TIMESTAMPTZ
);
--rollback drop table vehicle;

--changeset aziz:2
CREATE TABLE picture (
    id BIGINT PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    vehicle_id BIGINT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);
--rollback drop table picture;

--changeset aziz:3
CREATE TABLE IF NOT EXISTS app_user (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
--rollback drop table app_user;