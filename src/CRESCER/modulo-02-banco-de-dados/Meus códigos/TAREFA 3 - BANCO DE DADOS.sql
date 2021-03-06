select nomeEmpregado, DATEDIFF(MONTH, DataAdmissao, getDate()) as mesesTrabalhados
from EXERCICIOS.dbo.Empregado
where DataAdmissao BETWEEN CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982', 103);

select top 1 WITH TIES Cargo,
       count(1) as total 
from EXERCICIOS.dbo.Empregado
group by Cargo
order by total desc 

select UF, count(1) as qtdCidades
 from EXERCICIOS.dbo.Cidade
 group by UF

 select nome, count(*) as nomesRepetidos
 from EXERCICIOS.dbo.cidade
  group by Nome, UF
  having count(*) > 1

  select isnull(max (IDAssociado), 0) + 1 as proximoId
  from EXERCICIOS.dbo.Associado

  select NomeEmpregado, salario,
  case when salario > 2326.0 then 27.5
	   when salario < 1164.0 then 0
	   else  15
	   end percentualIr
  from EXERCICIOS.dbo.Empregado


    
