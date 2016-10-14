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

/*ERRO
select pro.nome as nomeProduto
from Produto pro, ProdutoMaterial prodM
INNER JOIN Material mat ON mat.IDMaterial = prodM.IDProduto*/

select nome 
from Cliente
where RazaoSocial LIKE '%LTDA' or nome LIKE '%LTDA'

Insert into Produto(Nome, precoCusto, PrecoVenda, Situacao)
values('Galocha Maragato', 35.67, 77.95, 'A')


