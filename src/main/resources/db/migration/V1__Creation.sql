CREATE SCHEMA IF NOT EXISTS carwasher AUTHORIZATION carwasher;

CREATE TABLE IF NOT EXISTS carwasher.clients (
   id serial NOT NULL UNIQUE,
   name varchar(40) NOT NULL,
   surname varchar(40),
   service varchar(50) NOT NULL,
   birthday DATE,
   CONSTRAINT clients_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS carwasher.car (
     id serial NOT NULL UNIQUE,
     type varchar(40) NOT NULL,
     CONSTRAINT car_pk PRIMARY KEY (id)
);

ALTER TABLE carwasher.car ADD CONSTRAINT car_fk0 FOREIGN KEY (id) REFERENCES carwasher.clients(id);
