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
        ArrayList<String> sub=new ArrayList<>();
        ausgabe.add(s);
        for(int i=s.length()-1;i>-1;i--){
            final int nichtiI=i;
            sub.parallelStream().forEach((s1)->
            { String string=s1;
            ausgabe.add(string.replace(string.substring(nichtiI)
                    ,new StringBuilder(string.substring(nichtiI)).reverse()));
                    }
            );
            sub= (ArrayList<String>) ausgabe.clone();
        }
        ausgabe.stream().distinct().toArray();
        return ausgabe;
    }
}
