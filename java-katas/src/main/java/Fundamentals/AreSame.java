package Fundamentals;

import java.util.Arrays;
import java.util.Optional;
//https://www.codewars.com/kata/550498447451fbbd7600041c/
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        return (a!=null&&b!=null)? Arrays.equals(Arrays.stream(a).map(integer->integer*integer).sorted().toArray(),Arrays.stream(b).sorted().toArray()):false;
    }
    public static boolean compFirst(int[] a, int[] b) {
        if(a==null || b == null) {
            return false;
        }
        a=Arrays.stream(a).map(integer->integer*integer).sorted().toArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
