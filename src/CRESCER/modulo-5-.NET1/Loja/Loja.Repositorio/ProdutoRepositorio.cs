using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Loja.Dominio;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void SalvarProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = System.Data.Entity.EntityState.Added;
                context.SaveChanges();
            }
        }

        public List<Produto> listarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList();
            }
        }


    }
}
