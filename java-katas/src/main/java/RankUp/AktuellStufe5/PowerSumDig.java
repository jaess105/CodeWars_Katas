package RankUp.AktuellStufe5;

import java.util.ArrayList;
import java.util.List;

public class PowerSumDig {

    public static long powerSumDigTerm(int n) {
        List<Long> liste = new ArrayList<>();
        for (Long power = 2l; power < 20l; power++) {
            for (Long zuQuadrieren = 2l; 2l < 20; zuQuadrieren++) {
                Long querSumme = 0l;
                Long summeZuUeberpruefen = (long) Math.pow(zuQuadrieren, power);
                for (Character zahl : summeZuUeberpruefen.toString().toCharArray()) {
                    querSumme += Character.getNumericValue(zahl);
                }
                if (zuQuadrieren.equals(querSumme)) {
                    liste.add(summeZuUeberpruefen);
                }
            }
        }
        liste.sort(Long::compareTo);
        return liste.get(n - 1);
    }
}

