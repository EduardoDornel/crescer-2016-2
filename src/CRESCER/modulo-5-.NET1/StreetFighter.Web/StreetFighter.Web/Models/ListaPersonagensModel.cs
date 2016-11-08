using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;


namespace StreetFighter.Web.Models
{
    public class ListaPersonagensModel
    {
        public List<Personagem> ListaPersonagens { get; set; }

        public ListaPersonagensModel()
        {
            this.ListaPersonagens = new PersonagemAplicativo().ListarPersonagens();
        }

    }
}