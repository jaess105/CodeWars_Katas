package Fundamentals;

//A bookseller has lots of books classified in 26 categories labeled A, B, ... Z.
// Each book has a code c of 3, 4, 5 or more characters.
// The 1st character of a code is a capital letter which defines the book category.
//In the bookseller's stocklist each code c is followed by a space and
// by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.

import java.util.Arrays;
import java.util.HashMap;

public class StockList {
    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] listOfArt, String[] listOf1stLetter) {
        HashMap<String,Integer> map=new HashMap<>();
        Arrays.stream(listOf1stLetter).forEach(str->map.put(str,0));
        Arrays.stream(listOfArt).forEach(art->{
            String category =String.valueOf(art.charAt(0));
            Integer artCount=Integer.parseInt((art.substring(art.indexOf(" ")+1)));
            map.computeIfPresent(category,(letter,count)->count+=artCount);
        });
        String output="";
        boolean hasValue=false;
        for(String category:map.keySet()){
            output+=" - ("+category+" : "+map.get(category)+")";
            if(map.get(category)>0){
                hasValue=true;
            }
        }
        return hasValue?output.replaceFirst(" - ",""):"";
    }
}
