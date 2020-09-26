package Fundamentals;
/*
Count the number of Duplicates

        Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
        Example

        "abcde" -> 0 # no characters repeats more than once
        "aabbcde" -> 2 # 'a' and 'b'
        "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
        "indivisibility" -> 1 # 'i' occurs six times
        "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
        "aA11" -> 2 # 'a' and '1'
        "ABBA" -> 2 # 'A' and 'B' each occur twice
*/

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        return (int) text.toLowerCase()
                .chars()
                .distinct()
                .mapToObj(x -> String.valueOf((char) x))
                .collect(toList())
                .stream()
                .filter(string->text.toLowerCase().replaceFirst(string,"").contains(string))
                .count();
        //First every element of text is converted to lower case.
        //then it is converted to an IntStream by chars()
        //now we convert it to a list only containing distinct elements of text
        //the filter throws out every element that is not at least twice inside the original string
        //now we return how many elements are left inside the list
    }
}

