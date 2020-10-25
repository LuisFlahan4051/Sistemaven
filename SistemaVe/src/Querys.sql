CREATE DATABASE IF NOT EXISTS sistemaven;

USE sistemaven;

CREATE TABLE IF NOT EXISTS users(
    id_user INT NOT NULL AUTO_INCREMENT,
    name_user VARCHAR(50),
    password_user VARCHAR(30),
    email_user VARCHAR(50),
    PRIMARY KEY (id_user)
);

CREATE TABLE IF NOT EXISTS clients(
    id_client INT NOT NULL AUTO_INCREMENT,
    name_client VARCHAR(50),
    email_client VARCHAR(50),
    PRIMARY KEY (id_client)
);

CREATE TABLE IF NOT EXISTS models(
    id_model INT NOT NULL AUTO_INCREMENT,
    model_model VARCHAR(50),
    type_model VARCHAR(50),
    talla_model VARCHAR(15),
    PRIMARY KEY (id_model)
);



INSERT INTO users (name_user, password_user, email_user) VALUES ("root", "root", "root@gmail.com");
INSERT INTO users (name_user, password_user, email_user) VALUES ("luisflahan4051", "4051", "luisflahan4051@gmail.com");
INSERT INTO clients (name_client, email_client) VALUES ("Cliente 1", "Cliente1@gmail.com");
INSERT INTO clients (name_client, email_client) VALUES ("Cliente 2", "Cliente2@gmail.com");
INSERT INTO models (model_model, type_model,talla_model) VALUES ("Modelo 1", "Tipo 1","25");
INSERT INTO models (model_model, type_model, talla_model) VALUES ("Modelo 2", "Tipo 2", "27");
