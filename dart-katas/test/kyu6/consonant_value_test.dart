import 'package:test/test.dart';
import 'package:dart_katas/kyu6/consonant_value.dart';

void main() {
  group("Fixed tests", () {
    test("Testing for zodiac", () => expect(solve("zodiac"), equals(26)));
    test("Testing for chruschtschov", () => expect(solve("chruschtschov"), equals(80)));
    test("Testing for khrushchev", () => expect(solve("khrushchev"), equals(38)));
    test("Testing for strength", () => expect(solve("strength"), equals(57)));
    test("Testing for catchphrase", () => expect(solve("catchphrase"), equals(73)));
    test("Testing for twelfthstreet", () => expect(solve("twelfthstreet"), equals(103)));
    test("Testing for mischtschenkoana", () => expect(solve("mischtschenkoana"), equals(80)));
    test("Testing for az", () => expect(solve("az"), equals(26)));
  });
}