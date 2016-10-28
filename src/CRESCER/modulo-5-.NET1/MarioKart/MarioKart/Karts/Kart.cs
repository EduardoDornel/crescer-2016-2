using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public abstract class Kart
    {
        public Kart(Corredor corredor)
        {
            this.KartCorredor = corredor;
        }

        internal int somatorioBonusEquipamentos;
        public Corredor KartCorredor { get; set; }
        public List<IEquipamentos> ListaEquipamentos{ get; set; }
        public virtual int Velocidade {
            get
            {
                for (int i = 0; i < ListaEquipamentos.Count; i++)
                {
                    somatorioBonusEquipamentos += ListaEquipamentos[i].Bonus;
                }
                return 3 + BonusHabilidade(this.KartCorredor) + somatorioBonusEquipamentos;
            }
        }

        internal int BonusHabilidade(Corredor piloto)
        {
            if (piloto.NivelHab == NivelHabilidade.Noob)
                return 3;
            else if (piloto.NivelHab == NivelHabilidade.Mediano)
                return 5;
            else
                return 6 + ListaEquipamentos.Count;
        }

        public void equipar(IEquipamentos equipament) {
            ListaEquipamentos.Add(equipament);
        }
    }
}
