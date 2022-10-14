package stufe4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/train/java
 */
public class Range {
    public static String rangeExtraction(int[] arr) {
        // Use a double linked list to get constant access to the last element.
        final var groupedList = new LinkedList<LinkedList<Integer>>();
        groupedList.add(new LinkedList<>());

        return Arrays.stream(arr)
                .boxed()
                // Descending numbers are collected in one list. If they are not descending
                // a new List will be added with the new Element as input.
                .reduce(groupedList, (list, next) -> {
                            if (list.getLast().isEmpty() ||
                                    list.getLast().getLast() + 1 == next) {
                                list.getLast().add(next);
                            } else {
                                final var newList = new LinkedList<Integer>();
                                newList.add(next);
                                list.add(newList);
                            }
                            return list;
                        }, (a, b) -> {
                            a.addAll(b);
                            return a;
                        }
                )
                .stream()
                // If there are at least 3 Elements in a List, they are added as a Range,
                // else all elements are added.
                .map(list -> list.size() < 3 ?
                        list.stream().map(String::valueOf).collect(Collectors.joining(",")) :
                        list.getFirst() + "-" + list.getLast())
                // join the Ranges with commas.
                .collect(Collectors.joining(","));
    }


    public static void main(String[] args) {
        var range = Range.rangeExtraction(
                (new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
        );
        System.out.println(range);
    }
}
