using Katas;
using NUnit.Framework;
using Assert = TestProject.Extensions.AssertExtensions;

namespace TestProject
{
    public class DubstepTest
    {
        [Test]
        public void Test1()
        {
            Assert.AreEqual("ABC", Dubstep.SongDecoder("WUBWUBABCWUB"));
        }

        [Test]
        public void Test2()
        {
            Assert.AreEqual("R L", Dubstep.SongDecoder("RWUBWUBWUBLWUB"));
        }
    }
}