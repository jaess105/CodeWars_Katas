import 'dart:math';

int predictAge(int age1, int age2, int age3, int age4, int age5, int age6,
    int age7, int age8) {
  return sqrt([age1, age2, age3, age4, age5, age6, age7, age8]
          .map((e) => e * e)
          .reduce((x, y) => x + y)) ~/
      2;
}
