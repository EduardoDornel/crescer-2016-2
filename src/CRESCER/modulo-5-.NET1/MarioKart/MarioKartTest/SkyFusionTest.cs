using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Hibridos;
using MarioKart;
using MarioKart.Karts;
using MarioKart.Equipamentos;

namespace UnitTestProject1
{
    [TestClass]
    public class SkyFusionTest
    {
        [TestMethod]
        public void SkyFusionComPneuDeCouroDeDragaoENoobDa2DeBonus()
        {
            var skyFusion = new SkyFusion(
                new Corredor("Mario", NivelHabilidade.Noob));

            skyFusion.Equipar(new PneusCouroDeDragao());

            var kart = new ClearKart(new Corredor("Luigi", NivelHabilidade.Noob));
            kart.Equipar(skyFusion);

            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void SkyFusionComUltraPackEMotorDeLavaEProfissionalDa8DeBonus()
        {
            var skyFusion = new SkyFusion(
                new Corredor("Mario", NivelHabilidade.Profissional));

            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(1)));
            skyFusion.Equipar(new MotorBaseDeLava());

            var kart = new ClearKart(new Corredor("Luigi", NivelHabilidade.Noob));
            kart.Equipar(skyFusion);

            Assert.AreEqual(16, kart.Velocidade);
        }
    }

    class ClearKart : Kart
    {
        public ClearKart(Corredor corredor) : base(corredor)
        {

        }
    }
}