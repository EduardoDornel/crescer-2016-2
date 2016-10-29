using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor, List<IEquipamentos> listaEquipamentos = null) : base(corredor, listaEquipamentos)
        {
        }

        public override int Velocidade
        {
            get
            {
                for (int i = 0; i < ListaEquipamentos.Count; i++)
                {
                    somatorioBonusEquipamentos += ListaEquipamentos[i].Bonus;
                }
                //ganha velocidade + 3 se dirigido por um corredor Noob, perde 1 de velocidade se dirigido por um corredor Profissional
                int velocidadeBonus = KartCorredor.NivelHab == NivelHabilidade.Noob ? 3 : KartCorredor.NivelHab == NivelHabilidade.Profissional ? -1 : 0;
                return 3 + BonusHabilidade(base.KartCorredor) + somatorioBonusEquipamentos + velocidadeBonus;
            }
        }
    }
}
