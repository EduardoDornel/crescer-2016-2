using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var FichaTecnica = new FichaTecnicaModel();
            FichaTecnica.Nome = "Blanka";
            FichaTecnica.Imagem = "/Content/Images/blanka.png";
            FichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            FichaTecnica.DataNascimento = Convert.ToDateTime("12/02/1966");
            FichaTecnica.Altura = 192;
            FichaTecnica.Peso = 96;
            FichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia)";
            FichaTecnica.GolpesEspeciais = "Electric Thunder,Rolling Attack.";
            FichaTecnica.PersonagemOculto = true;
            return View(FichaTecnica);
        }

        public ActionResult Cadastro()
        {
            AdicionarPaises();

            return View();
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            AdicionarPaises();

            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Algo de errado não está certo!");
                return View("Cadastro");
            }
        }

        public ActionResult Sobre()
        {
            var SobreMim = new SobreModel();
            SobreMim.Nome = "Eduardo Dornel Ribas";
            SobreMim.Idade = 19;
            SobreMim.Telefone = "(51)9273-4285";
            SobreMim.NaturalDe = "Gravataí";
            SobreMim.GitHub = "https://github.com/EduardoDornel";
            SobreMim.Historia = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
            return View(SobreMim);
        }

        private void AdicionarPaises()
        {
            ViewData["Origem"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "ES", Text = "Espanha" },
                new SelectListItem() { Value = "AU", Text = "Austrália" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "DN", Text = "Dinamarca" },
                new SelectListItem() { Value = "MX", Text = "México" },
                new SelectListItem() { Value = "MR", Text = "Marrocos" }
            };
        }
    }
}