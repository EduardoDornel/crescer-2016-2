using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico : IProdutoRepositorio
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public void Salvar(Produto produto)
        {
            produtoRepositorio.Salvar(produto);
        }

        public List<Produto> ListarProdutos(string filtro = null)
        {
            return produtoRepositorio.ListarProdutos(filtro);
        }

        public void Editar(Produto produto)
        {
            produtoRepositorio.Editar(produto);
        }

        public void Excluir(int id)
        {
            produtoRepositorio.Excluir(id);
        }

        public Produto BuscarId(int id)
        {
            return produtoRepositorio.BuscarId(id);
        }
    }
}
