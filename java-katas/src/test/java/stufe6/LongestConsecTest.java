package stufe6;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestConsecTest {

  private static void testing(String actual, String expected) {
    assertEquals(expected, actual);
  }

  @Test
  public void test() {
    testing(LongestConsec.longestConsec(
        new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2),
        "abigailtheta");
  }

  @Test
  @DisplayName("K = 1 one is the longest")
  void test2() {
    testing(LongestConsec.longestConsec(
        new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb",
            "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
  }

  @Test
  void test3() {
    testing(LongestConsec.longestConsec(new String[]{}, 3), "");
  }

  @Test
  void test4() {
    testing(LongestConsec.longestConsec(
        new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv",
            "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2),
        "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
  }

  @Test
  void test5() {
    testing(LongestConsec
            .longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2),
        "wlwsasphmxxowiaxujylentrklctozmymu");
  }

  @Test
  void test6() {
    testing(LongestConsec
        .longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");


  }

  @Test
  void test7() {
    testing(LongestConsec
            .longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3),
        "ixoyx3452zzzzzzzzzzzz");
  }

  @Test
  void test8() {
    testing(LongestConsec
        .longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
  }

  @Test
  void test9() {
    testing(LongestConsec
        .longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
  }


}