/// https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/fsharp
module FSharpKatas.Kyu6.WhichAreIn


let anySubstrMatches (l: string seq) (el: string) =
    l |> Seq.exists (fun l_el -> l_el.Contains el)

let inArray (a1: string list) (a2: string list) =
    a1
    |> Seq.filter (a2 |> anySubstrMatches)
    |> Seq.distinct
    |> Seq.sort
    |> Seq.toList
