package stufe6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnoughIsEnough {

  public static int[] deleteNth(int[] elements, int maxOccurrences) {
    List<Integer> list = new ArrayList<>();
    Arrays.stream(elements).forEach(x -> {
      if (Collections.frequency(list, x) < maxOccurrences) {
        list.add(x);
      }
    });
    return list.stream().mapToInt(x -> x).toArray();
  }

}