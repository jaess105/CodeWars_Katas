from unittest import TestCase

from kyu6.GCF import greatest_common_factor


class Test(TestCase):
    def test_case(self):
        self.assertEquals(greatest_common_factor([1, 8]), 1, "Should return 1")

    def test_1(self):
        self.assertEquals(greatest_common_factor([16, 4, 8]), 4, "Should return 4")

    def test_2(self):
        self.assertEquals(greatest_common_factor([46, 14, 20, 88]), 2, "Should return 2")

    def test_3(self):
        self.assertEquals(greatest_common_factor([468, 156, 806, 312, 442]), 26, "Should return 26")

    def test_4(self):
        self.assertEquals(greatest_common_factor([48, 99, 18]), 3, "Should return 3")

    def test_5(self):
        self.assertEquals(greatest_common_factor([32, 96, 120, 80]), 8, "Should return 8")

    def test_6(self):
        self.assertEquals(greatest_common_factor([91, 143, 234, 52]), 13, "Should return 13")

    def test_7(self):
        self.assertEquals(greatest_common_factor([171, 45, 297, 342]), 9, "Should return 9")
