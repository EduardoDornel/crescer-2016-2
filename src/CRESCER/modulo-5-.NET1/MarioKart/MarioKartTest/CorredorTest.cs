using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNomeENivelHabilidadeNoob()
        {
            Corredor Piloto = new Corredor("yoshi", NivelHabilidade.Noob);

            Assert.AreEqual(Piloto.NivelHab, NivelHabilidade.Noob);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelHabilidadeMediano()
        {
            Corredor Piloto = new Corredor("luigi", NivelHabilidade.Mediano);

            Assert.AreEqual(Piloto.NivelHab, NivelHabilidade.Mediano);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelHabilidadeProfissional()

        {
            Corredor Piloto = new Corredor("lewis", NivelHabilidade.Profissional);

            Assert.AreEqual(Piloto.NivelHab, NivelHabilidade.Profissional);
        }
    }
}
