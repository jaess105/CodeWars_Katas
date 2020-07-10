package Kata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, int k) {
        //Die person an der kten stelle wird als erstes getötet und danach die person,
        // die von dieser Person so viele stellen entfernt war. Es wird zwar von
        // dieser Person aus gezählt diese Person wird aber nicht mitgezählt
        //Daher ergibt es Sinn k-1 punkte weiter im bereits modifizierten array.
        int nTE=k-1, itemsSize=items.size(), counter=0;
        List <T> ausgabe=new ArrayList<>();
        ausgabe.add(items.get(nTE));
        for(int i=1;i<itemsSize;i++){
            nTE+=k;
            if(nTE>=itemsSize){
                nTE-=itemsSize+1;

            }
            ausgabe.add(items.get(nTE));
        }
        return ausgabe;
    }
}

