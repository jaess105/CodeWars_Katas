from unittest import TestCase

from kyu7.leap_years.leap_years import isLeapYear


class Test(TestCase):

    def test1(self):
        self.assertEquals(isLeapYear(1984), True, 'Year 1984 was a leap year!')

    def test2(self):
        self.assertEquals(isLeapYear(2000), True, 'Year 2000 was a leap year!')

    def test3(self):
        self.assertEquals(isLeapYear(1234), False, 'Year 1234 was NOT a leap year!')

    def test4(self):
        self.assertEquals(isLeapYear(1100), False, 'Year 1100 was NOT a leap year!')
