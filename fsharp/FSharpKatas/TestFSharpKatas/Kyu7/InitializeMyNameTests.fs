namespace TestFSharpKatas.Kyu7




open FSharpKatas.InitializeMyName
open NUnit.Framework

module InitializeMyNameTests =
    [<TestFixture>]
    type InitializeMyNameTests() =

        [<Description("Only first name")>]
        [<Test>]
        [<Order(1)>]
        member this.OnlyFirstName() =
            Assert.AreEqual("Dimitri", initializeNames "Dimitri")

        [<Description("No middle name")>]
        [<Test>]
        [<Order(2)>]
        member this.NoMiddleName() =
            Assert.AreEqual("Jack Ryan", initializeNames "Jack Ryan")

        [<Description("One middle name")>]
        [<Test>]
        [<Order(3)>]
        member this.OneMiddleName() =
            Assert.AreEqual("Lois M. Lane", initializeNames "Lois Mary Lane")

        [<Description("More middle names")>]
        [<Test>]
        [<Order(4)>]
        member this.MoreMiddleNames() =
            Assert.AreEqual("Alice B. C. Davis", initializeNames "Alice Betty Catherine Davis")
