CREATE DATABASE dbplaybox
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

---------------------------USUARIO----------------------------

CREATE TABLE usuario
(
    id int,
	nome VARCHAR(300) NOT NULL,
    login VARCHAR(100) NOT NULL,
    pw VARCHAR(100) NOT NULL,
    perfil VARCHAR(50) NOT NULL,
    situacao VARCHAR(20) NOT NULL,

    -- Tipos de PERFIL: CLIENTE, FUNCIONARIO E ADMINISTRADOR

    CONSTRAINT idPk primary key (id)
);

CREATE SEQUENCE id_user;

INSERT INTO usuario VALUES (NEXTVAL('id_user'), 'ADMIN', 'renato', 'albert', 'ADMINISTRADOR', 'ATIVO');
INSERT INTO usuario VALUES (NEXTVAL('id_user'), 'ADMIN', 'kaua', 'melo', 'ADMINISTRADOR', 'ATIVO');
INSERT INTO usuario VALUES (NEXTVAL('id_user'), 'ADMIN', 'rodrigo', 'kenji', 'ADMINISTRADOR', 'ATIVO');


SELECT * FROM usuario


---------------------------PRODUTO----------------------------

CREATE TABLE produto (
	id INT,
	nome VARCHAR NOT NULL,
	descricao VARCHAR NOT NULL,
	imagem VARCHAR,
	situacao VARCHAR NOT NULL,
	quantidade INT NOT NULL CHECK (quantidade >=0),
	preco FLOAT NOT NULL,
	
	CONSTRAINT idPk_produto PRIMARY KEY (id)
);

CREATE SEQUENCE id_produto;

    
INSERT INTO produto VALUES (NEXTVAL('id_produto'), 'Caneca Dragon Ball', 'brinde_legal', 'img', 'ATIVO', 1, 15.0);
INSERT INTO produto VALUES (NEXTVAL('id_produto'), 'Pulseira Pokemon Plus', 'brinde_legal', 'img', 'ATIVO', 1, 150.0);
INSERT INTO produto VALUES (NEXTVAL('id_produto'), 'Action Figure Finn Star Wars', 'brinde_legal', 'img', 'ATIVO', 1, 60.0);
INSERT INTO produto VALUES (NEXTVAL('id_produto'), 'Gift Card Xbox Live Pass 100LiveCredits', 'brinde_legal', 'img', 'ATIVO', 1, 100.0);
INSERT INTO produto VALUES (NEXTVAL('id_produto'), 'Chaveiro Escudo Zelda Marjoras Mask', 'brinde_legal', 'img', 'ATIVO', 1, 7.0);


SELECT * FROM produto

---------------------------GAMES----------------------------

CREATE TABLE games
(
    id INT,
    nome VARCHAR NOT NULL,
    descricao VARCHAR NOT NULL,
    plataforma VARCHAR NOT NULL,
    imagem VARCHAR NOT NULL,
    situacao VARCHAR NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade >=0),
    preco FLOAT NOT NULL,

    CONSTRAINT idGamePk PRIMARY KEY (id)

);

CREATE SEQUENCE id_game;

INSERT INTO games VALUES (NEXTVAL('id_game'), 'God of War III', 'brinde_legal', 'PS', 'img', 'ATIVO', 1, 2.0);
INSERT INTO games VALUES (NEXTVAL('id_game'), 'GTA V', 'brinde_legal', 'Xbox', 'img', 'ATIVO', 1, 2.0);
INSERT INTO games VALUES (NEXTVAL('id_game'), 'Dragon Ball Z', 'brinde_legal', 'PC', 'img', 'ATIVO', 1, 2.0);

select * from games
---------------------------CAMISETA----------------------------

CREATE TABLE camiseta 
(
    id INT,
    nome VARCHAR NOT NULL,
    descricao VARCHAR NOT NULL,
    sexo VARCHAR NOT NULL,
    tamanho VARCHAR NOT NULL,
    imagem VARCHAR NOT NULL,
    situacao VARCHAR NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade >=0),
    preco FLOAT NOT NULL,

    CONSTRAINT idCamisetaPk PRIMARY KEY (id)

);

CREATE SEQUENCE id_camiseta;

INSERT INTO camiseta VALUES (NEXTVAL('id_camiseta'), 'Camiseta', 'Zelda', 'Masculino', 'P', 'img', 'ATIVO', 1, 20.0);

