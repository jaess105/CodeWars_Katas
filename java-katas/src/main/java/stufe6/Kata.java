package stufe6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Kata {

  /*
  You will be given an array of numbers.
  You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.
 */
  public static int[] sortArray(int[] array) {
    int[] ausgabe = Arrays.stream(array).filter(x -> x % 2 != 0).sorted().toArray();
    for (int i = 0, k = 0; i < array.length; i++) {
      if (array[i] % 2 != 0 ) {
        array[i] = ausgabe[k];
        k++;
      }
    }
    return array;
  }


}

