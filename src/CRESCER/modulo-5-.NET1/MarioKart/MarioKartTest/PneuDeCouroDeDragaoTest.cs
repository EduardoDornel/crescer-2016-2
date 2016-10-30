using MarioKart.Equipamentos;
using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace MarioKartTest
{
    [TestClass]
    public class PneuDeCouroDeDragaoTest
    {
        [TestMethod]
        public void PneuDeCouroDeDragaoTem2DeBonus()
        {
            var pneu = new PneusCouroDeDragao();
            Assert.AreEqual(2, pneu.Bonus);
        }
    }
}
