using System;
using System.Collections.Generic;
using System.Linq;

namespace Katas.Kyu6
{
    public class Kata
    {
        public static string CreatePhoneNumber(int[] numbers)
        =>
        $"({numbers[0]}{numbers[1]}{numbers[2]}) {numbers[3]}{numbers[4]}{numbers[5]}-{numbers[6]}{numbers[7]}{numbers[8]}{numbers[9]}";
    }
}