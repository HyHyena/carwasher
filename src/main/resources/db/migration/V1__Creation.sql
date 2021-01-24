CREATE SCHEMA IF NOT EXISTS carwasher AUTHORIZATION carwasher;

CREATE TABLE IF NOT EXISTS carwasher.clients (
    id serial NOT NULL UNIQUE,
    name varchar(40) NOT NULL,
    surname varchar(40),
    service varchar(50) NOT NULL,
    birthday DATE,
    car_id integer NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS carwasher.car (
    id serial NOT NULL UNIQUE,
    brand varchar(50) NOT NULL,
    type varchar(40),
    CONSTRAINT car_pk PRIMARY KEY (id)
);

ALTER TABLE carwasher.clients ADD CONSTRAINT car_fk0 FOREIGN KEY (car_id) REFERENCES carwasher.car(id);