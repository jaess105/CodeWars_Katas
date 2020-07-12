package Kata;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        for(int j=0;j<commentSymbols.length;j++){
            int ueberpruefen=text.indexOf("\n",text.indexOf(commentSymbols[j]));
            if(ueberpruefen==-1) ueberpruefen=text.length()-1;
            text=new String(text.substring(0,text.indexOf(commentSymbols[j]))).concat(text.substring(ueberpruefen,text.length()-1));
        }
        text=text.replaceAll(" \n","\n");
        if(text.charAt(text.length()-1)==' ') text=text.substring(0,text.length()-1);
        return text;
    }
}
