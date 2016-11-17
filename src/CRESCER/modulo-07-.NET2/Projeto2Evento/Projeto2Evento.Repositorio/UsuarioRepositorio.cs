using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace Projeto2Evento.Repositorio
{
    public class UsuarioRepositorio
    {
        public UsuarioRepositorio()
        {

        }
        public void SalvarUsuario(Usuario usuario)
        {
            usuario.DataAprovacao = new DateTime(2000, 1, 1);
            using (var contexto = new ContextoDeDados())
            {
                contexto.Usuario.Add(usuario);
                contexto.SaveChanges();
            }
        }

        public List<Usuario> ListarUsuarios(bool aprovado)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Usuario.Where(u => u.Aprovado == aprovado).ToList();
            }
        }




    }
}
