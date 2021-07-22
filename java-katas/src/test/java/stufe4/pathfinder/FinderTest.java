package stufe4.pathfinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO: Replace examples and use TDD development by writing your own tests

class SolutionTest {

  @Test
  void myTest() {
    String d =  "......\n" +
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
}

