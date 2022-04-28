import "package:test/test.dart";
import 'package:dart_katas/kyu8/reverse_list_order.dart';

void main() {
  group("should reverse some sample arrays", () {
    test("sample array", () {
      expect(reverseList([1,2,3,4]), equals([4,3,2,1]));
    });
    test("sample array", () {
      expect(reverseList([3,1,5,4]), equals([4,5,1,3]));
    });
  });
}