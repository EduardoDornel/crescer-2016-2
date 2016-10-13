/****** Script for SelectTopNRows command from SSMS  ******/
SELECT * FROM EXERCICIOS.dbo.Empregado
SELECT * FROM EXERCICIOS.dbo.Cidade

select nomeEmpregado, DATEDIFF(MONTH, DataAdmissao, getDate()) as mesesTrabalhados
from EXERCICIOS.dbo.Empregado
where DataAdmissao BETWEEN CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982', 103);

select Cargo, count(1) as total
from EXERCICIOS.dbo.Empregado
group by Cargo 
order by total desc

select nome
 from EXERCICIOS.dbo.Cidade
 order by UF

