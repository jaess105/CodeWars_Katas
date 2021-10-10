package stufe3;

import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/576986639772456f6f00030c/train/java You are at start location [0,
 * 0] in mountain area of NxN and you can only move in one of the four cardinal directions (i.e.
 * North, East, South, West). Return minimal number of climb rounds to target location [N-1, N-1].
 * Number of climb rounds between adjacent locations is defined as difference of location altitudes
 * (ascending or descending).
 * <p>
 * Location altitude is defined as an integer number (0-9).
 */
public class Finder {

  private final int[][] map;
  private final int[][] visited;
  private final int END_X;
  private final int END_Y;
  private int fastestAtEnd = Integer.MAX_VALUE;

  private Finder(int[][] map) {
    this.map = map;
    visited = toInfiniteMap(map);
    END_X = map.length - 1;
    END_Y = map[0].length - 1;
  }

  /**
   * A* klingt wie eine gute Idee. Ansonsten könnte man noch einen Algo schreiben, der immer den
   * Knoten mit der geringsten Heuristik erweitert. Also eine Art Branch and Bound. Klingt
   * sinnvoll.
   *
   * @param maze
   * @return
   */
  static int pathFinder(String maze) {
    final int[][] map = toMap(maze);
    Finder finder = new Finder(map);
    return finder.smallestDiff(0, 0, map[0][0], 0);
  }

  private int smallestDiff(int x, int y, int prev, int climbs) {
    /*if (x > END_X || y > END_Y || x < 0 || y < 0) {
      return -1;
    }*/
    final int current;
    try {
      current = map[x][y];
    } catch (IndexOutOfBoundsException e) {
      return -1;
    }
    climbs += abs(current - prev);
    if (x == END_X && y == END_Y) {
      if (climbs < fastestAtEnd) {
        fastestAtEnd = climbs;
      }
      return climbs;
    } else if (visited[x][y] > climbs && fastestAtEnd > climbs) {
      visited[x][y] = climbs;
      return min(
          smallestDiff(x + 1, y, current, climbs),
          smallestDiff(x, y + 1, current, climbs),
          smallestDiff(x - 1, y, current, climbs),
          smallestDiff(x, y - 1, current, climbs)
      );
    } else {
      return -1;
    }
  }

  private static int min(int... args) {
    return Arrays.stream(args).parallel()
        .filter(x -> x != -1)
        .min()
        .orElse(-1);
  }

  private static int[][] toInfiniteMap(int[][] map) {
    int maxValue = Integer.MAX_VALUE;
    return Arrays.stream(map).parallel()
        .map(arr -> IntStream.range(0, arr.length).parallel()
            .map(x -> maxValue)
            .toArray())
        .toArray(int[][]::new);
  }

  private static int[][] toMap(String a) {
    return Arrays.stream(a.split("\n")).parallel()
        .map(String::toCharArray)
        .map(x -> IntStream.range(0, x.length).parallel()
            .map(i -> Character.getNumericValue(x[i]))
            .toArray())
        .toArray(int[][]::new);
  }
}
