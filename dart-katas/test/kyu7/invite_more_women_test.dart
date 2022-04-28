import 'package:test/test.dart';
import 'package:dart_katas/kyu7/invite_more_women.dart';

void main() {
  group('Basic tests', () {
    test("Testing for [1, -1, 1]",
        () => expect(inviteMoreWomen([1, -1, 1]), equals(true)));
    test("Testing for [-1, -1, -1]",
        () => expect(inviteMoreWomen([-1, -1, -1]), equals(false)));
    test("Testing for [1, -1]",
        () => expect(inviteMoreWomen([1, -1]), equals(false)));
    test("Testing for [1, 1, 1]",
        () => expect(inviteMoreWomen([1, 1, 1]), equals(true)));
  });
  group('My Tests', () {
    test('simple test one person', () => expect(inviteMoreWomen([1]), true));
    test('one women one man', () => expect(inviteMoreWomen([1,-1]), false));
  });
}
