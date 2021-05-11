package RankUp.stufe2;

/**
 * https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
 */

public class InsaneColouredTriangles {

  static int isR = 'G' + 'B';
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
}
