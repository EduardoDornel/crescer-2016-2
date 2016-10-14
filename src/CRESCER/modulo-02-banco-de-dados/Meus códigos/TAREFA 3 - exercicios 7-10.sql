select * from Empregado
select * from Departamento

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
set salario = ((salario * 14.5)/100) + salario
where IDDepartamento = 10 or IDDepartamento = 30

select sum(novoEmp.Salario) - sum(emp.Salario) as diferenca
	   from Empregado emp
	   INNER JOIN EmpregadoReajuste novoEmp ON emp.IDEmpregado = novoEmp.IDEmpregado


select top 1 IDDepartamento
from Empregado
where IDDepartamento is not null
order by salario desc