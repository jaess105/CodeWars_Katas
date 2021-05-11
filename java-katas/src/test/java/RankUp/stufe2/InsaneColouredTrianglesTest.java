package RankUp.stufe2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Abgeschlossen.Kata;
import org.junit.jupiter.api.Test;

public class InsaneColouredTrianglesTest {
  @Test
  public void examples() {
    assertEquals('B', InsaneColouredTriangles.triangle("B"));
    assertEquals('R', InsaneColouredTriangles.triangle("GB"));
    assertEquals('R', InsaneColouredTriangles.triangle("RRR"));
    assertEquals('B', InsaneColouredTriangles.triangle("RGBG"));
    assertEquals('G', InsaneColouredTriangles.triangle("RBRGBRB"));
    assertEquals('G', InsaneColouredTriangles.triangle("RBRGBRBGGRRRBGBBBGG"));

  }




}
