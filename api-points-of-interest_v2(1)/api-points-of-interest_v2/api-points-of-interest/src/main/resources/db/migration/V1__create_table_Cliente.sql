CREATE TABLE Cliente (
    age INT NOT NULL,
    cpf varchar(500) NOT NULL,
    name varchar(500) NOT NULL,
    income double NOT NULL,
    location varchar(500) NOT NULL,
    PRIMARY KEY (cpf)
);