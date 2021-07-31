using System;
using System.Linq;

namespace Katas
{
    public class Kata
    {
        static void Main(string[] args)
        {
        }

        public static bool ValidatePin(string pin)
        {
            return pin.All(x => Char.IsDigit(x)) && pin.Length is 4 or 6;
        }
        
    }
}