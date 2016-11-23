using Projeto2Evento.Filters;
using Projeto2Evento.Models;
using Projeto2Evento.Services;
using Projeto2Evento_Aplicacao;
using Projeto2Evento_Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Projeto2Evento.Controllers
{
    public class UsuarioController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Login()
        {
            return View();
        }

        [Autorizador]
        public ActionResult Listagens()
        {
            return View();
        }
        public PartialViewResult ListarPreInscritos()
        {
            UsuarioModel usuarioModel = new UsuarioModel(false);
            return PartialView("_ListaPreInscritos", usuarioModel.ListaUsuarios);
        }

        public PartialViewResult ListarInscritos()
        {
            UsuarioModel usuarioModel = new UsuarioModel(true);
            return PartialView("_ListaPreInscritos", usuarioModel.ListaUsuarios);
        }

        public PartialViewResult Aprovar(int id)
        {
            Usuario usuario = new AdminAplicacao().ConfirmarUsuario(id);
            return ListarInscritos();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(string email, string senha)
        {
            Admin admin = new AdminAplicacao().BuscarPorAutenticacao(email, senha);

            if (admin != null)
            {
                ServicoDeAutenticacao.Autenticar(new AdminModel(admin.Email));
                TempData["Mensagem"] = "Logado com sucesso";
                return RedirectToAction("Index", "TelaPrincipal");
            }

            TempData["Mensagem"] = "Usuário ou senha incorretos";
            return RedirectToAction("Login");
        }

    }
}