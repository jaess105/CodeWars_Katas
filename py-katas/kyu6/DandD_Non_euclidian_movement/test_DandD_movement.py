from unittest import TestCase

from kyu6.DandD_Non_euclidian_movement.DandD_movement import calc_distance


class Test(TestCase):

    def test_cardinal_directions(self):
        self.assertEquals(calc_distance([(2, 2, 0), (1, 2, 0)]), 5)
        self.assertEquals(calc_distance([(2, 2, 0), (0, 2, 0)]), 10)

    def test_diagonal_directions(self):
        self.assertEquals(calc_distance([(2, 2, 0), (1, 1, 0)]), 5)
        self.assertEquals(calc_distance([(2, 2, 0), (0, 0, 0)]), 10)

    def test_vertical(self):
        self.assertEquals(calc_distance([(0, 0, 0), (0, 0, 3)]), 15)
        self.assertEquals(calc_distance([(0, 0, 0), (1, 4, 5)]), 25)

    def test_negative(self):
        self.assertEquals(calc_distance([(0, 0, 0), (-2, -1, 0)]), 10)
        self.assertEquals(calc_distance([(0, 0, 0), (-3, -4, -2)]), 20)

    def test_path(self):
        self.assertEquals(calc_distance([(0, 0, 0), (4, 0, 0), (0, 2, 0), (0, 0, 0)]), 50)
