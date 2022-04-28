List<List<int>> pyramid(int n) => [
    for (var i = 1; i <= n; i++) [for (var j = 1; j <= i; j++) 1]
  ];
