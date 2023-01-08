// https://www.codewars.com/kata/5d23d89906f92a00267bb83d/train/dart

const _menu = [
  "Burger",
  "Fries",
  "Chicken",
  "Pizza",
  "Sandwich",
  "Onionrings",
  "Milkshake",
  "Coke"
];

String getOrder(String input) => _menu
    .fold<Map<String, int>>(<String, int>{}, (map, order) {
      map[order] = order.toLowerCase().allMatches(input).length;
      return map;
    })
    .entries
    .fold<String>("", (str, entry) => str + ((entry.key + ' ') * entry.value))
    .trim();


