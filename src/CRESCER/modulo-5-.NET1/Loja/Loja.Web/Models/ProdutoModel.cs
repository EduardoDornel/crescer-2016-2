using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }
        [Required]
        public decimal Valor { get; set; }

        public List<ProdutoModel> ProdutosModel { get; set; } = new List<ProdutoModel>();

        public ProdutoModel(int id, string nome, decimal valor)
        {
            this.Id = id;
            this.Nome = nome;
            this.Valor = valor;
        }
        public ProdutoModel(List<Produto> produtos)
        {
            foreach (var produto in produtos)
            {
                ProdutosModel.Add(new ProdutoModel(produto.Id, produto.Nome, produto.Valor));
            }
        }

        public ProdutoModel()
        {

        }
    }
}