using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamentos
    {
        public FogueteDePlutonio(int niv)
        {
            this.nivel = niv;
        }
        private int nivel;

        public int Bonus
        {
            get
            {
                return nivel > 5 ? 2 : nivel < 1 ? 2 : nivel;
            }
        }
    }
}
