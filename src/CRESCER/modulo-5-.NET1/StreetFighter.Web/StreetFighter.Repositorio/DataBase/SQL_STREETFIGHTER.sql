Create table Personagem
(
	Id int PRIMARY KEY IDENTITY not null,
	Nome varchar(255) not null,
	Origem varchar(255) not null,
	GolpesEspeciais varchar(255) not null,
	DataNascimento datetime not null,
	PrimeiraAparicao varchar(255) not null,
	Peso decimal not null,
	Imagem varchar(255),
	PersonagemOculto bit,
	Altura int not null
)

select * from Personagem

INSERT into Personagem(Nome, Origem, GolpesEspeciais, DataNascimento, PrimeiraAparicao, Peso, Imagem, PersonagemOculto, Altura)
VALUES('Eduardo','Brasil','Hackear','12/02/1997','Hospital',65,null,1,180)


INSERT INTO Personagem (Nome, Origem, GolpesEspeciais, DataNascimento, PrimeiraAparicao, Peso, Imagem, PersonagemOculto, Altura)
 VALUES ('Ribery','França','Velocidade','10/10/2010','Bayern de munique',70,'https://starity.hu/images/celebs/years/7979/800x600/2009.jpg',0,180)

 INSERT INTO Personagem (Origem, GolpesEspeciais, Nome, DataNascimento, PrimeiraAparicao, Peso, Imagem, PersonagemOculto, Altura)
 VALUES ('Inglaterra','cabecear','Peter Crouch','10/10/1980','WestHam',70,'https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Peter_Crouch_v_Chelsea_2014.jpg/200px-Peter_Crouch_v_Chelsea_2014.jpg',0,202)