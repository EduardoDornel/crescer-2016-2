using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Projeto2Evento_Dominio;
using System.Data.Entity;
using System.Configuration;

namespace Projeto2Evento.Repositorio
{
    public class AdminRepositorio
    {
        public AdminRepositorio()
        {

        }
        public Admin BuscarPorAutenticacao(string email, string senha)
        {
            using (var contexto = new ContextoDeDados())
            {
                Admin admin = contexto.Admin.FirstOrDefault(u => u.Email == email);
                if (admin == null)
                {
                    return null;
                }
                else if (admin.Senha.Equals(senha))
                {
                    return admin;
                }
                return null;
            }
        }

        public Usuario ConfirmarUsuario(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                Usuario usuario = contexto.Usuario.FirstOrDefault(_ => _.Id == id);
                if (usuario != null)
                {
                    ConfigurationManager.AppSettings.Set("VagasRestantes", Convert.ToString(Convert.ToInt32(ConfigurationManager.AppSettings["VagasRestantes"]) - 1));
                    usuario.Aprovado = true;
                    usuario.DataAprovacao = DateTime.Now;
                    contexto.Entry<Usuario>(usuario).State = EntityState.Modified;
                    contexto.SaveChanges();
                    return usuario;
                }
            }
            return null;
        }

        public void ReprovarUsuario(Usuario usuario)
        {
            using (var contexto = new ContextoDeDados())
            {
                contexto.Usuario.Remove(usuario);
                contexto.SaveChanges();
            }
        }
    }
}
