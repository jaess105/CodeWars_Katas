using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// https://www.codewars.com/kata/51b62bf6a9c58071c600001b
namespace Katas.Kyu6
{

    public static class RomanConvert
    {
        static Dictionary<int, string> numbers = new(){
            {1, "I"},
            {4, "IV"},
            {5, "V"},
            {9, "IX"},
            {10, "X"},
            {40, "XL"},
            {50, "L"},
            {90, "XC"},
            {100, "C"},
            {400, "CD"},
            {500, "D"},
            {900, "CM"},
            {1000, "M"},
        };

        public static string Solution(int n)
        {
            var res = "";
            while (n > 0)
            {
                int max = numbers.Select(x => x.Key)
                                 .Where(x => n >= x)
                                 .Max();
                n -= max;
                res += numbers[max];
            }
            return res;
        }
    }
}
