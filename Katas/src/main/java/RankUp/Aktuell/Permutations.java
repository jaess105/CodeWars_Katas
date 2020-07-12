package RankUp.Aktuell;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Permutations {
    //1. Start with last Element. Add one Element at its front.
    //2. let that element go to the last position of that string step by step.
    //3. Add every String that is createt this way.
    //4. now add the next Element of the enterd String and repeat from 2. for each.
    public static List<String> singlePermutations(String s) {
        ArrayList<String> listToReturn=new ArrayList<>();
        listToReturn.add(String.valueOf(s.charAt(s.length()-1)));
        for(int i=s.length()-2;i>-1;i--) {
            final ArrayList<String> tmpList = new ArrayList<>();
            final int finalI = i;
            listToReturn.forEach((string)->tmpList.add(new String(s.charAt(finalI) + string)));
            final ArrayList<String> tmpListToReturn = (ArrayList<String>) tmpList.clone();
            tmpList.forEach(string-> tmpListToReturn.addAll(moveFirstCharToLastPosition(string)));
            listToReturn= (ArrayList<String>) tmpListToReturn.clone();
        }
        return listToReturn.stream().distinct().collect(Collectors.toList());
    }
    private static List<String> moveFirstCharToLastPosition(String string){
        ArrayList<String> listOfAllThisWayCreatedStrings=new ArrayList<>();
        for(int i=0;i<string.length()-1;i++){
            string = switchSpots(string, i);
            listOfAllThisWayCreatedStrings.add(string);
        }
        return listOfAllThisWayCreatedStrings;
    }

    private static String switchSpots(String string, int i) {
        return new StringBuilder(string).replace(i, i + 2, new StringBuilder(string.substring(i, i + 2)).reverse().toString()).toString();
    }


    private static List<String> ersteImplementation(String s) {
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
