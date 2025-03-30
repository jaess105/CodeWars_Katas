module TestFSharpKatas.Kyu6.WhichAreInTests

open FSharpKatas.Kyu6.WhichAreIn
open NUnit.Framework

module Tests =

    // Helper function for the test
    let testInArray a1 a2 expectedOutput =
        Assert.AreEqual(expectedOutput, inArray a1 a2)

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
