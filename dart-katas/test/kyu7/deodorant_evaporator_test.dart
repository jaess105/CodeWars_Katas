// See https://pub.dartlang.org/packages/test
import 'package:dart_katas/kyu7/deodorant_evaporator.dart';
import "package:test/test.dart";


void main() {
  test("Sample Test Cases", () {
    expect(evaporator(10, 10, 10), equals(22));
    expect(evaporator(10, 10, 5), equals(29));
    expect(evaporator(100, 5, 5), equals(59));
  });
}