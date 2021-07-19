package stufe6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlphabetWarsTest {

  private String[] reinforces = {"g964xxxxxxxx",
      "myjinxin2015",
      "steffenvogel",
      "smile67xxxxx",
      "giacomosorbi",
      "freywarxxxxx",
      "bkaesxxxxxxx",
      "vadimbxxxxxx",
      "zozofouchtra",
      "colbydauphxx"},
      aristrikes = {"* *** ** ***",
          " ** * * * **",
          " * *** * ***",
          " **  * * ** ",
          "* ** *   ***",
          "***   ",
          "**",
          "*",
          "*"};

  @Test
  public void testOne() {

    assertEquals("hi___fg", AlphabetWars.reinforcesMassacre(new String[]{"abcdefg", "hijklmn"},
        new String[]{"   *   ", "*  *   "}));

  }

  @Test
  void test2() {
    assertEquals("ccbaa",
        AlphabetWars.reinforcesMassacre(new String[]{"aaaaa", "bbbbb", "ccccc", "ddddd"},
            new String[]{"*", " *", "   "}));
  }

}