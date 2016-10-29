using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamentos
    {
        public UltraPack(IEquipamentos equip)
        {
            Equipamento = equip;
        }
        public IEquipamentos Equipamento { get; set; }

        public int Bonus
        {
            get
            {
                double equipBonus = Convert.ToDouble(Equipamento.Bonus * 0.2);
                return Convert.ToInt32(Equipamento.Bonus + Math.Ceiling(equipBonus));
            }
        }
    }
}
