CREATE DATABASE IF NOT EXISTS sistemaven;

USE sistemaven;

CREATE TABLE IF NOT EXISTS users(
    id_user INT NOT NULL AUTO_INCREMENT,
    name_user VARCHAR(50),
    password_user VARCHAR(30),
    email_user VARCHAR(50),
    PRIMARY KEY (id_user)
);



INSERT INTO users (name_user, password_user, email_user) VALUES ("root", "root", "root@gmail.com");
INSERT INTO users (name_user, password_user, email_user) VALUES ("luisflahan4051", "4051", "luisflahan4051@gmail.com");
