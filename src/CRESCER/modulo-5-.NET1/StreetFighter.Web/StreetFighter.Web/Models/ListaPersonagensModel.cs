using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using StreetFighter.Dominio;

namespace StreetFighter.Web.Models
{
    public class ListaPersonagensModel
    {
        public List<Personagem> ListaDePersonagens { get; set; }

        public ListaPersonagensModel(List<Personagem> personagens)
        {
            this.ListaDePersonagens = personagens;
        }
    }
}