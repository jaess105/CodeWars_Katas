﻿using System;
using System.Linq;

namespace Katas
{
    public class ArraysInversion
    {
        public static int[] InvertValues(int[] input)
        {
            return input.Select(x => -x).ToArray();
        }

        
    }
}