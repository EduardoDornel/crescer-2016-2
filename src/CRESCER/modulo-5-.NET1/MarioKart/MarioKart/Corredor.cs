using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public Corredor(String nome)
        {
            this.Nome = nome;
        }
        public String Nome { get; private set; }
        public NivelHabilidade NivelHab{ get; set; }
    }
}
