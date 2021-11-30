package stufe6;

import static org.junit.jupiter.api.Assertions.*;
import static stufe6.FacebookLikes.*;

import org.junit.jupiter.api.Test;

class FacebookLikesTest {

  @Test
  public void staticTests() {
    assertEquals("no one likes this", whoLikesIt());
  }

  @Test
  void test1() {
    assertEquals("Peter likes this", whoLikesIt("Peter"));
  }

  @Test
  void test2() {
    assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
  }

  @Test
  void test3() {
    assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
  }

  @Test
  void test4() {
    assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
  }

}