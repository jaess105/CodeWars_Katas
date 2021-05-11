package RankUp.stufe2;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
 */

public class InsaneColouredTriangles {


  static int isR = 'G' + 'B';
  static int isB = 'G' + 'R';
  static int isG = 'B' + 'R';

  public static void main(String[] args) {
    triangle("GBGBBBRGBRGBRGBRGBRGRBGRBBGRBBRBGRBBRGBBRGBRBGRBBRGBRGGRBRGRGBRGBRGRBBBRBBGRG");

  }


  public static char triangle(String row) {

    /*'R' 27 -> 0
      'G' 16 -> 2
      'B' 11 -> 1*/
    int max = 3 * row.length();
    int maxg = 2 * row.length();
    int maxb = 1 * row.length();
    int[] ints = row.chars().map(x -> x == 27 ? 0 : x == 16 ? 2 : 1).toArray();
    int sum = Arrays.stream(ints).sum();
    System.out.println(sum);
    System.out.println((sum) % 3);
    int i = (sum) % 3;

    return i == 1 ? 'B' : i == 2 ? 'G' : 'R';
//    return 'c'; //B
  }

  /*public static char triangle(String row) {
    char[] output = row.toCharArray();
    while (output.length > 1) {
      output = buildLine(output);
    }
    return output[0];
  }

  public static char[] buildLine(final char[] row) {
    char[] output = new char[row.length - 1];
    for (int i = 1; i < row.length; i++) {
      output[i - 1] = getColor(row[i - 1], row[i]);
    }
    return output;
  }

  public static char getColor(char a, char b) {
    if (a == b) {
      return a;
    } else {
      *//*
      assertThat(Character.getNumericValue('R')).isEqualTo(27);
      assertThat(Character.getNumericValue('G')).isEqualTo(16);
      assertThat(Character.getNumericValue('B')).isEqualTo(11);
      *//*
//      27 - a; //R=0 G=11 B=16
//      27 - b; //R=0 G=11 B=16
      int colorVal = a + b;
      if (colorVal == isG) {
        return 'G';
      } else if (colorVal == isB) {
        return 'B';
      } else {
        return 'R';
      }
    }
  }*/

  /*static int isR = 'G' + 'B';
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
      if (colorVal == isG) {
        return 'G';
      } else if (colorVal == isB) {
        return 'B';
      } else {
        return 'R';
      }
    }
  }*/
}
