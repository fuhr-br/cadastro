INSERT INTO ENDERECO(
	id, LOGRADOURO, CEP, NUMERO, CIDADE)
	VALUES ('1', 'Rua das Marias','90050-230','234','João Pessoa');

INSERT INTO PESSOA(
	id, NOME, DATA_NASCIMENTO)
	VALUES (1, 'Anderson Fuhr','1980-01-08');

INSERT INTO ENDERECO_PESSOA(
     PESSOA_ID, ENDERECO_ID)
    VALUES (1,1);