package stufe5;

/**
 * https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Max {

    public static int sequence(int[] arr) {
        List<Integer> ints = toList(arr);
        ints = removeNegativesFromStartAndEnd(ints);
        final List<Integer> possibleValues = new ArrayList<>();
        int sum = 0;
        boolean lastElementWasPos = false;
        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) < 0 && lastElementWasPos) {
                possibleValues.add(sum);
                int nextSequenceSum = sequence(subArray(ints, i));
                possibleValues.add(nextSequenceSum);
                lastElementWasPos = false;
            } else {
                lastElementWasPos = true;
            }
            sum += ints.get(i);
        }
        possibleValues.add(sum);
        return possibleValues.stream().max(Integer::compare).orElseGet(() -> 0);
    }

    private static int[] subArray(List<Integer> ints, int i) {
        return intListToArray(ints.subList(i, ints.size()));
    }

    private static List<Integer> removeNegativesFromStartAndEnd(List<Integer> ints) {
        ints = removeNegativesFromStart(ints);
        ints = removeNegativesFromEnd(ints);
        return ints;
    }

    private static List<Integer> removeNegativesFromStart(List<Integer> ints) {
        return ints.stream().dropWhile(x -> x <= 0).collect(Collectors.toList());
    }

    private static List<Integer> removeNegativesFromEnd(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0 && list.get(i) <= 0; i--) {
            list.remove(i);
        }
        return list;
    }


    private static int[] intListToArray(List<Integer> list) {
        return list.stream().mapToInt(x -> x).toArray();
    }

    private static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}