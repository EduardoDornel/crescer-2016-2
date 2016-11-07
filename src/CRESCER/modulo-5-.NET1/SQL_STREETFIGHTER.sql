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