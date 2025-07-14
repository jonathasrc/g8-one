CREATE TABLE patient (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         telephone VARCHAR(20) NOT NULL,
                         cpf VARCHAR(14) NOT NULL UNIQUE,
                         logradouro VARCHAR(255) NOT NULL,
                         bairro VARCHAR(100) NOT NULL,
                         cep VARCHAR(9) NOT NULL,
                         complemento VARCHAR(100),
                         numero VARCHAR(20),
                         uf CHAR(2) NOT NULL,
                         cidade VARCHAR(100) NOT NULL,
                         PRIMARY KEY (id)
);