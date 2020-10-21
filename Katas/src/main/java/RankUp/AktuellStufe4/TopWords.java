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

import java.util.*;
import java.util.stream.Collectors;

public class TopWords {

    public static List<String> top3(String text) {
        text=text.replaceAll("[?_!.:;,/-]"," ");
        final var strings= Arrays.stream(text.split(" "))
                .map(string->string.chars().mapToObj(charachter->Character.toString(charachter)
                        .toLowerCase())
                        //.replaceAll("[?_!.:;,/-]",""))
                        .collect(Collectors.joining())
                        .replaceAll("^['.:;,/-]+",""))
                .filter(string->(!string.equals(""))).collect(Collectors.toList());
        HashMap<String,Long> map=new HashMap<>();
        strings.forEach((string1)->map.put(string1,strings.stream().filter(string2->string2.equals(string1)).count()));
//        map.keySet().forEach(System.out::println);

        String [] keys=new String[map.keySet().size()];
        keys=map.keySet().toArray(keys);
        boolean switched=true;
        while(switched) {
            switched=false;
            for (int i = 0; i < keys.length - 1; i++) {
                if (map.get(keys[i]) < map.get(keys[i + 1])) {
                    String tmp = keys[i];
                    keys[i] = keys[i + 1];
                    keys[i + 1] = tmp;
                    switched = true;
                }
            }
        }
        /*if(keys.length<1){
            return new ArrayList<>();
        }
        else if(keys.length<2){
            return Arrays.asList(keys[0]);
        }
        else if(keys.length<3){
            return Arrays.asList(keys[0],keys[1]);
        }
        else {
            return Arrays.asList((keys[0]), (keys[1]), (keys[2]));
        }
        */
        ArrayList<String> finalList=new ArrayList<>();
        Optional.ofNullable(keys[0]).ifPresent(string->finalList.add(string));
        Optional.ofNullable(keys[1]).ifPresent(string->finalList.add(string));
        Optional.ofNullable(keys[2]).ifPresent(string->finalList.add(string));
        return finalList;
    }

}
