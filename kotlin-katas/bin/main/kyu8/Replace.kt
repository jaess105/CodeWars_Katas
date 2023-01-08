package kyu8

fun replace(s: String): String = s.replace("[aeiouAEIOU]".toRegex(), "!")