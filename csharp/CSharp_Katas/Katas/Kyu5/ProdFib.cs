using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Katas.Kyu5
{
    // https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/csharp
    public static class ProdFib
    {
        public static ulong[] productFib(ulong prod)
        {
            var fib = new List<ulong>() { 0, 1, 1 };
            int i = 3;
            for (; fib[i - 1] * fib[i - 2] < prod; i++)
            {
                fib.Add(fib[i - 1] + fib[i - 2]);
            }

            return new ulong[] {
                fib[i - 2], fib[i - 1],  (prod % (ulong) (fib[i - 1] * fib[i - 2]) == 0 ? 1 : 0UL)
            };
        }
    }
}
