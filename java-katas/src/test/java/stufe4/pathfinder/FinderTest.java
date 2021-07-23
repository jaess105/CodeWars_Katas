package stufe4.pathfinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO: Replace examples and use TDD development by writing your own tests

class SolutionTest {

  @Test
  void myTest() {
    String d = "......\n" +
        "WWWWW.\n" +
        "......\n" +
        ".WWWWW\n" +
        "......\n" +
        "......";
    assertEquals(true, Finder.pathFinder(d));
  }

  @Test
  void testa() {
    String a = ".W.\n" +
        ".W.\n" +
        "...";
    assertEquals(true, Finder.pathFinder(a));
  }

  @Test
  void testb() {
    String b = ".W.\n" +
        ".W.\n" +
        "W..";
    assertEquals(false, Finder.pathFinder(b));
  }

  @Test
  void testc() {
    String c = "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        "......";
    assertEquals(true, Finder.pathFinder(c));
  }

  @Test
  void testd() {
    String d = "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        ".....W\n" +
        "....W.";
    assertEquals(false, Finder.pathFinder(d));
  }

  @Test
  void testa_shortest() {
    String a = ".W.\n" +
        ".W.\n" +
        "...";
    assertEquals(4, Finder.shortestPathFinder(a));
  }

  @Test
  void testb_shortest() {
    String b = ".W.\n" +
        ".W.\n" +
        "W..";
    assertEquals(-1, Finder.shortestPathFinder(b));
  }

  @Test
  void testc_shortest() {
    String c = "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        "......";

    assertEquals(10, Finder.shortestPathFinder(c));
  }

  @Test
  void testd_shortest() {
    String d = "......\n" +
        "......\n" +
        "......\n" +
        "......\n" +
        ".....W\n" +
        "....W.";

    assertEquals(-1, Finder.shortestPathFinder(d));
  }

}

