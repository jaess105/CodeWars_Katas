using System;
using System.Linq;

namespace Katas
{
    public class Dubstep
    {
        public static string SongDecoder(string input)
        { 
            string output = String.Empty;
            string concat = String.Empty;
            foreach (var character in input)
            {
                concat += character;
                if (concat.Length > 2 && concat.Substring(concat.Length - 3).Equals("WUB"))
                {
                    output += (output.Length > 0 && output[output.Length - 1] != ' ' ? " " : "")
                              + concat.Substring(0, (concat.Length - 3));
                    concat = string.Empty;
                }
            }
            return (output.Trim() + (concat.Length > 0?" ":"") + concat).Trim();
        }
    }
}