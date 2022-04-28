import 'package:test/test.dart';
import 'package:dart_katas/kyu6/pyramid_array.dart';

void main() {
  void tester(int n, List<List<int>> exp) =>
      test("Testing for $n", () => expect(pyramid(n), equals(exp)));

  test('0', () => expect(pyramid(0), equals([])));
  test('1',() => expect(pyramid(1),equals([[1]])));
  test('2',() => expect(pyramid(2),equals([[1],[1, 1]])));
  test('3',() => expect(pyramid(3),equals([[1],[1, 1],[1, 1, 1]])));

  group('basic tests', () {
    tester(0, []);
    tester(1, [
      [1]
    ]);
    tester(2, [
      [1],
      [1, 1]
    ]);
    tester(3, [
      [1],
      [1, 1],
      [1, 1, 1]
    ]);
  });
}
