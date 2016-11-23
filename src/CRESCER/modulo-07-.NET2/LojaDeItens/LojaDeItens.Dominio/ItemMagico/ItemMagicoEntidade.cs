using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Dominio.ItemMagico
{
    
    public class ItemMagicoEntidade
    {
        public ItemMagicoEntidade()
        {

        }

        public ItemMagicoEntidade(int? id, string nome, string descricao, decimal preco, int estoque, bool raro)
        {
            this.Id = id;
            this.Nome = nome;
            this.Descricao = descricao;
            this.Preco = preco;
            this.Estoque = estoque;
            this.Raro = raro;
        }

        public int? Id { get; set; }

        public string Nome { get; set; }

        public string Descricao { get; set; }

        public decimal Preco { get; set; }

        public int Estoque { get; set; }

        public bool Raro { get; set; }

        public DateTime DataCriacao { get; set; }
        public DateTime DataUltimaAtualizacao { get; set; }
    }

}
