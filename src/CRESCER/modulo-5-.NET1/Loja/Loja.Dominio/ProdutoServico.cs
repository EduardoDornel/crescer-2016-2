using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico 
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public void SalvarProduto(Produto produto)
        {
            produtoRepositorio.SalvarProduto(produto);
        }

        public List<Produto> listarProdutos()
        {
            return produtoRepositorio.listarProdutos();
        }


    }
}
