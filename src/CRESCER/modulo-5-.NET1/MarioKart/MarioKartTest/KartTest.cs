using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void CorredorNoobSemEquipamentoFaz6Pontos()
        {
            Corredor Piloto = new Corredor("luigi");
            Piloto.NivelHab = NivelHabilidade.Noob;

            //Assert.AreEqual(6, );
        }
    }
}