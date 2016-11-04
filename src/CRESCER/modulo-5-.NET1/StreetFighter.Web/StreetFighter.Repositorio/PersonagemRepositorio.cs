using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();
        static string CaminhoArquivo = @"~/ListaDePersonagens.csv";

        public PersonagemRepositorio()
        {

        }

        public List<Personagem> ListarPersonagens(string filtro)
        {
            return Personagens.Where(personagem => personagem.Nome.Contains(filtro)).ToList();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            Personagens.Add(personagem);
            File.AppendAllText(CaminhoArquivo, Environment.NewLine + FormatarTexto(personagem));
        }

        public void EditarPersonagem(Personagem personagem)
        {
            /////////////////
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            /////////////////
        }

        private string FormatarTexto(Personagem personagem)
        {
            char pontoVirgula = ';';
            return personagem.Nome + pontoVirgula +
                   personagem.Origem + pontoVirgula +
                   personagem.Id + pontoVirgula +
                   personagem.GolpesEspeciais + pontoVirgula +
                   personagem.DataNascimento + pontoVirgula +
                   personagem.PrimeiraAparicao + pontoVirgula +
                   personagem.Peso + pontoVirgula +
                   personagem.Imagem + pontoVirgula +
                   personagem.PersonagemOculto + pontoVirgula +
                   personagem.Altura + pontoVirgula; 
        }
    }
}
