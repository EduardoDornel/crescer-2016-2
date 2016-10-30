using MarioKart.Equipamentos;
using MarioKart.Karts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Hibridos
{
    public class SkyFusion : Kart, IEquipamentos
    {
        public SkyFusion(Corredor corredor) : base(corredor)
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
