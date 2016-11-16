using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Projeto2Evento_Dominio;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace Projeto2Evento.Repositorio
{
    public class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("Evento")
        {

        }

        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Admin> Admin{ get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
