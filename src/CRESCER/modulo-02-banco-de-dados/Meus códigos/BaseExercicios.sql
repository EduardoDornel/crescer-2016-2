select * from Cidade
select * from Cliente
select * from Material
select * from Pedido
select * from PedidoItem
select * from Produto
select * from ProdutoMaterial

select count(1) as pedidosSetembro2016
from Pedido
where dataPedido between convert(datetime, '2016/09/01', 101) and convert(datetime, '2016/09/30', 101)

select Nome
from Produto pro
INNER JOIN ProdutoMaterial prodM ON prodM.IDMaterial = 15836 and prodM.IDProduto = pro.IDProduto

select nome 
from Cliente
where RazaoSocial LIKE '%LTDA' or nome LIKE '%LTDA'

Insert into Produto(Nome, precoCusto, PrecoVenda, Situacao)
values('Galocha Maragato', 35.67, 77.95, 'A')

--5
/*select pro.nome
from Produto pro
LEFT OUTER JOIN PedidoItem pedItem ON pro.IDProduto = pedItem.IDProduto */

--6(N�o funciona)
select top 1 UF , count(*)as contaUf
from Cidade cid
INNER JOIN Cliente cli ON cli.IDCidade = cid.IDCidade
group by UF
order by contaUf desc

select IDPedido, dataEntrega
from  Pedido ped
INNER JOIN ProdutoMaterial prodM ON prodM.IDProduto = PedidoItem.IDProduto  
where prodM.IDMaterial = 14650 or prodM.IDMaterial = 15703 or prodM.IDMaterial = 17226 or
	prodM.IDMaterial = 15836 or prodM.IDMaterial = 16003 or prodM.IDMaterial = 16604