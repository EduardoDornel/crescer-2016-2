using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Karts;
using MarioKart;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class LightKartTest
    {
        [TestMethod]
        public void LightComCorredorNoobGanha3DeVelocidade()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidade.Noob));
            Assert.AreEqual(9, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorMedianoTemVelocidadeNormal()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidade.Mediano));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorProfissionalPerde1DeVelocidade()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidade.Profissional));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorMedianoEEquipamentoNaoEhAlterado()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidade.Mediano));
            light.Equipar(new PneusCouroDeDragao());
            Assert.AreEqual(10, light.Velocidade);
        }
    }
}
