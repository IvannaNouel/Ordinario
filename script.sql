CREATE DATABASE IF NOT EXISTS DBUnit;
USE DBUnit;
CREATE TABLE IF NOT EXISTS Alumnos(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(40) NOT NULL,
  Email VARCHAR(40) NOT NULL,
  age INT NOT NULL,
  grade FLOAT NOT NULL
);
