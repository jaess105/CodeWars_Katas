from unittest import TestCase

from kyu7.Count_the_divisors_of_a_number import divisors


class Test(TestCase):

    def test1(self):
        self.assertEquals(divisors(1), 1)

    def test2(self):
        self.assertEquals(divisors(4), 3)

    def test3(self):
        self.assertEquals(divisors(5), 2)

    def test4(self):
        self.assertEquals(divisors(12), 6)

    def test5(self):
        self.assertEquals(divisors(30), 8)

    def test6(self):
        self.assertEquals(divisors(4096), 13)
