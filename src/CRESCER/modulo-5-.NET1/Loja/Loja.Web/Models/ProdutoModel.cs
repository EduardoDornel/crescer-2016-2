using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public decimal Valor { get; set; }

       // public List<ProdutoModel> produtoModel { get; set; }

        public ProdutoModel(Produto produto)
        {
            this.Nome = produto.Nome;
            this.Valor = produto.Valor;
        }
    }
}