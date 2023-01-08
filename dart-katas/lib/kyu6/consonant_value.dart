// https://www.codewars.com/kata/59c633e7dcc4053512000073/train/dart

import 'dart:convert';

int solve(String s) {
  // your code here
  final liste = {
    for (int i = 97; i <= 122; i++) String.fromCharCode(i): i - 96
  };

  var erg = s
      .replaceAll(RegExp('[aeiou]'), ' ')
      .split(RegExp(' *'))
      .map((e) => e.map());
  return 1;
}
