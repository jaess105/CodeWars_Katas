package stufe4.pathfinder;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5765870e190b1472ec0022a2 Task You are at position [0, 0] in maze
 * NxN and you can only move in one of the four cardinal directions (i.e. North, East, South, West).
 * Return true if you can reach position [N-1, N-1] or false otherwise.
 * <p>
 * Empty positions are marked .. Walls are marked W. Start and exit positions are empty in all test
 * cases.
 */
public class Finder {


  public static int shortestPathFinder(String mapStr) {
    return shortestPathFinder(toMap(mapStr), 0, 0, 0);
  }

  public static int shortestPathFinder(char[][] map, int x, int y, int pathLength) {
    int endX = map.length - 1;
    int endY = map[0].length - 1;
    if (x > endX || y > endY || x < 0 || y < 0) {
      return -1;
    } else if (x == endX && y == endY) {
      return pathLength;
    } else if (map[x][y] == 'W' || map[x][y] == 'V') {
      return -1;
    } else {
      map[x][y] = 'V';
      pathLength++;
      return min(
          shortestPathFinder(map, x + 1, y, pathLength),
          shortestPathFinder(map, x, y + 1, pathLength),
          shortestPathFinder(map, x - 1, y, pathLength),
          shortestPathFinder(map, x, y - 1, pathLength)
      );
    }
  }


  private static int min(int... args) {
    return Arrays.stream(args).filter(x -> x != -1).min().orElse(-1);
  }

  private static char[][] toMap(String a) {
    return Arrays.stream(a.split("\n")).map(String::toCharArray)
        .toArray(char[][]::new);
  }

  public static boolean pathFinder(String a) {
    char[][] map = toMap(a);
    return pathFinder(map, 0, 0);
  }

  /**
   * Rekursivly calling itself with all neigbours positions, if the current position is not a Wall
   * or has already been visited.
   *
   * @param map the map as chars
   * @param x   position currently visitung.
   * @param y   position currently visiting.
   * @return true if the goal is reachable from the current position and the pos has not been
   * visited yet.
   */
  private static boolean pathFinder(char[][] map, int x, int y) {
    int endX = map.length - 1;
    int endY = map[0].length - 1;
    if (x > endX || y > endY || x < 0 || y < 0) {
      return false;
    } else if (x == endX && y == endY) {
      return true;
    } else if (map[x][y] == 'W' || map[x][y] == 'V') {
      return false;
    } else {
      map[x][y] = 'V';
      return pathFinder(map, x + 1, y) ||
          pathFinder(map, x, y + 1) ||
          pathFinder(map, x - 1, y) ||
          pathFinder(map, x, y - 1);
    }
  }
}
