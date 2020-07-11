package RankUp.Aktuell;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {
    public static List<String> singlePermutations(String s) {
        ArrayList<String> ausgabe=new ArrayList<>();
        ausgabe.add(s);
        while(s.length()>2){
            ausgabe.addAll(singlePermutations(s.substring(1)));
        }
        int iterations=0,goalIterations=s.length();
        while(iterations<goalIterations){
            for(int i=0;i<s.length()-1;i++){
                s =
                new StringBuilder(s).replace(i,i+2,new StringBuilder(s.substring(i, i + 2)).reverse().toString()).toString();
                ausgabe.add(s);
                System.out.println(s);
            }
            iterations++;
        }
        return ausgabe.stream().distinct().collect(Collectors.toList());
    }
}