select * from camiseta

---------------------------------ASSINATURA-----------------------------------

CREATE TABLE assinatura (

    id INT,
    nome VARCHAR NOT NULL,
    preco FLOAT NOT NULL,
	
	CONSTRAINT idAssinaturaPk PRIMARY KEY (id)

);

CREATE SEQUENCE id_assinatura;

INSERT INTO assinatura VALUES (NEXTVAL('id_assinatura'),'Ouro',60);
INSERT INTO assinatura VALUES (NEXTVAL('id_assinatura'),'Prata',40);
INSERT INTO assinatura VALUES (NEXTVAL('id_assinatura'),'Bronze',20);

select * from assinatura
---------------------------------CLIENTE-----------------------------------

CREATE TABLE cliente (
    id INT,
    situacao VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    nomecompleto VARCHAR NOT NULL,
    datanascimento VARCHAR NOT NULL,
    genero VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    senha VARCHAR NOT NULL,
    celular VARCHAR NOT NULL,
    assinaturaFk INT,
    cobranca INT,

    CONSTRAINT idClientePk PRIMARY KEY (id),
    CONSTRAINT assinaturaFk FOREIGN KEY (assinaturaFk) REFERENCES assinatura (id)

);

    CREATE SEQUENCE id_cliente;
	
	select * from cliente

---------------------------------CARTAO DE CREDITO-----------------------------------

CREATE TABLE cartaocredito (

    id INT,
    numerocartao VARCHAR,
    nomeimpresso VARCHAR,
    validade VARCHAR,
    codigo int,
    bandeira VARCHAR,
    clienteFk INT,

    CONSTRAINT idCartaoCreditoPk PRIMARY KEY (id),
    CONSTRAINT clienteFk FOREIGN KEY (clienteFk) REFERENCES Cliente (id)

);

    CREATE SEQUENCE id_cartaocredito
	
	select * from cartaocredito


---------------------------------ENDERECO-----------------------------------

CREATE TABLE endereco (
    id INT,
    cep INT NOT NULL,
    rua VARCHAR NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR,
    bairro VARCHAR NOT NULL,
    cidade VARCHAR NOT NULL,
    uf VARCHAR NOT NULL,
    clienteFk INT,

    CONSTRAINT idEnderecoPk PRIMARY KEY (id),
    CONSTRAINT clienteFk FOREIGN KEY (clienteFk) REFERENCES Cliente (id)

);

CREATE SEQUENCE id_endereco

select * from endereco

------------------------------- PACOTE---------------------------------

CREATE TABLE pacote (
    id INT,
    assinaturaFk INT NOT NULL,
    nome VARCHAR NOT NULL,
    gameFk INT NOT NULL,
    camisetaFk INT NOT NULL,
    brindeFk1 INT NOT NULL,
    brindeFk2 INT,
    brindeFk3 INT,
    brindeFk4 INT,
    brindeFk5 INT,
    situacao VARCHAR NOT NULL,
	preco FLOAT NOT NULL,

    CONSTRAINT idPacotePk PRIMARY KEY (id),
    CONSTRAINT gameFk FOREIGN KEY (gameFk) REFERENCES Games (id),
    CONSTRAINT camisetaFk FOREIGN KEY (camisetaFk) REFERENCES Camiseta (id),
    CONSTRAINT brindeFk1 FOREIGN KEY (brindeFk1) REFERENCES Produto (id),
    CONSTRAINT brindeFk2 FOREIGN KEY (brindeFk2) REFERENCES Produto (id),
    CONSTRAINT brindeFk3 FOREIGN KEY (brindeFk3) REFERENCES Produto (id),
    CONSTRAINT brindeFk4 FOREIGN KEY (brindeFk4) REFERENCES Produto (id),
    CONSTRAINT brindeFk5 FOREIGN KEY (brindeFk5) REFERENCES Produto (id),
    CONSTRAINT assinaturaFK FOREIGN KEY (assinaturaFk) REFERENCES Assinatura (id)

);

    CREATE SEQUENCE id_pacote;

    INSERT INTO pacote VALUES (NEXTVAL('id_pacote'), 1,'Ouro', 
    (SELECT id FROM games WHERE nome = 'God of War III'), 
    (SELECT id FROM camiseta WHERE nome = 'Camiseta'), 
    (SELECT id FROM produto WHERE nome = 'Caneca Dragon Ball'), 
    (SELECT id FROM produto WHERE nome = 'Pulseira Pokemon Plus'), 
    (SELECT id FROM produto WHERE nome = 'Action Figure Finn Star Wars'), 
    (SELECT id FROM produto WHERE nome = 'Gift Card Xbox Live Pass 100LiveCredits'), 
    (SELECT id FROM produto WHERE nome = 'Chaveiro Escudo Zelda Marjoras Mask'),
    'Ativo', 25);
	
	SELECT * FROM pacote

