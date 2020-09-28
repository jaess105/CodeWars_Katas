package Fundamentals;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.asList(sentence.split(" "))
                .stream()
                .map(string->string.length() >= 5?string = new StringBuilder(string).reverse().toString():string)
                .collect(Collectors.joining(" "));
        //Array as List to use stream API. split into separate Strings at each space
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