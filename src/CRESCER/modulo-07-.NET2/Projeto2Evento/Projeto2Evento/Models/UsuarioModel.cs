using Projeto2Evento_Aplicacao;
using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
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
    }
}