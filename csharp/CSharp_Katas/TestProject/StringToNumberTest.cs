using Katas;
using NUnit.Framework;
using Assert = TestProject.Extensions.AssertExtensions;

namespace TestProject
{
    [TestFixture]
    public class StringToNumberTest
    {
        [Test]
        public void test1()
        {
            Assert.AreEqual(1234, StringToNumberClass.StringToNumber("1234"));
        }

        [Test]
        public void test2()
        {
            Assert.AreEqual(605, StringToNumberClass.StringToNumber("605"));
        }

        [Test]
        public void test3()
        {
            Assert.AreEqual(1405, StringToNumberClass.StringToNumber("1405"));
        }

        [Test]
        public void test4()
        {
            Assert.AreEqual(-7, StringToNumberClass.StringToNumber("-7"));
        }
    }
}