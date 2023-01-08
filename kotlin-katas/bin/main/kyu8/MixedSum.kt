package kyu8

class MixedSum {

    /*
    * Assume input will be only of Int or String type
    */
    fun sum(mixed: List<Any>): Int = mixed
        .map { if (it is String) it.toInt() else it }
        .fold(0) { x, y -> if (y is Int) x + y else x }
}