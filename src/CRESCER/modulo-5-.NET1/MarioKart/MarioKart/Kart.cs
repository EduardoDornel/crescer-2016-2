using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public abstract class Kart
    {
        public Kart(Corredor corredor)
        {
            this.KartCorredor = corredor;
        }

        private int somatorioBonusEquipamentos;
        Corredor KartCorredor { get; set; }
        List<IEquipamentos> ListaEquipamentos{ get; set; }
        int Velocidade {
            get
            {
                for (int i = 0; i < ListaEquipamentos.Count; i++)
                {
                    somatorioBonusEquipamentos += ListaEquipamentos[i].Bonus;
                }
                return 3 + BonusHabilidade(KartCorredor) + somatorioBonusEquipamentos; // faltou a soma dos bonus de tds equipamentos
            }
        }

        private int BonusHabilidade(Corredor piloto)
        {
            if (piloto.NivelHab == NivelHabilidade.Noob)
                return 3;
            else if (piloto.NivelHab == NivelHabilidade.Mediano)
                return 5;
            else
                return 6 + ListaEquipamentos.Count;
        }
    }
}
