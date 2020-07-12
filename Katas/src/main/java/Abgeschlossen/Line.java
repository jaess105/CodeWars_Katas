package Kata;

public class Line {
    public String WhoIsNext(String[] names, int n) {
        long y=5,x=5,tmp=0;
        int pos=0;
        while (x<n){
            y*=2;
            x+=y;
        }
        y=x-y;
        x=(x-y)/5;
        while(y+x<n) {
            y+=x;
            pos++;
        }
        return names[pos];


        /*String ausgabe="";
        for(int i=0;i<names.length;i++){
            ausgabe+=names[i].charAt(0);
        }
        int pos=0;
        while(ausgabe.length()<n) {
            ausgabe+=ausgabe.charAt(pos)+""+ausgabe.charAt(pos);
            pos++;
        }
        for(int i=0;i<names.length;i++){
            if(ausgabe.charAt(n-1) ==names[i].charAt(0) ){
                ausgabe=names[i];
                i=names.length;
            }
        }
        return ausgabe;

         */
    }
}
