namespace Projeto2Evento.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Criartabelausuarioeadmin : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Admin",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        Senha = c.String(),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Telefone = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        Documento = c.String(),
                        Aprovado = c.Boolean(nullable: false),
                        DataAprovacao = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Usuario");
            DropTable("dbo.Admin");
        }
    }
}
