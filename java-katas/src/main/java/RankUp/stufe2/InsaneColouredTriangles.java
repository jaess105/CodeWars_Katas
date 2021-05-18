package RankUp.stufe2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java Its not how its supposed to be
 * done. But why use your brian, if you can use brute force.
 */

public class InsaneColouredTriangles {

  private static char[] sequenzArray = generateSequenzeArraz();

  private static char[] generateSequenzeArraz() {
    char[] seq = new char[169];
    seq['R' + 'G'] = 'B';
    seq['G' + 'B'] = 'R';
    seq['B' + 'R'] = 'G';
    seq['R' + 'R'] = 'R';
    seq['G' + 'G'] = 'G';
    seq['B' + 'B'] = 'B';
    return seq;
  }

  public static char triangle(String row) {
    char[] charry = row.toCharArray();
    int length = charry.length - 1;
    char[] sb = new char[length];
    for (; length > 0; length--) {
      for (int i = 0; i < length; i++) {
        sb[i] = sequenzArray[(charry[i] + charry[i + 1])];
      }
      charry = sb;
    }
    return charry[0];
  }
}

 /* static int isR = 'G' + 'B';
  static int isB = 'G' + 'R';
  static int isG = 'B' + 'R';

  public static char triangle(String row) {
    while (row.length() > 1) {
      row = buildLine(row);
    }
    return row.charAt(0);
  }

  public static String buildLine(final String row) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < row.length(); i++) {
      sb.append(getColor(row.charAt(i - 1), row.charAt(i)));
    }
    return sb.toString();
  }


  public static char getColor(char a, char b) {
    if (a == b) {
      return a;
    } else {
      int colorVal = a + b;
      if ( colorVal == isG) {
        return 'G';
      } else if(colorVal == isB){
        return 'B';
      } else {
        return 'R';
      }
    }
  }
}*/
