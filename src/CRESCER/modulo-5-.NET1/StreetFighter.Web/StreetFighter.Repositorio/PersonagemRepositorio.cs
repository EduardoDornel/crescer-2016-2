﻿using StreetFighter.Dominio;
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
        public static string CaminhoArquivo = @"C:\Users\Eduardo.Dornel.000\EDUARDO-crescer-2016-02\src\CRESCER\modulo-5-.NET1\StreetFighter.Web\StreetFighter.Repositorio\ListaPersonagens.csv";

        public PersonagemRepositorio()
        {

        }

         public List<Personagem> FileToList()
        {
            string line;
            System.IO.StreamReader file = new System.IO.StreamReader(CaminhoArquivo);
            while ((line = file.ReadLine()) != null)
            {
                string[] split = line.Split(';');
                Personagens.Add(new Personagem(
                    split[0],
                    split[1],
                    Int32.Parse(split[2]),
                    split[3],
                    DateTime.ParseExact(split[4], "dd-MM-yyyy HH:mm:ss,fff",
                                       System.Globalization.CultureInfo.InvariantCulture),
                    split[5],
                    System.Convert.ToDecimal(split[6]),
                    split[7],
                    Convert.ToBoolean(split[8]),
                    Int32.Parse(split[9])
                    ));
            }

            file.Close();
            return Personagens;
        }
        public List<Personagem> ListarPersonagens(string filtro)
        {
            return FileToList().Where(personagem => personagem.Nome.Contains(filtro)).ToList();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
           // int numeroLinhas = System.IO.File.ReadAllLines(CaminhoArquivo).Length;
            Random randNum = new Random();
            personagem.Id = randNum.Next() / 250;
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