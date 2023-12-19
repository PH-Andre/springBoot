CREATE TABLE Credito (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo varchar(500) NOT NULL,
    taxa double NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE User (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username varchar(500) NOT NULL,
    senha varchar(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome varchar(500) NOT NULL,
    PRIMARY KEY (id));
    
CREATE TABLE user_roles (
    id BIGINT NOT NULL AUTO_INCREMENT,  
    user_id BIGINT,
    roles_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT FK_users_roles_user FOREIGN KEY (user_id) REFERENCES User(id),
    CONSTRAINT FK_users_roles_roles FOREIGN KEY (roles_id) REFERENCES role(id)
);