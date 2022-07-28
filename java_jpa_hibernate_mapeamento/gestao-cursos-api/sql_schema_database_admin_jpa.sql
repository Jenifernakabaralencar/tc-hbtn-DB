-- TABLE
CREATE TABLE aluno (id bigint not null, email varchar(255), matricula varchar(255), nascimento datetime, nomeCompleto varchar(255), primary key (id));
CREATE TABLE curso (id bigint not null, nome varchar(255), sigla varchar(255), materialCurso_id bigint, professor_id bigint, curso_id bigint, primary key (id));
CREATE TABLE curso_aluno (curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE endereco (id bigint not null, bairro varchar(255), cep varchar(255), cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), endereco_id bigint, primary key (id));
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE materialCurso (id bigint not null, url varchar(255), curso_id bigint, primary key (id));
CREATE TABLE professor (id bigint not null, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE telefone (id bigint not null, DDD varchar(255), numero varchar(255), telefone_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
