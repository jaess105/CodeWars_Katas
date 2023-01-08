package kyu8

fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
    return if (input == null || input.isEmpty()) {
        emptyArray()
    } else {
        arrayOf(
            input.count { x -> x > 0 },
            input.filter { x -> x < 0 }.sum()
        )
    }
}
