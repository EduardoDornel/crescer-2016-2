using MarioKart.Equipamentos;
using MarioKart;
using MarioKart.Karts;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKartTest
{
    [TestClass]
    public class DinamKartTest
    {
        [TestMethod]
        public void DinamComNoobSemEquipamentosTemVelocidade9()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidade.Noob));
            Assert.AreEqual(9, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamComMotorABaseDeLavaECorredorProfissionalTemVelocidade20()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidade.Profissional));
            dinam.Equipar(new MotorBaseDeLava());
            Assert.AreEqual(20, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamComFoguetePlutonio3EPneuCouroDragaoECorredorMedianoTemVelocidade18()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidade.Mediano));
            dinam.Equipar(new FogueteDePlutonio(3));
            dinam.Equipar(new PneusCouroDeDragao());

            Assert.AreEqual(18, dinam.Velocidade);
        }
    }
}
