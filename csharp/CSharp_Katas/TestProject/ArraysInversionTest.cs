using Katas;
using NUnit.Framework;
using Assert = TestProject.Extensions.AssertExtensions;


namespace TestProject
{
    [TestFixture]
    public class ArraysInversionTest
    {
        [Test]
        public void BasicTests()
        {
            Assert.AreEqual(new int[] { -1, -2, -3, -4, -5 },
                ArraysInversion.InvertValues(new int[] { 1, 2, 3, 4, 5 }));
            Assert.AreEqual(new int[] { -1, 2, -3, 4, -5 },
                ArraysInversion.InvertValues(new int[] { 1, -2, 3, -4, 5 }));
            Assert.AreEqual(new int[] { }, ArraysInversion.InvertValues(new int[] { }));
            Assert.AreEqual(new int[] { 0 }, ArraysInversion.InvertValues(new int[] { 0 }));
        }
    }
}