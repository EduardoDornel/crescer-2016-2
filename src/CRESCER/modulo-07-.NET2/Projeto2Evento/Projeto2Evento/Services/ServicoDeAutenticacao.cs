using Projeto2Evento.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Projeto2Evento.Services
{
    public static class ServicoDeAutenticacao
    {
        private const string ADMIN_LOGADO_CHAVE = "ADMIN_LOGADO_CHAVE";
        public static void Autenticar(AdminModel admin)
        {
            HttpContext.Current.Session[ADMIN_LOGADO_CHAVE] = admin;
        }

        public static AdminModel AdminLogado
        {
            get
            {
                return (AdminModel)HttpContext.Current.Session[ADMIN_LOGADO_CHAVE];
            }
        }
    }
}