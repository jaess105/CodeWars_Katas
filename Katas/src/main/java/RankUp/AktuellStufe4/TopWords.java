package RankUp.AktuellStufe4;

/*
https://www.codewars.com/kata/51e056fe544cf36c410000fb
Write a function that, given a string of text (possibly with punctuation and line-breaks),
returns an array of the top-3 most occurring words, in descending order of the number of occurrences.
Assumptions:
A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
(No need to handle fancy punctuation.)
Matches should be case-insensitive, and the words in the result should be lowercased.
Ties may be broken arbitrarily.
If a text contains fewer than three unique words, then either the top-2 or top-1 words should be returned,
or an empty array if a text contains no words.
Examples:
top_3_words("In a village of La Mancha, the name of which I have no desire to call to
mind, there lived not long since one of those gentlemen that keep a lance
in the lance-rack, an old buckler, a lean hack, and a greyhound for
coursing. An olla of rather more beef than mutton, a salad on most
nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
on Sundays, made away with three-quarters of his income.")
# => ["a", "of", "on"]
top_3_words("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")
# => ["e", "ddd", "aa"]
top_3_words("  //wont won't won't")
# => ["won't", "wont"]
For java users, the calls will actually be in the form: TopWords.top3(String s), expecting you to return a List<String>.
Bonus points (not really, but just for fun):
    Avoid creating an array whose memory footprint is roughly as big as the input text.
    Avoid sorting the entire array of unique words.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopWords {

    public static List<String> top3(String text) {
        List<String> strings= (List<String>) Arrays.stream(text.split(" "))
                .map(string->string.chars()
                            .mapToObj(charachter->Character
                                    .toString(charachter)
                                    .replaceAll("[.:;,/-]",""))
                        .sorted()
                        .collect(Collectors.toList()));
        HashMap<Long,String> map=new HashMap<>();
        List<String> finalStrings = strings;
        strings.forEach((string1)->
                map.put(finalStrings.stream().filter(string2->string2.equals(string1)).count(),string1)
        );
        Long [] arr= map.keySet().toArray(new Long[0]);
        strings=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(!arr[i].equals(null)) {
                strings.add(map.get(arr[i]));
            }
        }
        return strings;
    }
}
