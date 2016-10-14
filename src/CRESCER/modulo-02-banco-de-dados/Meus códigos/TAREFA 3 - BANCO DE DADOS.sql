/****** Script for SelectTopNRows command from SSMS  ******/
SELECT * FROM master.dbo.Empregado
SELECT * FROM master.dbo.Cidade

select nomeEmpregado, DATEDIFF(MONTH, DataAdmissao, getDate()) as mesesTrabalhados
from master.dbo.Empregado
where DataAdmissao BETWEEN CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982', 103);

select top 1 Cargo, count(1) as total 
from master.dbo.Empregado
group by Cargo
order by total desc 

select UF, count(1) as qtdCidades
 from master.dbo.Cidade
 group by UF

 --Este não funciona
 select nome, count(*) as nomesRepetidos
 from master.dbo.cidade
  group by Nome
  order by nomesRepetidos desc

  select top 1 (IDAssociado + 1) as proximoId
  from master.dbo.Associado
  order by IDAssociado desc

  select NomeEmpregado, salario,
  case when salario > 2326.0 then 27.5
	   when salario < 1164.0 then 0
	   else  15
	   end percentualIr
  from master.dbo.Empregado


    
