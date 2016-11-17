using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto2Evento_Dominio
{
    public class Usuario
    {
        public Usuario()
        {

        }

        public Usuario(string nome, string email, string telefone, DateTime dataNascimento, string documento)
        {
            this.Nome = nome;
            this.Email = email;
            this.Telefone = telefone;
            this.DataNascimento = dataNascimento;
            this.Documento = documento;
        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email{ get; set; }
        public string Telefone { get; set; }
        public DateTime DataNascimento { get; set; }
        public string Documento { get; set; }
        public bool Aprovado { get; set; }
        public DateTime DataAprovacao { get; set; }
    }
}
