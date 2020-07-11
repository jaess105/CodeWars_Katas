package RankUp.Aktuell;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {
    public static List<String> singlePermutations(String s) {
        // Your code here!
        //int start=0;
        ArrayList<String> liste=new ArrayList<>();
        for(Character character:s.toCharArray()){
            liste.add(character.toString());
        }
        ArrayList<String> ausgabe=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String neuerString=Character.toString(s.charAt(i));
            for(int k=0;k<s.length();k++){
                if(i==k) k++;
                if(k<s.length()) neuerString+=s.charAt(k);
            }
            ausgabe.add(neuerString);
        }

        return ausgabe;
    }
}
