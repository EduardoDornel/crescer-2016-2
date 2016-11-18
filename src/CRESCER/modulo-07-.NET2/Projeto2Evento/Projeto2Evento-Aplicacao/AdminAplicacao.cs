using Infraestrutura;
using Projeto2Evento.Repositorio;
using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto2Evento_Aplicacao
{
    public class AdminAplicacao
    {
        private readonly AdminRepositorio Repositorio;
        public AdminAplicacao()
        {
            this.Repositorio = new AdminRepositorio();
        }

        public Admin BuscarPorAutenticacao(string email, string senha)
        {           
            return Repositorio.BuscarPorAutenticacao(email, new ServicoDeCriptografia().Criptografar(senha));
        }

        public void ConfirmarUsuario(Usuario usuario)
        {
            Repositorio.ConfirmarUsuario(usuario);
        }

        public void ReprovarUsuario(Usuario usuario)
        {
            Repositorio.ReprovarUsuario(usuario);
        }

    }
}
