using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Sonar : Kart
    {
        public Sonar(Corredor corredor, List<IEquipamentos> listaEquipamentos = null) : base(corredor, listaEquipamentos)
        {
        }

        public override int Velocidade
        {
            get
            {
                int lengthLista = ListaEquipamentos.Count;
                for (int i = 0; i < lengthLista; i++)
                {
                    somatorioBonusEquipamentos += ListaEquipamentos[i].Bonus;
                }
                return 3 + BonusHabilidade(base.KartCorredor) + somatorioBonusEquipamentos + (lengthLista > 0 ? 2 : 0);
            }
        }
    }
}
