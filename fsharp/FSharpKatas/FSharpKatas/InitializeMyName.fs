/// https://www.codewars.com/kata/5768a693a3205e1cc100071f/train/fsharp
module FSharpKatas.InitializeMyName



let initializeNames (name: string) : string =
    let split = name.Split ' '
    let len = split.Length

    match len with
    | n when n <= 2 -> name
    | _ ->
        split
        |> Array.mapi (fun i var ->
            match i with
            | 0 -> var
            | n when n = len - 1 -> var
            | _ -> $"{var[0]}.")
        |> String.concat " "
