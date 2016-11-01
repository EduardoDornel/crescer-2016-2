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
            var FichaTec = new FichaTecnicaModel();
            FichaTec.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            FichaTec.DataNascimento = Convert.ToDateTime("12/02/1966");
            FichaTec.Altura = 192;
            FichaTec.Peso = 96;
            FichaTec.Medidas = "B198, C120, Q172";
            FichaTec.TipoSanguineo = "B";
            FichaTec.HabilidadesEspeciais = "Caçar, Eletricidade";
            FichaTec.Gosta = "Frutas tropicais, Pirarucu, Sua mãe";
            FichaTec.Desgosta = "Army ants (espécie de formiga)";
            FichaTec.EstiloDeLuta = "Luta Selvagem autodidata (ArmyAnts) / Capoeira";
            FichaTec.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia)";
            FichaTec.FalaDeVitória = "\"Ver você em ação é uma piada!\"";
            FichaTec.SSF2Nickname = "\"A selvagem criança da natureza\"";
            FichaTec.SFA3Nickname = "\"A animal pessoa amazônica\"";
            FichaTec.SF4Nickname = "\"Guerreiro da selva\"";
            FichaTec.SFA3Stage = "Ramificação do Rio Madeira -pantano, Brasil(ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?)";
            FichaTec.SF2Stage = "Bacia do rio Amazonas (Brasil).";
            FichaTec.GolpesEspeciais = "Electric Thunder,Rolling Attack.";
            return View(FichaTec);
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
    }
}