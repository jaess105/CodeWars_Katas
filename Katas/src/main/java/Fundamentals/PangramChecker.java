package Fundamentals;

import java.util.stream.Collectors;

//https://www.codewars.com/kata/545cedaa9943f7fe7b000048
public class PangramChecker {
    public boolean check(String sentence){
        for(char charachter : ("abcdefghijklmnopqesrtuvwxyz".toCharArray())) if(!sentence.toLowerCase().contains(String.valueOf(charachter))) return false;
        return true;
    }
    public boolean checkFirst(String sentence){
        return sentence.toLowerCase().chars().distinct().sorted().mapToObj(character->String.valueOf((char)(character))).collect(Collectors.joining("")).contains("abcdefghijklmnopqrstuvwxyz");
    }
}
