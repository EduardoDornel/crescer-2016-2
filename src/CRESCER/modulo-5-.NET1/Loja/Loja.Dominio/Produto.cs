using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Produto
    {
        public Produto(string nome, decimal valor, int id = 0)
        {
            this.Nome = nome;
            this.Valor = valor;
            this.Id = id;
        }

        public Produto()
        {
                
        }
        public int Id { get; set; }

        public string Nome { get; set; }

        public decimal Valor { get; set; }


    }
}
