package Fundamentals;
/*
Return the number (count) of vowels in the given string.
We will consider a, e, i, o, u as vowels for this Kata (but not y).
The input string will only consist of lower case letters and/or spaces.
https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java
*/

import java.util.Arrays;

public class Vowels {

    public static int getCount(String str) {
        String vowels="aeiou";
        return (int)(str).chars()
                .mapToObj(character->String.valueOf((char)character))
                .filter(character->vowels.contains(character))
                .count();
    }
}