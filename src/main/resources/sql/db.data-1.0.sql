--liquibase formatted sql

--changeset aziz:4
INSERT INTO vehicle (id, brand, model, production_year, kilometres, city, price, created_date, last_modified_date)
VALUES
    (1, 'Chevrolet', 'Cobalt', 2024, 10.0, 'Tashkent', 13000.000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'Mercedes Benz', 'AMG GT63s', 2022, 3.0, 'Sindelfingen', 160000.000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

--changeset aziz:5
INSERT INTO picture (id, url, vehicle_id) VALUES (1, 'first_url_of_Cobalt', 1);
INSERT INTO picture (id, url, vehicle_id) VALUES (2, 'second_url_of_Cobalt', 1);
INSERT INTO picture (id, url, vehicle_id) VALUES (3, 'first_url_of_GT63s', 2);
INSERT INTO picture (id, url, vehicle_id) VALUES (4, 'second_url_of_GT63s', 2);

--changeset aziz:6
INSERT INTO app_user (id, first_name, last_name, login, password)
VALUES (2, 'Bruno', 'Fernandes', 'bruno', '$2a$10$0wkdHjGwk/MR75aFYKxyN.w1kzZY6pnmQrfp.4XoebRLAZuFsplCO');
INSERT INTO app_user (id, first_name, last_name, login, password)
VALUES (3, 'Bob', 'Martin', 'bob', '$2a$10$lsxyv7xQbeyGdtKAOwF93.C0Y1y4/Y83iay2thyBBJU0BK7NO7W1C');
