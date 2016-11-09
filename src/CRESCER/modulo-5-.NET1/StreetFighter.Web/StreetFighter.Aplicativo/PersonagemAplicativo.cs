using StreetFighter.Dominio;
using StreetFighter.RepositorioEF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly PersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        public List<Personagem> ListarPersonagens(string filtro = "")
        {
            return repositorio.ListarPersonagens(filtro);
        }

        public Personagem buscaPorId(int id)
        {
            return repositorio.BuscarPorId(id);
        }

        public void Salvar(Personagem personagem)
        {
            repositorio.SalvarPersonagem(personagem);
        }
    }
}
