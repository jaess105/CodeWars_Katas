module FSharpKatas.Kyu6.FindMinAndMax

let getMinMax (l: int list) =
    let rec getMinMaxRec (l: int list) (min: int) (max: int) =
        match l with
        | [] -> min, max
        | head :: next ->
            let newMin = if head < min then head else min
            let newMax = if head > max then head else max
            getMinMaxRec next newMin newMax

    match l with
    | [] -> (0, 0)
    | head :: next -> getMinMaxRec next head head
