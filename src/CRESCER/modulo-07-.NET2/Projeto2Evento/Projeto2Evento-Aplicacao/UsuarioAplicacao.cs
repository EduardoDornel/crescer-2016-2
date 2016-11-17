using Projeto2Evento.Repositorio;
using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto2Evento_Aplicacao
{
    public class UsuarioAplicacao
    {
        private readonly UsuarioRepositorio Repositorio;
        public UsuarioAplicacao()
        {
            this.Repositorio = new UsuarioRepositorio();
        }

        public void SalvarUsuario(Usuario usuario = null)
        {
            if(usuario != null)
                Repositorio.SalvarUsuario(usuario);
        }

        public List<Usuario> ListarUsuarios(bool aprovado)
        {
            return Repositorio.ListarUsuarios(aprovado);
        }

    }
}
