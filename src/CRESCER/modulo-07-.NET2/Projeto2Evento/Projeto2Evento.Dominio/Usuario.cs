using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto2Evento.Dominio
{
    public class Usuario
    {
        public Usuario()
        {

        }

        public string Nome { get; set; }
        public string Email { get; set; }
        public string Telefone { get; set; }
        public DateTime DataNascimento { get; set; }
        public string Documento { get; set;}
    }
}
