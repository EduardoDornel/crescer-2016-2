using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Configuration;
using Projeto2Evento.Models;
using Projeto2Evento_Dominio;
using Projeto2Evento_Aplicacao;
using Projeto2Evento.Filters;
using Projeto2Evento.Services;

namespace Projeto2Evento.Controllers
{
    public class TelaPrincipalController : Controller
    {
        public ActionResult Index()
        {
          //  @ConfigurationManager.AppSettings.Set("VagasRestantes", Convert.ToString(Convert.ToInt32(ConfigurationManager.AppSettings["VagasRestantes"]) - 1));
            return View();
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }
        
      public ActionResult Salvar(UsuarioModel model)
        {
            if (ModelState.IsValid)
            {
                UsuarioAplicacao usuarioAplicacao = new UsuarioAplicacao();
                Usuario usuario = new Usuario(
                        model.Nome,
                        model.Email,
                        model.Telefone,
                        model.DataNascimento,
                        model.Documento
                    );
                usuarioAplicacao.SalvarUsuario(usuario);
                return View("Index");
            }
            else
            {
                ModelState.AddModelError("", "Algo de errado não está certo!");
                return View("Cadastro");
            }
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(string email, string senha)
        {
            Admin admin = new AdminAplicacao().BuscarPorAutenticacao(email, senha);

            if (admin != null)
            {
                ServicoDeAutenticacao.Autenticar(new AdminModel(admin.Email));
                return RedirectToAction("Index");
            }

            return RedirectToAction("Login");
        }

        [Autorizador]
        public ActionResult Listagens()
        {
            return View();
        }

        public JsonResult ListarPreInscritos()
        {
            List<Usuario> usuariosPreInscritos = new UsuarioAplicacao().ListarUsuarios(false);
            return Json(usuariosPreInscritos, JsonRequestBehavior.AllowGet);
        }
    }
}