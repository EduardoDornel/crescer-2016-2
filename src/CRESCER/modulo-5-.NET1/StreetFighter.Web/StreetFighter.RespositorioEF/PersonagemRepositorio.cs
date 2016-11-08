using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using StreetFighter.RepositorioEF;
using System.Data;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorio
    {
        public PersonagemRepositorio()
        {

        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            using (var context = new DatabaseContext())
            {
                IQueryable<Personagem> query = context.Personagens.Where(p => p.Nome.Contains(filtro));
                return query.ToList();
            }
        }

        public Personagem BuscarPorId(int id)
        {
            using (var context = new DatabaseContext())
            {
                Personagem personagem = context.Personagens.Find(id);
                return personagem;
            }
        }

        public void SalvarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = System.Data.Entity.EntityState.Added;
                context.SaveChanges();
            }
        }


    }
}
