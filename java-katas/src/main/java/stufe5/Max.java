package stufe5;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence
 * in an array or list of integers:
 * <p>
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}); // should be 6: {4, -1, 2, 1} Easy case
 * is when the list is made up of only positive numbers and the maximum sum is the sum of the whole
 * array. If the list is made up of only negative numbers, return 0 instead.
 * <p>
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a
 * valid sublist/subarray.
 */
public class Max {

  public static int sequence(int[] arr) {
    List<Integer> ints = toList(arr);
    ints = ints.stream().dropWhile(x -> x <= 0).collect(Collectors.toList());
    removeNegativeElementsFromEnd(ints);
    int sum = getSum(ints);
    for (int i = 0; i < ints.size(); i++) {
      if (sum - ints.get(i) >= sum) {
        ints = max(ints, max(ints.subList(0, i), ints.subList(i + 1, ints.size())));
      }
    }
    return 0;
  }

  private static List<Integer> max(List<Integer> list1, List<Integer> list2) {
    return getSum(list1) > getSum(list2) ? list1 : list2;

  }

  private static int getSum(List<Integer> ints) {
    return ints.stream().mapToInt(x -> x).sum();
  }

  private static void removeNegativeElementsFromEnd(List<Integer> list) {
    for (int i = list.size() - 1; list.size() > 0; i++) {
      if (list.get(i) <= 0) {
        list.remove(i);
      }
    }
  }

  private static List<Integer> toList(int[] arr) {
    return Arrays.stream(arr).boxed().collect(Collectors.toList());
  }
}