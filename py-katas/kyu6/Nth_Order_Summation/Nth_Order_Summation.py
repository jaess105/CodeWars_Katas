"""https://www.codewars.com/kata/60d5b5cd507957000d08e673/train/python"""

from functools import lru_cache


@lru_cache(maxsize=None)
def s(m, n):
    if m == 0:
        return 1
    elif m == 1:
        return n
    elif m == 2:
        return n * (n + 1) / 2
    else:
        return sum(s(m - 1, x) for x in range(1, n + 1))

"""
My solution times out
working Solution:

from math import comb

def S(m, n):
    return comb(m+n-1, m)
"""
