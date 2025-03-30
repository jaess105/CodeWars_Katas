namespace TestFSharpKatas.Kyu7

open FSharpKatas.Kyu7.FindMinAndMax
open NUnit.Framework

module FindMinAndMaxTests =
    [<TestFixture>]
    type Tests() =
        [<Test>]
        [<Description("works as expected")>]
        member this.TestGetMinMax() =
            Assert.AreEqual((1, 1), getMinMax [ 1 ], "getMinMax [1]")
            Assert.AreEqual((1, 2), getMinMax [ 1; 2 ], "getMinMax [1;2]")
            Assert.AreEqual((1, 2), getMinMax [ 2; 1 ], "getMinMax [2;1]")
