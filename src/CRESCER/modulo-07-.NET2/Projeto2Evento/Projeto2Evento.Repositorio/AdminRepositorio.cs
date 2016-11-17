using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Projeto2Evento_Dominio;

namespace Projeto2Evento.Repositorio
{
    public class AdminRepositorio
    {
        public Admin BuscarPorAutenticacao(string email, string senha)
        {
            using (var contexto = new ContextoDeDados())
            {
                Admin admin = contexto.Admin.FirstOrDefault(u => u.Email == email);
                if (admin.Senha.Equals(senha))
                {
                    return admin;
                }
                return null;
            }
        }
    }
}
