using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public Corredor(String nome, NivelHabilidade nivelHabilidade)
        {
            this.Nome = nome;
            this.NivelHab = nivelHabilidade;
        }
        public String Nome { get; private set; }
        public NivelHabilidade NivelHab{ get; set; }
    }
}
