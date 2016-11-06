using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListaPersonagens()
        {   

            return View();
        }

        public ActionResult Pesquisar(string filtro)
        {

            if (!String.IsNullOrEmpty(filtro))
            {
                return View(new PersonagemAplicativo().ListarPersonagens(filtro));
            }

            return View();
        }

        public ActionResult FichaTecnica(Personagem personagem)
        {
        var FichaTecnica= new FichaTecnicaModel();
            FichaTecnica.Nome = personagem.Nome;
            FichaTecnica.Imagem = personagem.Imagem;
            FichaTecnica.PrimeiraAparicao = personagem.PrimeiraAparicao;
            FichaTecnica.DataNascimento = personagem.DataNascimento;
            FichaTecnica.Altura = personagem.Altura;
            FichaTecnica.Peso = personagem.Peso;
            FichaTecnica.Origem = personagem.Origem;
            FichaTecnica.GolpesEspeciais = personagem.GolpesEspeciais;
            FichaTecnica.PersonagemOculto = personagem.PersonagemOculto;
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
                PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
                Personagem personagem = new Personagem(
                        model.Nome,
                        model.Origem,
                        model.Id,
                        model.GolpesEspeciais,
                        model.DataNascimento,
                        model.PrimeiraAparicao,
                        model.Peso,
                        model.Imagem,
                        model.PersonagemOculto,
                        model.Altura
                    );
                personagemAplicativo.Salvar(personagem);
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