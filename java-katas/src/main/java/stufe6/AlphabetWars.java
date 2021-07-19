package stufe6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/593e2077edf0d3e2d500002d/train/java Introduction There is a war and
 * nobody knows - the alphabet war! The letters called airstrikes to help them in war - dashes and
 * dots are spread everywhere on the battlefield.
 * <p>
 * Task Write a function that accepts reinforces array of strings and airstrikes array of strings.
 * The reinforces strings consist of only small letters. The size of each string in reinforces array
 * is the same. The airstrikes strings consists of * and white spaces. The size of each airstrike
 * may vary. There may be also no airstrikes at all.
 * <p>
 * The first row in reinforces array is the current battlefield. Whenever some letter is killed by
 * bomb, it's replaced by a letter from next string in reinforces array on the same position. The
 * airstrike always starts from the beginning of the battlefield. The * means a bomb drop place. The
 * each * bomb kills letter only on the battelfield. The bomb kills letter on the same index on
 * battlefield plus the adjacent letters. The letters on the battlefield are replaced after
 * airstrike is finished. Return string of letters left on the battlefield after the last airstrike.
 * In case there is no any letter left in reinforces on specific position, return _.
 */

public class AlphabetWars {

  public static String reinforcesMassacre(String[] reinforces, String[] airstrikes) {
    List<Set<Integer>> allStrikePos = Arrays.stream(airstrikes).map(AlphabetWars::getAllIndexes)
        .collect(Collectors.toList());
    List<StringBuilder> reinforcesSB = Arrays.stream(reinforces).skip(1).map(StringBuilder::new)
        .collect(Collectors.toList());
    StringBuilder division = new StringBuilder(reinforces[0]);
    allStrikePos.forEach(strikePos -> {
      bombStrike(strikePos, division);
      getReplacements(reinforcesSB, division);
    });
    return division.toString();
  }

  private static void getReplacements(List<StringBuilder> reinforcesSB, StringBuilder division) {
    for (int i = 0; i < division.length(); i++) {
      if (division.charAt(i) == '_') {
        char reinforcer = getReinforcement(reinforcesSB, i);
        division.setCharAt(i, reinforcer);
      }
    }
  }


  private static char getReinforcement(List<StringBuilder> reinforcments, int i) {
    for (StringBuilder reinforcment : reinforcments) {
      char reinforcer = reinforcment.charAt(i);
      if (reinforcer != '_') {
        reinforcment.setCharAt(i, '_');
        return reinforcer;
      }
    }
    return '_';
  }

  private static void bombStrike(Set<Integer> set, StringBuilder division) {
    set.forEach(x -> {
      int start = x != 0 ? x - 1 : 0;
      int end = x < division.length() - 2 ? x + 2 : x;
      String replacement = "_".repeat(end - start);
      division.replace(start, end, replacement);
    });
  }

  private static Set<Integer> getAllIndexes(String x) {
    Set<Integer> indexes = new HashSet<>();
    for (int index = 0; index > -1 && index < x.length(); index++) {
      index = x.indexOf('*', index);
      if (index == -1) {
        break;
      }
      indexes.add(index);
    }
    return indexes;
  }
}
