package kyu7

import java.util.stream.IntStream.range

fun fizzBuzz(n: Int): Array<String> = (1..n).map {
    if (it % 3 == 0 && it % 5 == 0) {
        "FizzBuzz"
    } else if (it % 3 == 0) {
        "Fizz"
    } else if (it % 5 == 0) {
        "Buzz"
    } else {
        it.toString()
    }
}.toTypedArray()
