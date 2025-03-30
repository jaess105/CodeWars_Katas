/// https://www.codewars.com/kata/586dd26a69b6fd46dd0000c0/train/fsharp
module FSharpKatas.Kyu6.MiniStringFuck

let interpret (code: string) =
    let rec interpretRec (code: char list) (ctr: int) (res: char list) =
        match Seq.toList code with
        | [] -> res
        | op :: rest when op = '+' -> interpretRec rest ((ctr + 1) % 256) res
        | op :: rest when op = '.' -> interpretRec rest ctr ([ (char ctr) ] |> List.append res)
        | _ :: rest -> interpretRec rest ctr res

    (interpretRec (Seq.toList code) 0 []) |> System.String.Concat
