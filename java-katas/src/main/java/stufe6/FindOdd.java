package stufe6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindOdd {

  public static int findIt(int[] a) {
    return Arrays.stream(a).boxed().collect(Collectors.groupingBy(x -> x))
        .entrySet().stream()
        .filter(x -> x.getValue().size() % 2 == 1)
        .mapToInt(x -> x.getValue().get(0))
        .sum();

  }
}
