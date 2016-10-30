using MarioKart;
using MarioKart.Equipamentos;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKartTest
{
    [TestClass]
    public class MotorABaseDeLavaTest
    {
        [TestMethod]
        public void MotorABaseDeLavaTemBonus3()
        {
            var motor = new MotorBaseDeLava();
            Assert.AreEqual(3, motor.Bonus);
        }
    }
}