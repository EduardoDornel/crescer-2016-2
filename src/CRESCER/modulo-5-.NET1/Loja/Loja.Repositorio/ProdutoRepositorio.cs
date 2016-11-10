using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Loja.Dominio;
using System.Data;
using System.Data.Entity;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void Salvar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public List<Produto> ListarProdutos(string filtro = null)
        {
            using (var context = new ContextoDeDados())
            {
                IQueryable<Produto> query = null;

                if (filtro != null)
                {
                    query = context.Produto.Where(elem => elem.Nome.ToUpper().Contains(filtro.ToUpper()));
                }
                else
                {
                    query = context.Produto;
                }

                return query.ToList();
            }
        }

        public void Editar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void Excluir(int id)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(BuscarId(id)).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public Produto BuscarId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.FirstOrDefault(p => p.Id == id);
            }
        }

    }
}
