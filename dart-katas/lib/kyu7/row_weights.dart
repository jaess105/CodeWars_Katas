// https://www.codewars.com/kata/5abd66a5ccfd1130b30000a9/train/dart

List<int> rowWeights(List<int> arr) =>
    arr.asMap().entries.fold(<int>[0, 0], (arr, entry) {
      entry.key % 2 == 0 ? arr[0] += entry.value : arr[1] += entry.value;
      return arr;
    });
