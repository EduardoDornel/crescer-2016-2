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

        public UsuarioModel(int id, bool aprovado, string nome, string email, string telefone, DateTime dataNascimento, string documento)
        {
            this.Id = id;
            this.Aprovado = aprovado;
            this.Nome = nome;
            this.Email = email;
            this.Telefone = telefone;
            this.DataNascimento = dataNascimento;
            this.Documento = documento;
        }

        public UsuarioModel(bool aprovado)
        {
            ListaUsuarios = new List<UsuarioModel>();    
            List<Usuario> usuario = new UsuarioAplicacao().ListarUsuarios(aprovado);
            foreach (var item in usuario)
            {
                ListaUsuarios.Add(new UsuarioModel(item.Id, item.Aprovado, item.Nome, item.Email, item.Telefone, item.DataNascimento, item.Documento));
            }
        }

        public List<UsuarioModel> ListaUsuarios { get; set; }

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