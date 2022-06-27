CREATE DATABASE catSchool;


CREATE TABLE aluno (
	id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    numeroDeMatricula VARCHAR(9),
    PRIMARY KEY (id)
);




CREATE TABLE professor (
	id INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
    formacao VARCHAR(25),
    identidadeProfissional VARCHAR(20),
    PRIMARY KEY (id)
    
);



