-- Criação da tabela clients
CREATE TABLE clients (
    id_client UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);