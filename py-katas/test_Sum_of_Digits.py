from unittest import TestCase

from Sum_of_Digits import digital_root


class Test(TestCase):
    def test_digital_root(self):
        self.assertEqual(digital_root(16), 7)

    def test1(self):
        self.assertEqual(digital_root(942), 6)

    def test2(self):
        self.assertEqual(digital_root(132189), 6)

    def test3(self):
        self.assertEqual(digital_root(493193), 2)

