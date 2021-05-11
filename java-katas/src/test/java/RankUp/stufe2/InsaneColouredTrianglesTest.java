package RankUp.stufe2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Abgeschlossen.Kata;
import org.junit.jupiter.api.Test;

public class InsaneColouredTrianglesTest {

  @Test
  public void examples() {
    assertEquals('B', InsaneColouredTriangles.triangle("B"));
  }

  @Test
  void test1() {
    assertEquals('R', InsaneColouredTriangles.triangle("GB"));
}

  @Test
  void test2() {
//    assertEquals('R', InsaneColouredTriangles.triangle("RRR"));
    assertThat(InsaneColouredTriangles.triangle("RRR")).isEqualTo('R');
  }

  @Test
  void test3() {
    assertEquals('B', InsaneColouredTriangles.triangle("RGBG"));
  }

  @Test
  void test4() {
    assertEquals('G', InsaneColouredTriangles.triangle("RBRGBRB"));
  }

  @Test
  void test5() {
    assertEquals('G', InsaneColouredTriangles.triangle("RBRGBRBGGRRRBGBBBGG"));
  }

  @Test
  void test6(){
    assertThat(Character.getNumericValue('R')).isEqualTo(27);
    assertThat(Character.getNumericValue('G')).isEqualTo(16);
    assertThat(Character.getNumericValue('B')).isEqualTo(11);
  }

}
