"""
Write a function that returns the greatest common factor of an array of positive integers.
Your return value should be a number, you will only receive positive integers.

greatestCommonFactor([46, 14, 20, 88]); // --> 2
"""
import math


def greatest_common_factor(seq):
    gcd_ = math.gcd(seq[0], seq[1])

