module FSharpKatas.Kyu6.MiniStringFuck

let inc (ctr: int) = if ctr >= 255 then 0 else ctr + 1
let dec (ctr: int) = if ctr <= 0 then 255 else ctr - 1

let interpret (code: string) =
    let rec interpretRec (code: string) (ctr: int) (res: char list) =
        match Seq.toList code with
        | [] -> res
        | op :: rest when op = '+' -> interpretRec (rest |> System.String.Concat) (inc ctr) res
        | op :: rest when op = '_' -> interpretRec (rest |> System.String.Concat) (dec ctr) res
        | op :: rest when op = '.' ->
            let c: char = (char ctr)
            interpretRec (rest |> System.String.Concat) ctr ([ c ] |> List.append res)
        | _ :: rest -> interpretRec (rest |> System.String.Concat) ctr res

    let result = (interpretRec code 0 [])
    result |> System.String.Concat
