using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using StreetFighter.Dominio;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace StreetFighter.RepositorioEF
{
    
    public class DatabaseContext : DbContext
    {
        public DatabaseContext() : base("StreetFighterConnection")
        {

        }

        public DbSet<Personagem> Personagens { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
