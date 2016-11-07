Create Table Movies
(
Id int PRIMARY KEY IDENTITY not null,
Title varchar(255) not null
)

insert into Movies(Title)
Values('Titanic')

select * from Movies