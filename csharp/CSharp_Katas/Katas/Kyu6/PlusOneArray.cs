using System.Linq;

namespace Katas.Kyu6
{
    public static class PlusOneArray
    {
        public static int[] UpArray(int[] num)
        {
            if (num.Length == 0 || num.Any(x => x is < 0 or > 9))
            {
                return null;
            }

            if (num.All(x => x == 9))
            {
                var grownArray = new int [num.Length + 1];
                grownArray[0] = 1;
                return grownArray;
            }

            var arr = new int [num.Length];
            var carryOver = 1;
            for (var i = arr.Length - 1; i >= 0; i--)
            {
                var res = num[i] + carryOver;
                arr[i] = res % 10;
                carryOver = res / 10;
            }

            return arr;
        }
    }
}