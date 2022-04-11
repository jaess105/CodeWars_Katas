// https://www.codewars.com/kata/58acfe4ae0201e1708000075/train/dart

bool inviteMoreWomen(List<int> list) =>
    list.where((element) => element == -1).length <
    list.where((element) => element == 1).length;
