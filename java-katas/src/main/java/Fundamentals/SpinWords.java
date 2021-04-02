package Fundamentals;
/*
https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces. Spaces will be included only when
more than one word is present.
Examples:
spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
 */
import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(string -> string.length() >= 5 ? string = new StringBuilder(string).reverse().toString() : string)
                .collect(Collectors.joining(" "));
        //Arrays stream to use stream API on String. split into separate Strings at each space
        //if string ist longer than 4 characters reverse the string else do nothing
        //collect the String array by joining it back to one String using space as separator
    }
}
/*
        String ausgabe="";
        for(String string:sentence.split(" ")) {
            if () {
                string = new StringBuilder(string).reverse().toString();
            }
            ausgabe+=string+" ";
        }
        return ausgabe.strip();
        */