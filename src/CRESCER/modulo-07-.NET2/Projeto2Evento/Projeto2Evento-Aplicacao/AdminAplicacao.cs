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
        private readonly AdminRepositorio AdminRepositorio;

        public Admin BuscarPorAutenticacao(string email, string senha)
        {
            return AdminRepositorio.BuscarPorAutenticacao(email, senha);
        }

    }
}
