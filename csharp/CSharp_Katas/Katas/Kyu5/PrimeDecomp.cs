using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Linq;

namespace Katas.Kyu5
{
    // https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/csharp
    public class PrimeDecomp
    {
        public static string factors(int lst)
        {
            var primeFactors = new Dictionary<int, int>();
            while (lst != 1)
            {
                var maxPrime = maxPrimeFactors(lst);
                primeFactors[maxPrime] = primeFactors.GetValueOrDefault(maxPrime, 0) + 1;
                lst /= maxPrime;
            }


            return String.Join("",
                primeFactors.ToImmutableSortedDictionary()
                    .Select(pair => pair.Value > 1 ? $"({pair.Key}**{pair.Value})" : $"({pair.Key})")
            );
        }

        // function to find largest prime factor
        static int maxPrimeFactors(int n)
        {
            // Initialize the maximum prime
            // factor variable with the
            // lowest one
            int maxPrime = -1;

            // Print the number of 2s
            // that divide n
            while (n % 2 == 0)
            {
                maxPrime = 2;

                // equivalent to n /= 2
                n >>= 1;
            }

            // n must be odd at this point
            while (n % 3 == 0)
            {
                maxPrime = 3;
                n = n / 3;
            }

            // now we have to iterate only for integers
            // who does not have prime factor 2 and 3
            for (int i = 5; i <= Math.Sqrt(n); i += 6)
            {
                while (n % i == 0)
                {
                    maxPrime = i;
                    n = n / i;
                }

                while (n % (i + 2) == 0)
                {
                    maxPrime = i + 2;
                    n = n / (i + 2);
                }
            }

            // This condition is to handle the case
            // when n is a prime number greater than 4
            if (n > 4)
                maxPrime = n;

            return maxPrime;
        }
    }
}