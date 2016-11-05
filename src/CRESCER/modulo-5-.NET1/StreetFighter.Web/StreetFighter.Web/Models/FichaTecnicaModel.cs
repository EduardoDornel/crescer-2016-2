using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public int Id { get; set; }
        [DisplayName("Url da imagem")]
        public string Imagem { get; set; }

        [Required]
        public string Nome { get; set;}

        [Required]
        [DisplayName("Primeira Aparição")]
        public string PrimeiraAparicao { get; set; }

        [Required]
        [DisplayName("Data de nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public decimal Peso { get; set; }

        [Required]
        public string Origem { get; set; }

        [Required]
        [DisplayName("Golpes especiais")]
        public string GolpesEspeciais { get; set; }

        [Required]
        [DisplayName("Personagem é oculto?")]
        public bool PersonagemOculto { get; set; }
    }
}