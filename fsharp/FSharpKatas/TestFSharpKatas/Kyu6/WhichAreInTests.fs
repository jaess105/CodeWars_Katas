namespace TestFSharpKatas.Kyu6

open FSharpKatas.Kyu6.WhichAreIn
open NUnit.Framework

module WhichAreInTests =
    // Helper function for the test
    let testInArray a1 a2 expectedOutput =
        let res = inArray a1 a2
        Assert.AreEqual(expectedOutput, res, $"{res} does not equal {expectedOutput}")

    [<TestFixture>]
    type Tests() =

        [<Test>]
        [<Description("should return the result for some values")>]
        member this.TestInArray() =
            testInArray
                [ "arp"; "live"; "strong" ]
                [ "lively"; "alive"; "harp"; "sharp"; "armstrong" ]
                [ "arp"; "live"; "strong" ]

            testInArray
                [ "xyz"; "live"; "strong" ]
                [ "lively"; "alive"; "harp"; "sharp"; "armstrong" ]
                [ "live"; "strong" ]

            testInArray
                [ "live"; "strong"; "arp" ]
                [ "lively"; "alive"; "harp"; "sharp"; "armstrong" ]
                [ "arp"; "live"; "strong" ]

            testInArray
                [ "live"; "strong"; "lyal"; "lysh"; "arp" ]
                [ "lively"; "alive"; "harp"; "sharp"; "armstrong" ]
                [ "arp"; "live"; "strong" ]
