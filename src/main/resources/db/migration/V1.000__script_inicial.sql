CREATE TABLE categoria_despesa(
    id UUID NOT NULL,
    nome VARCHAR(60) NULL,
    descricao VARCHAR(100) NOT NULL,

    CONSTRAINT categoria_despesa_key PRIMARY KEY (id)
);

CREATE TABLE categoria_renda(
    id UUID NOT NULL,
    nome VARCHAR(60) NULL,
    descricao VARCHAR(100) NOT NULL,

    CONSTRAINT categoria_renda_key PRIMARY KEY (id)
);

CREATE TABLE usuario(
    id UUID NOT NULL,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(120) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    salario NUMERIC(15,2) NULL,

    CONSTRAINT usuario_key PRIMARY KEY (id)
);

CREATE TABLE despesa(
    id UUID NOT NULL,
    valor NUMERIC(15,2) NULL,
    data TIMESTAMP NOT NULL DEFAULT NOW(),
    parcelado BOOL DEFAULT FALSE,
    parcela SMALLINT,
    categoria_id UUID NOT NULL,
    usuario_id UUID NOT NULL,

    CONSTRAINT despesa_key PRIMARY KEY (id),
    CONSTRAINT categoria_despesa_fk FOREIGN KEY (categoria_id) REFERENCES categoria_despesa(id),
    CONSTRAINT usuario_despesa_fk FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE renda(
    id UUID NOT NULL,
    valor NUMERIC(15,2) NULL,
    data TIMESTAMP NOT NULL DEFAULT NOW(),
    parcelado BOOL DEFAULT FALSE,
    parcela SMALLINT,
    categoria_id UUID NOT NULL,
    usuario_id UUID NOT NULL,

    CONSTRAINT renda_key PRIMARY KEY (id),
    CONSTRAINT renda_categoria_fk FOREIGN KEY (categoria_id) REFERENCES categoria_renda(id),
    CONSTRAINT renda_usuario_fk FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);