---------------------------------- PREFERENCIA ----------------------------

CREATE TABLE preferencia (
    id INT,
    preferencia1 VARCHAR NOT NULL,
    preferencia2 VARCHAR NOT NULL,
    preferencia3 VARCHAR NOT NULL,
    horasjogo VARCHAR NOT NULL,
    jogoonline VARCHAR NOT NULL,

    CONSTRAINT idPreferenciaPk PRIMARY KEY (id)
);

    CREATE SEQUENCE id_preferencia

select * from preferencia

---------------------------------- PESQUISA ----------------------------

CREATE TABLE pesquisacancelamento (

	id INT,
	avaliacao1 VARCHAR NOT NULL,
	avaliacao2 VARCHAR NOT NULL,
	avaliacao3 VARCHAR NOT NULL,
	avaliacao4 VARCHAR NOT NULL,
	avaliacao5 VARCHAR NOT NULL,
	
	CONSTRAINT idPesquisaPk PRIMARY KEY (id)

);

CREATE SEQUENCE id_pesquisa

    -------------------------------METODO PAGAMENTO---------------------------------

CREATE TABLE MetodoPagamento (

    id INT,
    metodo VARCHAR NOT NULL,

    CONSTRAINT idMeiopgtoPk PRIMARY KEY (id)
);

CREATE SEQUENCE id_metodopagamento

INSERT INTO MetodoPagamento VALUES (NEXTVAL('id_metodopagamento'), 'Boleto');
INSERT INTO MetodoPagamento VALUES (NEXTVAL('id_metodopagamento'), 'Cartao de Credito');

select * from MetodoPagamento


    -------------------------------STATUS---------------------------------

create table status (
	id int,
	nome varchar,
	
	CONSTRAINT idStatusPk PRIMARY KEY (id)
);

CREATE SEQUENCE id_status;

INSERT INTO status values (NEXTVAL('id_status'),'Aguardando baixa no pagamento');
INSERT INTO status values (NEXTVAL('id_status'),'Separando pedido');
INSERT INTO status values (NEXTVAL('id_status'),'Pedido despachado p/ transportadora');
INSERT INTO status values (NEXTVAL('id_status'),'Pedido em transporte');
INSERT INTO status values (NEXTVAL('id_status'),'Pedido entregue');
INSERT INTO status values (NEXTVAL('id_status'),'Pedido Cancelado');

select * from status


    -------------------------------COMPRA---------------------------------

CREATE TABLE compra (

    id INT,
    datahora DATE NOT NULL,
    valor FLOAT NOT NULL,
    statusFK INT,
    clienteFk INT,
    enderecoEntregaFk INT,
    metodoPagamentoFk INT,
    cartaocreditoFk INT,
    tipoCompra VARCHAR NOT NULL

    CONSTRAINT idCompraPk PRIMARY KEY (id),
    CONSTRAINT statusFK FOREIGN KEY (statusFK) REFERENCES status (id),
    CONSTRAINT clienteFk FOREIGN KEY (clienteFk) REFERENCES Cliente (id),
    CONSTRAINT enderecoEntregaFk FOREIGN KEY (enderecoEntregaFk) REFERENCES Endereco (id),
    CONSTRAINT metodoPagamentoFk FOREIGN KEY (metodoPagamentoFk) REFERENCES MetodoPagamento (id),
    CONSTRAINT cartaocreditoFk FOREIGN KEY (cartaocreditoFk) REFERENCES cartaocredito (id)

);

CREATE SEQUENCE id_compra AS int START WITH 1000 INCREMENT BY 1 ;



