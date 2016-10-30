using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject1
{
    [TestClass]
    public class SonnarKartTest
    {
        [TestMethod]
        public void SonnarSemEquipamentosTemVelocidadeNormal()
        {
            var sonnar = new Sonar(new Corredor("Mario", NivelHabilidade.Noob));
            Assert.AreEqual(6, sonnar.Velocidade);
        }

        [TestMethod]
        public void SonnarComPneuDeCouroDeDragaoGanha2DeVelocidade()
        {
            var sonnar = new Sonar(new Corredor("Mario", NivelHabilidade.Noob));
            sonnar.Equipar(new PneusCouroDeDragao());
            Assert.AreEqual(10, sonnar.Velocidade);
        }
    }
}