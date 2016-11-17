using Projeto2Evento.Models;
using Projeto2Evento.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Projeto2Evento.Filters
{
    public class Autorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            AdminModel admin = ServicoDeAutenticacao.AdminLogado;
            if (admin == null) return false;
            return true;
        }
        protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        {
            filterContext.Result = new RedirectResult("Index");
        }
    }
}