----------------------INSERTS COMPRA-----------------------------
INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-05-08', 50, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-05-08', 60, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-05-08', 70, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-04-08', 60, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-04-08', 50, 5, 1, 1, 2, 1);
    INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-03-08', 50, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-02-08', 60, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-01-08', 70, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-01-08', 60, 5, 1, 1, 2, 1);
	
	INSERT INTO compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk)
	VALUES (NEXTVAL('id_compra'), '2020-01-08', 50, 5, 1, 1, 2, 1);

--funciona
UPDATE compra c
SET c.clienteFk = ? 
WHERE c.id IN (SELECT MAX(ID) FROM compra)

--n funciona
SELECT
DISTINCT
c.datahora,c.clienteFk FROM compra c, cliente cli
WHERE
c.datahora = (select max(c.datahora) from compra where c.clienteFk = cli.id)

------------------- TABELA, FUNCTION E TRIGGER ARMAZENA CLIENTE EXCLUIDO NA TABELA  BKP ---------------------------


CREATE TABLE log_cliente_alterado (
    datahora DATE,
    id INT,
    situacao VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    nomecompleto VARCHAR NOT NULL,
    datanascimento VARCHAR NOT NULL,
    genero VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    senha VARCHAR NOT NULL,
    celular VARCHAR NOT NULL
    
);

CREATE FUNCTION log_clientes_alterados()
RETURNS trigger
AS $$
    BEGIN
        INSERT INTO log_cliente_alterado VALUES (NOW(),OLD.id, OLD.situacao, OLD.cpf, OLD.nomecompleto, OLD.datanascimento, OLD.genero, OLD.email, OLD.senha, OLD.celular);
        RETURN OLD;
    END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER executa_backup_clientes
AFTER UPDATE ON cliente
FOR EACH ROW EXECUTE PROCEDURE log_clientes_alterados();

----------------- TABELA, FUNCTION E TRIGGER PARA GUARDAR TODAS AS EDIÇÕES DE CLIENTES ----------------------

CREATE TABLE log_edicao_clientes (
    id_antigo INT,
    situacao VARCHAR NOT NULL,
    cpf_antigo VARCHAR NOT NULL,
    nomecompleto_antigo VARCHAR NOT NULL,
    datanascimento_antigo VARCHAR NOT NULL,
    genero_antigo VARCHAR NOT NULL,
    email_antigo VARCHAR NOT NULL,
    senha_antigo VARCHAR NOT NULL,
    celular_antigo VARCHAR NOT NULL,

    CONSTRAINT id_ClientePk PRIMARY KEY (id_antigo)

);

CREATE OR REPLACE FUNCTION log_edicao_clientes()
RETURNS trigger
AS $$
    BEGIN
        INSERT INTO log_edicao_clientes VALUES (OLD.id, OLD.situacao, OLD.cpf, OLD.nomecompleto, OLD.datanascimento, OLD.genero, OLD.email, OLD.senha, OLD.celular);
        RETURN OLD;
    END;
$$ LANGUAGE plpgsql;
 
CREATE TRIGGER executa_log_edicao_usuarios
AFTER UPDATE ON usuario
    FOR EACH ROW EXECUTE PROCEDURE log_edicao_clientes();

----------------- TABELA, FUNCTION E TRIGGER PARA GUARDAR TODOS DADOS DE NOVOS CLIENTES ----------------------

CREATE TABLE log_novo_cliente (
    datahora DATE,
    id INT,
    situacao VARCHAR,
    cpf VARCHAR NOT NULL,
    nomecompleto VARCHAR NOT NULL,
    datanascimento VARCHAR NOT NULL,
    genero VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    senha VARCHAR NOT NULL,
    celular VARCHAR NOT NULL
    
);
CREATE FUNCTION data_cadastro()
RETURNS trigger
AS $$
    BEGIN
		INSERT INTO log_novo_cliente VALUES (NOW(),NEW.id, NEW.situacao, NEW.cpf, NEW.nomecompleto, NEW.datanascimento, NEW.genero, NEW.email, NEW.senha, NEW.celular);        
        RETURN NEW;
    END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER data_cadastro_novo_cliente
AFTER INSERT
ON cliente
FOR EACH ROW EXECUTE PROCEDURE data_cadastro();

select * from log_novo_cliente

----------------- FUNCTION PARA NÃO AUTORIZAR EXCLUSÃO DO USER ADMIN ----------------------