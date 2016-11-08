namespace StreetFighter.RespositorioEF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Personagens",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Origem = c.String(),
                        GolpesEspeciais = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        PrimeiraAparicao = c.String(),
                        Peso = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Imagem = c.String(),
                        PersonagemOculto = c.Boolean(nullable: false),
                        Altura = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Personagens");
        }
    }
}
