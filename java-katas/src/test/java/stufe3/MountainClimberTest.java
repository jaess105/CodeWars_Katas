package stufe3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stufe3.Finder;

class FinderTest {


  @Test
  void testa() {
    String a = "000\n" +
        "000\n" +
        "000";

    assertEquals(0, Finder.pathFinder(a));
  }

  @Test
  void testb() {
    String b = "010\n" +
        "010\n" +
        "010";

    assertEquals(2, Finder.pathFinder(b));

  }

  @Test
  void testc() {
    String c = "010\n" +
        "101\n" +
        "010";

    assertEquals(4, Finder.pathFinder(c));

  }

  @Test
  void testd() {
    String d = "0707\n" +
        "7070\n" +
        "0707\n" +
        "7070";

    assertEquals(42, Finder.pathFinder(d));

  }

  @Test
  void teste() {
    String e = "700000\n" +
        "077770\n" +
        "077770\n" +
        "077770\n" +
        "077770\n" +
        "000007";

    assertEquals(14, Finder.pathFinder(e));

  }

  @Test
  void testf() {
    String f = "777000\n" +
        "007000\n" +
        "007000\n" +
        "007000\n" +
        "007000\n" +
        "007777";

    assertEquals(0, Finder.pathFinder(f));
  }

  @Test
  void testg() {

    String g = "000000\n" +
        "000000\n" +
        "000000\n" +
        "000010\n" +
        "000109\n" +
        "001010";
    assertEquals(4, Finder.pathFinder(g));
  }



}
