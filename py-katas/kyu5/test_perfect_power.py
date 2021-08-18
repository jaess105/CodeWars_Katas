from unittest import TestCase
from random import random, randrange
from math import log, floor

from kyu5.perfect_power import isPP


class Test(TestCase):
    def test_is_pp(self):

        self.assertEquals(isPP(4), [2, 2], "4 = 2^2")
        self.assertEquals(isPP(9), [3, 2], "9 = 3^2")
        self.assertEquals(isPP(5), None, "5 isn't a perfect power")

    def test_3(self):
        pp = [4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256, 289, 324,
              343,
              361, 400, 441, 484]
        for item in pp:
            self.assertTrue(isPP(item) is not None, "the perfect power " + str(item) + " wasn't recognized as one")

        for i in range(100):
            m = 2 + floor(random() * 255)
            k = 2 + floor(random() * log(268435455) / log(m))
            l = m ** k
            r = isPP(l)
            if r == None:
                self.assertTrue(r is not None)
                break
            elif r[0] ** r[1] != l:
                self.assertEquals(r[0] ** r[1], l,
                                  "your pair (" + str(r[0]) + ", " + str(r[1]) + ") doesn't work for " + str(l))
                break
        for i in range(100):
            l = randrange(65535);
            r = isPP(l);
            if r is not None and r[0] ** r[1] != l:
                self.assertEquals(r[0] ** r[1], l,
                                  "your pair (" + str(r[0]) + ", " + str(r[1]) + ") doesn't work for " + str(l))
                break
