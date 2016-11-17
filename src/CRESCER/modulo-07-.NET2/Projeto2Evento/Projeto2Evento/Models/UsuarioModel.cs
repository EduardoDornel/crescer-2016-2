using Projeto2Evento_Aplicacao;
using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Projeto2Evento.Models
{
    public class UsuarioModel
    {
        public UsuarioModel()
        {

        }

        public UsuarioModel(bool aprovado)
        {
            ListaUsuarios = new UsuarioAplicacao().ListarUsuarios(aprovado);
        }

        public List<Usuario> ListaUsuarios { get; set; }

        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Email { get; set; }


        [Required]
        public string Telefone { get; set; }

        [Required]
        [DisplayName("Data de nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public string Documento { get; set; }
        public bool Aprovado { get; set; }
        public DateTime DataAprovacao { get; set; }
    }
}