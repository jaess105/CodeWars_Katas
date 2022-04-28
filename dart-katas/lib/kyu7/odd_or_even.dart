//https://www.codewars.com/kata/5949481f86420f59480000e7/train/dart

String oddOrEven(List<int> array) =>
    array.reduce((x, y) => x + y).isEven ? "even" : "odd";
