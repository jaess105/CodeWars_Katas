package repetition;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {

  public static String reverseWords(String str){
    return new StringBuffer(Arrays.stream(str.split(" ")).map(x -> new StringBuffer(x).reverse())
        .collect(Collectors.joining(" "))).reverse().toString();
  }

  static String greet(String name, String owner) {
    return String.format("Hello %s", name.equals(owner)?"boss":"guest");
  }

  public static long[] powersOfTwo(int n){
    return IntStream.rangeClosed(0,n).mapToLong(x -> (long)Math.pow(2,x)).toArray();
  }

  public static String multiTable(int num) {
    return IntStream.range(1, 11).mapToObj(x -> x + " * " + num + " = " + x * num + "")
        .collect(Collectors.joining("\n"));
  }

  public static int[] flip(char dir, int[] arr) {
    Supplier<Comparator<Integer>> compare = (() -> dir == 'R' ? Integer::compareTo
        : Collections.reverseOrder());
    return Arrays.stream(arr).boxed().sorted(compare.get()).mapToInt(x -> x).toArray();
  }
}
