from unittest import TestCase

from kyu6.Nth_Order_Summation.Nth_Order_Summation import s


class Test(TestCase):

    def testsmall(self):
        self.assertEquals(s(0, 53), 1)

    def test_small1(self):
        self.assertEquals(s(1, 49), 49)

    def test_small2(self):
        self.assertEquals(s(1, 101), 101)

    def test_small3(self):
        self.assertEquals(s(2, 5), 15)

    def test_small4(self):
        self.assertEquals(s(2, 99), 4950)

    def test_small5(self):
        self.assertEquals(s(3, 7), 84)

    def test_small6(self):
        self.assertEquals(s(3, 32), 5984)

    def test_small7(self):
        self.assertEquals(s(4, 8), 330)

    def test_small8(self):
        self.assertEquals(s(5, 17), 20349)

    def test_small9(self):
        self.assertEquals(s(10, 4), 286)

    def test_edge1(self):
        self.assertEquals(s(0, 1), 1)

    def test_edge2(self):
        self.assertEquals(s(1, 1), 1)

    def test_edge3(self):
        self.assertEquals(s(0, 10 ** 100), 1)

    def test_edge4(self):
        self.assertEquals(s(1, 10 ** 100), 10 ** 100)
