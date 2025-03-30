/// https://www.codewars.com/kata/5768a693a3205e1cc100071f/train/fsharp
module FSharpKatas.InitializeMyName



let initializeNames (name: string) : string =
    let words = name.Split([| ' ' |], System.StringSplitOptions.RemoveEmptyEntries) // Safe split
    let len = words.Length

    if len <= 2 then
        name
    else
        words
        |> Array.mapi (fun i word ->
            if i = 0 || i = len - 1 then
                word // First and last remain unchanged
            else
                $"{word[0]}.") // Middle names get abbreviated
        |> String.concat " "
