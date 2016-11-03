using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        public string Imagem { get; private set; }
        public string Nome { get; private set; }
        public string PrimeiraAparicao { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; private set; }
        public decimal Peso { get; private set; }
        public string Origem { get; private set; }
        public string GolpesEspeciais { get; private set; }
        public bool PersonagemOculto { get; private set; }

        public Personagem(int id, string nome, string origem)
           : this(nome, origem)
        {
            this.Id = id;
        }

        public Personagem(string nome, string origem)
        {
            this.Nome = nome;
            this.Origem = origem;
        }
    }
}
