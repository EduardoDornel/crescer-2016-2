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
            return View();
        }

        public ActionResult Cadastro()
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

    }
}