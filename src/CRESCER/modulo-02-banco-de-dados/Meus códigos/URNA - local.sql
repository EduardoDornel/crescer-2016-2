-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2016-10-18 17:29:22 BRST
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Candidatos
  (
    IDCandidato     INTEGER NOT NULL ,
    NomeCompleto    VARCHAR2 (75) NOT NULL ,
    NomePopular     VARCHAR2 (30) NOT NULL ,
    DataNascimento  DATE NOT NULL ,
    RegistroTRE     VARCHAR2 (30) NOT NULL ,
    Foto            VARCHAR2 (100) NOT NULL ,
    NumeroEscolha   VARCHAR2 (5) NOT NULL ,
    FK_IDPartido    INTEGER NOT NULL ,
    FK_IDTipoCargo  INTEGER NOT NULL ,
    FK_IDCidade     INTEGER NOT NULL ,
    QuantidadeVotos INTEGER NOT NULL
  ) ;
ALTER TABLE Candidatos ADD CONSTRAINT Candidatos_PK PRIMARY KEY ( IDCandidato ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    Nome     VARCHAR2 (30) NOT NULL ,
    FK_IDUf  INTEGER NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT Cidade_PK PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor      INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (70) NOT NULL ,
    TituloEleitor  VARCHAR2 (15) NOT NULL ,
    RG             VARCHAR2 (10) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Zona           VARCHAR2 (3) NOT NULL ,
    Secao          VARCHAR2 (3) NOT NULL ,
    FK_IDCandidato INTEGER
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_PK PRIMARY KEY ( IDEleitor ) ;


CREATE TABLE Partido
  (
    IDPartido INTEGER NOT NULL ,
    nome      VARCHAR2 (30) NOT NULL ,
    Sigla     VARCHAR2 (5) NOT NULL
  ) ;
ALTER TABLE Partido ADD CONSTRAINT Partido_PK PRIMARY KEY ( IDPartido ) ;


CREATE TABLE TipoCargo
  (
    IDTipoCargo INTEGER NOT NULL ,
    tipo        VARCHAR2 (15) NOT NULL
  ) ;
ALTER TABLE TipoCargo ADD CONSTRAINT TipoCargo_PK PRIMARY KEY ( IDTipoCargo ) ;


CREATE TABLE UF
  (
    IDUf  INTEGER NOT NULL ,
    Nome  VARCHAR2 (25) NOT NULL ,
    Sigla VARCHAR2 (2) NOT NULL
  ) ;
ALTER TABLE UF ADD CONSTRAINT UF_PK PRIMARY KEY ( IDUf ) ;


ALTER TABLE Candidatos ADD CONSTRAINT Candidatos_Cidade_FK FOREIGN KEY ( FK_IDCidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Candidatos ADD CONSTRAINT Candidatos_Partido_FK FOREIGN KEY ( FK_IDPartido ) REFERENCES Partido ( IDPartido ) ;

ALTER TABLE Candidatos ADD CONSTRAINT Candidatos_TipoCargo_FK FOREIGN KEY ( FK_IDTipoCargo ) REFERENCES TipoCargo ( IDTipoCargo ) ;

ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_Candidatos_FK FOREIGN KEY ( FK_IDCandidato ) REFERENCES Candidatos ( IDCandidato ) ;

ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_UF FOREIGN KEY ( FK_IDUf ) REFERENCES UF ( IDUf ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             0
-- ALTER TABLE                             11
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
