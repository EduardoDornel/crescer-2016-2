using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Projeto2Evento.Startup))]
namespace Projeto2Evento
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
