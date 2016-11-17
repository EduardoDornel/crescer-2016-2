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
        private readonly UsuarioRepositorio UsuarioRepositorio;

        public void SalvarUsuario(Usuario usuario)
        {
            UsuarioRepositorio.SalvarUsuario(usuario);
        }

        public List<Usuario> ListarUsuarios(bool aprovado)
        {
            return UsuarioRepositorio.ListarUsuarios(aprovado);
        }


    }
}
