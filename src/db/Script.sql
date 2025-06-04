/*
	Drops
*/
Drop table conta_salario;
Drop table conta_poupanca;
Drop table conta_especial;
Drop table conta_corrente;
Drop table t_conta_bancaria;
Drop table t_pessoa_juridica;
Drop table t_quadro_societario;
Drop table t_pessoa_fisica;
Drop table t_pessoa;
Drop table t_agencia;
Drop table t_endereco;
Drop table t_banco;

Drop database db_controle_bancario;

/* 
	Database
*/
create database db_controle_bancario;
use db_controle_bancario;

/* 
	Tables
*/
CREATE TABLE t_banco (
    bd_id_banco integer AUTO_INCREMENT PRIMARY KEY,
    bd_cod_instituicao_banco CHAR(5),
    bd_nome_banco VARCHAR(100),
    bd_mascara_conta_banco VARCHAR(20)
);

CREATE TABLE t_endereco (
    bd_id_end integer AUTO_INCREMENT PRIMARY KEY,
    bd_cep_end CHAR(9),
    bd_uf_sigla_end CHAR(2),
    bd_municipio_end VARCHAR(100),
    bd_bairro_end VARCHAR(100),
    bd_logradouro_end VARCHAR(150)
);

CREATE TABLE t_agencia (
    bd_id_age integer AUTO_INCREMENT PRIMARY KEY,
    bd_id_banco integer,
    bd_id_end integer,
    bd_num_end_age VARCHAR(10),
    bd_complemento_end_age VARCHAR(100),
    bd_fone_age VARCHAR(20),
    bd_status_age boolean default true,
    FOREIGN KEY (bd_id_banco) REFERENCES t_banco(bd_id_banco),
    FOREIGN KEY (bd_id_end) REFERENCES t_endereco(bd_id_end)
);

CREATE TABLE t_pessoa (
    bd_id_pes integer AUTO_INCREMENT PRIMARY KEY,
    bd_id_end integer,
    bd_num_end_pes VARCHAR(10),
    bd_complemento_end_pes VARCHAR(100),
    bd_fone_pes VARCHAR(20),
    bd_cliente_desde_pes DATE,
    bd_status_pes boolean default true,
    FOREIGN KEY (bd_id_end) REFERENCES t_endereco(bd_id_end)
);

CREATE TABLE t_pessoa_fisica (
    bd_id_pf integer PRIMARY KEY, -- herdado de pessoa, sem auto_increment
    bd_cpf_pf CHAR(14),
    bd_nome_registro_pf VARCHAR(100),
    bd_nome_social_pf VARCHAR(100),
    bd_nascimento_pf DATE,
    bd_sexo_pf ENUM('Masculino cis', 'Feminino cis', 'Masculino trans', 'Feminino trans',  'Outro'),
    bd_renda_mensal_pf numeric(10,2),
    FOREIGN KEY (bd_id_pf) REFERENCES t_pessoa(bd_id_pes)
);

Create table t_quadro_societario(
	bd_id_qs integer primary key auto_increment,
    bd_id_pes integer,
    bd_percentual_qs numeric(10,2),
    Foreign key (bd_id_pes) references t_pessoa(bd_id_pes)
);

CREATE TABLE t_pessoa_juridica (
    bd_id_pj integer PRIMARY KEY, -- herdado de pessoa, sem auto_increment
    bd_cnpj_pj CHAR(18),
    bd_razao_social_pj VARCHAR(100),
    bd_nome_fantasia_pj VARCHAR(100),
    bd_abertura_pj DATE,
    bd_id_qs integer,
    bd_capital_social_pj numeric(15,2),
    FOREIGN KEY (bd_id_pj) REFERENCES t_pessoa(bd_id_pes),
    Foreign key (bd_id_qs) references t_quadro_societario(bd_id_qs)
);

CREATE TABLE t_conta_bancaria (
    bd_id_cb integer AUTO_INCREMENT PRIMARY KEY,
    bd_id_age integer,
    bd_id_titular1_cb integer,
    bd_id_titular2_cb integer,
    bd_abertura_cb DATE,
    bd_saldo_cb numeric(15,2),
    bd_senha_cb VARCHAR(255),
    bd_bandeira_cartao_cb VARCHAR(20),
    bd_numero_cartao_cb CHAR(19),
    bd_validade_cartao_cb DATE,
    bd_cvv_cb CHAR(3),
    bd_status_cb ENUM('10', '5', '0'),-- 10- Ativa | 5- Inativa | 0- Cancelada
    FOREIGN KEY (bd_id_age) REFERENCES t_agencia(bd_id_age),
    FOREIGN KEY (bd_id_titular1_cb) REFERENCES t_pessoa(bd_id_pes),
    FOREIGN KEY (bd_id_titular2_cb) REFERENCES t_pessoa(bd_id_pes)
);

CREATE TABLE t_conta_corrente (
    bd_id_cc integer PRIMARY KEY, -- herdado de conta_bancaria
    FOREIGN KEY (bd_id_cc) REFERENCES t_conta_bancaria(bd_id_cb)
);

CREATE TABLE t_conta_especial (
    bd_id_ce integer PRIMARY KEY, -- herdado de conta_bancaria
    bd_limite_credito_ce numeric(15,2),
    bd_vencimento_limite_ce DATE,
    FOREIGN KEY (bd_id_ce) REFERENCES t_conta_bancaria(bd_id_cb)
);

CREATE TABLE t_conta_poupanca (
    bd_id_cp integer PRIMARY KEY, -- herdado de conta_bancaria
    bd_indice_reajuste_cp numeric(5,2),
    FOREIGN KEY (bd_id_cp) REFERENCES t_conta_bancaria(bd_id_cb)
);

CREATE TABLE t_conta_salario (
    bd_id_cs integer PRIMARY KEY, -- herdado de conta_bancaria
    bd_id_pj integer,
    bd_limite_adiantamento_cs numeric(10,2),
    bd_id_cb integer,
    FOREIGN KEY (bd_id_cs) REFERENCES t_conta_bancaria(bd_id_cb),
    FOREIGN KEY (bd_id_pj) REFERENCES t_pessoa_juridica(bd_id_pj),
    FOREIGN KEY (bd_id_cb) REFERENCES t_conta_bancaria(bd_id_cb)
);

