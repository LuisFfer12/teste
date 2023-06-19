CREATE TABLE cliente
(
    id        bigserial    NOT NULL PRIMARY KEY,
    nome    varchar(255) NOT NULL,
    cpf varchar(255) NOT NULL
);
CREATE TABLE celular
(
    id        bigserial    NOT NULL PRIMARY KEY,
    ddd    varchar(255) NOT NULL,
    numero varchar(255) NOT NULL,
    cliente_id int NOT NULL,
    CONSTRAINT fk_id_cliente
        FOREIGN KEY(cliente_id)
            REFERENCES cliente(id)
);
CREATE TABLE email
(
    id        bigserial    NOT NULL PRIMARY KEY,
    email    varchar(255) NOT NULL,
    cliente_id int NOT NULL,
    CONSTRAINT fk_id_cliente
        FOREIGN KEY(cliente_id)
            REFERENCES cliente(id)
);