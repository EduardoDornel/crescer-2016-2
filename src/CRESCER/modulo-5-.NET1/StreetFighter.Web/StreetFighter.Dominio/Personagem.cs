using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public string Nome { get; private set; }
        public string Origem { get; private set; }
        public int Id { get; set; } = 0;
        public string GolpesEspeciais { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public string PrimeiraAparicao { get; private set; }
        public decimal Peso { get; private set; }
        public string Imagem { get; private set; }
        public bool PersonagemOculto { get; private set; }
        public int Altura { get; private set; }

        public Personagem(string nome, string origem, int id, string golpesEspeciais, DateTime nascimento, string primeiraAparicao, decimal peso, string imagem, bool personagemOculto, int altura)
        {
            this.Id = id;
            this.Nome = nome;
            this.DataNascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
            this.PrimeiraAparicao = primeiraAparicao;
        }
    }
}
