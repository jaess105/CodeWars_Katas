package stufe6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java You are given an array(list)
 * strarr of strings and an integer k. Your task is to return the first longest string consisting of
 * k consecutive strings taken in the array.
 */

public class LongestConsec {


  public static String longestConsec(String[] strarr, int k) {
    return k <= 0 ? "" : IntStream.rangeClosed(0, strarr.length - k)
        .mapToObj(
            x -> Arrays.stream(strarr, x, x + k).collect(Collectors.joining())
        )
        .max(Comparator.comparingInt(String::length))
        .orElse("");
  }
}
