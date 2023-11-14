CREATE TABLE eventos (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    data DATE,
    numero_maximo_de_colaboradores INT,
    horario_de_chegada TIME
);