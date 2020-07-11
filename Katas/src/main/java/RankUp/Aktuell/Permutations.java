package RankUp.Aktuell;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {
    public static List<String> singlePermutations(String s) {
        ArrayList<String> ausgabe=new ArrayList<>();
        ArrayList<String> sub=new ArrayList<>();
        ausgabe.add(s);
        for(int i=s.length()-1;i>-1;i--){
            for(int k=0;k<s.length()-i+1;k++) {
                final int nichtiI = i;
                final int nichtK = k;
                sub.parallelStream().forEach((s1) ->{
                            String string = s1;
                            ausgabe.add(string.replace(string.substring(nichtiI, nichtiI + nichtK)
                                    , new StringBuilder(string.substring(nichtiI, nichtiI + nichtK)).reverse()));
                        }
                );
                sub = (ArrayList<String>) ausgabe.clone();
            }
        }
        return ausgabe.stream().distinct().collect(Collectors.toList());
    }
}
