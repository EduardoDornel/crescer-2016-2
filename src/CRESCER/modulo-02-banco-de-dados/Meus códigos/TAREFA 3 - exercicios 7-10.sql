select nomeEmpregado, DATEDIFF(MONTH, DataAdmissao, getDate()) as mesesTrabalhados
from Empregado
where DataAdmissao BETWEEN CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982', 103);

select top 1 WITH TIES Cargo,
       count(1) as total 
from Empregado
group by Cargo
order by total desc 

select UF, count(1) as qtdCidades
 from Cidade
 group by UF

 select nome, count(*) as nomesRepetidos
 from Cidade
  group by Nome, UF
  having count(*) > 1

  select isnull(max (IDAssociado), 0) + 1 as proximoId
  from Associado

  select NomeEmpregado, salario,
  case when salario > 2326.0 then 27.5
	   when salario < 1164.0 then 0
	   else  15
	   end percentualIr
  from Empregado

  select emp.nomeEmpregado as nomeEmpregado,
	   dep.NomeDepartamento as empregadoDepartamento,
	   ger.nomeEmpregado as nomeGerente,
	   depGer.NomeDepartamento as gerenteDepartamento
from Empregado emp
INNER JOIN Empregado ger ON emp.idGerente = ger.idEmpregado
INNER JOIN Departamento dep ON dep.IDDepartamento = emp.IDDepartamento
INNER JOIN Departamento depGer ON depGer.IDDepartamento = ger.IDDepartamento

SELECT * INTO EmpregadoReajuste FROM Empregado

Update EmpregadoReajuste
set salario = salario * 0.145 + salario
where exists(select 1
			 from departamento
			 where departamento.idDepartamento = empregado.idDepartamento
			 and departamento.localizacao = 'Sao Paulo');

select sum(novoEmp.Salario) - sum(emp.Salario) as diferenca
	   from Empregado emp
	   INNER JOIN EmpregadoReajuste novoEmp ON emp.IDEmpregado = novoEmp.IDEmpregado


select top 1 IDDepartamento
from Empregado
where IDDepartamento is not null
order by salario desc