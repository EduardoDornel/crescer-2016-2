using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
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
                //dobra o bônus de velocidade que o kart ganha do corredor (e apenas do corredor).
                int bonusCorredor = KartCorredor.NivelHab == NivelHabilidade.Noob ? 3 :
                                KartCorredor.NivelHab == NivelHabilidade.Mediano ? 5 : 6;
                return 3 + BonusHabilidade(base.KartCorredor) + somatorioBonusEquipamentos;
            }
        }
    }
}
