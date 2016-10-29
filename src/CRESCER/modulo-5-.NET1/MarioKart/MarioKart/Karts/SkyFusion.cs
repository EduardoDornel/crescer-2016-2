using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamentos
    {
        public SkyFusion(Corredor corredor, List<IEquipamentos> listaEquipamentos = null) : base(corredor, listaEquipamentos)
        {
        }

        public int Bonus
        {
            get
            {
                int bonusRetornado = 0;
                if (KartCorredor.NivelHab == NivelHabilidade.Noob)
                    bonusRetornado = 1;
                else if (KartCorredor.NivelHab == NivelHabilidade.Mediano)
                    bonusRetornado = 2;
                else
                    bonusRetornado = 3;
                if (Velocidade > 12)
                    bonusRetornado += 5;
                return ListaEquipamentos.Count + bonusRetornado;
            }
        }
    }
}
